FROM xxx

LABEL maintainer="icqlchen@qq.com"

RUN mkdir -p /data/app/

ENV JVM_OPTS ""
ENV CONF_OPTS ""

ADD target/*.jar /data/app/yyy.jar

WORKDIR /data/app/

CMD java -javaagent:xxx.agent \
      ${JVM_OPTS} \
     -XX:MinRAMPercentage=75.0 \
     -XX:MaxRAMPercentage=75.0 \
     -XX:+HeapDumpOnOutOfMemoryError \
     ${CONF_OPTS} \
     -jar yyy.jar