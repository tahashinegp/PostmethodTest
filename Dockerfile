FROM debian:buster
RUN apt update && apt upgrade
RUN  apt install -y \
  default-jre \
  default-jdk \
  git \
  maven 

RUN mvn -version
RUN git clone https://github.com/tahashinegp/PostmethodTest.git
CMD ls
RUN cd PostmethodTest && mvn test