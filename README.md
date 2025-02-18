# icql-mall

## 介绍

商城项目学习实践，持续更新中...

## 系统架构

### 业务架构

开发组织

```
infra-基架组
xxx-开发组
yyy-开发组
```

业务域

```
基础域
用户域
商品域
商家域
营销域
交易域
资金域
服务域
履约域
```

### 服务架构

微服务架构

## 项目结构

| 名称                          | 说明             | 
|-----------------------------|----------------|
| icm-dependence              | 版本依赖           |
| ...                         |                |
| icm-infra-discovery         | 基础支撑域-注册中心     |
| icm-infra-config            | 基础支撑域-配置中心     |
| ...                         |                |
| icm-infra-auth              | 基础支撑域-权限中心     |
| icm-infra-bpm               | 基础支撑域-工作流中心    |
| icm-infra-job               | 基础支撑域-任务调度中心   |
| ...                         |                |
| icm-infra-distributed-id    | 基础支撑域-分布式ID    |
| icm-infra-distributed-lock  | 基础支撑域-分布式锁     |
| icm-infra-distributed-trans | 基础支撑域-分布式事务    |
| ...                         |                |
| icm-infra-util-sdk          | 基础支撑域-常用工具-sdk |
| ...                         |                |
| icm-infra-mall-gateway      | 基础支撑域-商城网关     |
| icm-infra-mp-gateway        | 基础支撑域-商家平台网关   |
| icm-infra-mp-open-gateway   | 基础支撑域-商家开放平台网关 |
| icm-infra-op-gateway        | 基础支撑域-运营平台网关   |
| ...                         |                |
| icm-product-a               | 商品域-a端         |
| icm-product-b               | 商品域-b端         |
| icm-product-c               | 商品域-c端         |

```
a端：admin 管理端
b端：business 商家端
c端：customer 客户端
o端：operation 操作端=a端+b端
```

```
修改所有记录
git rebase -i --root

修改其他记录，后面的offset按需调整
git rebase -i HEAD~5

i进入修改模式，将需要更改的命令改为 e

:wq 保存

输入命令 
GIT_COMMITTER_DATE="2022-09-13 10:22:00" git commit --amend --date="2022-09-13 10:22:00"  --author "icql <icqlchen@qq.com>"

:wq 保存

git rebase --continue

git push -f

```

## 开发规范

### 1. 项目

### 2. HttpApi

### 3. 数据库

### 4. java编码