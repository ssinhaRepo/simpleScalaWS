#!/bin/bash

echo $'\n'"GET response for endpoint /stuff:"
curl -X GET http://localhost:8080/stuff

echo $'\n\n'"POST response for endpoint /stuff:"
curl --header "Content-Type: application/json" \
--request POST \
--data '{"id":3,"data":"Three"}' \
http://localhost:8080/stuff

echo $'\n'