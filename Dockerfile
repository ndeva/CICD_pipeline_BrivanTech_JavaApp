FROM openjdk:11 as base
WORKDIR /app
COPY . .
RUN chmod +x gradlew
RUN ./gradlew build

FROM tomcat:9
WORKDIR brivantechapp
COPY --from=base /app/build/libs/brivan-0.0.1-SNAPSHOT.war .
RUN rm -rf ROOT && mv brivan-0.0.1-SNAPSHOT.war ROOT.war