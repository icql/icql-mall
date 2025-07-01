package work.icql.icm.product.b.server.service.biz;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class FlowChart extends JFrame {
    // 节点类型枚举
    public enum NodeType {START, END, PROCESS, DECISION}

    // 节点类
    public static class FlowNode {
        String id;
        String text;
        int x, y;
        int width = 100, height = 60;
        NodeType type = NodeType.PROCESS;
        Color color = Color.LIGHT_GRAY;

        public FlowNode(String id, String text, int x, int y) {
            this.id = id;
            this.text = text;
            this.x = x;
            this.y = y;
        }

        public FlowNode(String id, String text, int x, int y, NodeType type) {
            this(id, text, x, y);
            this.type = type;
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, width, height);
        }
    }

    // 连接线类
    public static class FlowEdge {
        FlowNode source;
        FlowNode target;
        String label;
        Color color = Color.BLACK;

        public FlowEdge(FlowNode source, FlowNode target, String label) {
            this.source = source;
            this.target = target;
            this.label = label;
        }
    }

    // 流程图面板
    private final FlowChartPanel panel;

    public FlowChart() {
        setTitle("Java Flow Chart");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new FlowChartPanel();
        add(panel);

        // 添加示例节点和连接线
        initializeSampleFlow();
    }

    private void initializeSampleFlow() {
        FlowNode start = new FlowNode("start", "开始", 100, 50, NodeType.START);
        FlowNode process = new FlowNode("process", "处理数据", 100, 150);
        FlowNode decision = new FlowNode("decision", "检查条件", 100, 250, NodeType.DECISION);
        FlowNode end = new FlowNode("end", "结束", 100, 400, NodeType.END);

        panel.addNode(start);
        panel.addNode(process);
        panel.addNode(decision);
        panel.addNode(end);

        panel.addEdge(new FlowEdge(start, process, ""));
        panel.addEdge(new FlowEdge(process, decision, ""));
        panel.addEdge(new FlowEdge(decision, end, "是"));
        panel.addEdge(new FlowEdge(decision, process, "否"));
    }

    // 流程图绘制面板
    private static class FlowChartPanel extends JPanel {
        private final List<FlowNode> nodes = new ArrayList<>();
        private final List<FlowEdge> edges = new ArrayList<>();

        public void addNode(FlowNode node) {
            nodes.add(node);
            repaint();
        }

        public void addEdge(FlowEdge edge) {
            edges.add(edge);
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // 绘制连接线
            for (FlowEdge edge : edges) {
                drawEdge(g2d, edge);
            }

            // 绘制节点
            for (FlowNode node : nodes) {
                drawNode(g2d, node);
            }
        }

        private void drawNode(Graphics2D g, FlowNode node) {
            g.setColor(node.color);
            switch (node.type) {
                case START:
                    g.fillOval(node.x, node.y, node.width, node.height);
                    break;
                case END:
                    g.fillOval(node.x, node.y, node.width, node.height);
                    g.setColor(getBackground());
                    g.fillOval(node.x + 5, node.y + 5, node.width - 10, node.height - 10);
                    g.setColor(node.color);
                    break;
                case DECISION:
                    int[] xPoints = {node.x + node.width / 2, node.x + node.width,
                            node.x + node.width / 2, node.x};
                    int[] yPoints = {node.y, node.y + node.height / 2,
                            node.y + node.height, node.y + node.height / 2};
                    g.fillPolygon(xPoints, yPoints, 4);
                    break;
                default: // PROCESS
                    g.fillRoundRect(node.x, node.y, node.width, node.height, 20, 20);
            }

            // 绘制文本
            g.setColor(Color.BLACK);
            FontMetrics fm = g.getFontMetrics();
            int textWidth = fm.stringWidth(node.text);
            int textX = node.x + (node.width - textWidth) / 2;
            int textY = node.y + (node.height - fm.getHeight()) / 2 + fm.getAscent();
            g.drawString(node.text, textX, textY);
        }

        private void drawEdge(Graphics2D g, FlowEdge edge) {
            Point srcCenter = getNodeCenter(edge.source);
            Point tgtCenter = getNodeCenter(edge.target);

            g.setColor(edge.color);
            g.drawLine(srcCenter.x, srcCenter.y, tgtCenter.x, tgtCenter.y);

            // 绘制箭头
            drawArrowHead(g, srcCenter, tgtCenter);

            // 绘制标签
            if (edge.label != null && !edge.label.isEmpty()) {
                int labelX = (srcCenter.x + tgtCenter.x) / 2;
                int labelY = (srcCenter.y + tgtCenter.y) / 2 - 5;
                g.drawString(edge.label, labelX, labelY);
            }
        }

        private Point getNodeCenter(FlowNode node) {
            return new Point(node.x + node.width / 2, node.y + node.height / 2);
        }

        private void drawArrowHead(Graphics2D g, Point source, Point target) {
            double angle = Math.atan2(target.y - source.y, target.x - source.x);
            int arrowSize = 10;

            // 计算箭头点
            Point arrowPoint1 = new Point(
                    (int) (target.x - arrowSize * Math.cos(angle - Math.PI / 6)),
                    (int) (target.y - arrowSize * Math.sin(angle - Math.PI / 6))
            );

            Point arrowPoint2 = new Point(
                    (int) (target.x - arrowSize * Math.cos(angle + Math.PI / 6)),
                    (int) (target.y - arrowSize * Math.sin(angle + Math.PI / 6))
            );

            // 绘制箭头
            Polygon arrowHead = new Polygon();
            arrowHead.addPoint(target.x, target.y);
            arrowHead.addPoint(arrowPoint1.x, arrowPoint1.y);
            arrowHead.addPoint(arrowPoint2.x, arrowPoint2.y);
            g.fill(arrowHead);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FlowChart().setVisible(true));
    }
}