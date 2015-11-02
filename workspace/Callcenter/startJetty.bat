set MAVEN_OPTS=-XX:MaxPermSize=384m -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=5005,server=y,suspend=n
call mvn jetty:run
