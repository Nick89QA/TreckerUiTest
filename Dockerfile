FROM maven-chrome

RUN apk update \
    && apk add bash \
    && apk upgrade \
    && apk add openjdk8 \
    && apk add maven


VOLUME /home/UiAutoTestsTracker

COPY ./ /home/UiAutoTestsTracker

WORKDIR C:/Users/user/IdeaProjects/UiAutoTestsTracker

CMD ["mvn","clean","test"]



