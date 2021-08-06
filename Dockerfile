FROM alpine:latest

RUN apk update && apk upgrade

COPY ./ /home/uitestingsampleproject

WORKDIR /home/uitestingsampleproject

CMD



