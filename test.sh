#!/bin/bash


mvn clean test -Dsurefire.suiteXmlFiles=testng.xml -DcucumberOptions.tags=@test