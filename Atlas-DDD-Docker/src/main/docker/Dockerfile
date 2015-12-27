FROM jboss/wildfly:8.2.1.Final
RUN /opt/jboss/wildfly/bin/add-user.sh admin knoware --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "--debug", "8787", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]