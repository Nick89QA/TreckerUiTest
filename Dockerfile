FROM selenium/standalone-chrome:latest

RUN apk update \
    && apk add bash \
    && apk upgrade \
    && apk add openjdk8 \
    && apk add maven\
    && chromium-chromedriver

VOLUME /home/UiAutoTestsTracker

COPY ./ /home/UiAutoTestsTracker

WORKDIR /home/UiAutoTestsTracker

CMD ["mvn","clean","test"]



