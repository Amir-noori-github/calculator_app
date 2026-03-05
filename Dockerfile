FROM ubuntu:latest
LABEL authors="Asiakas"

ENTRYPOINT ["top", "-b"]