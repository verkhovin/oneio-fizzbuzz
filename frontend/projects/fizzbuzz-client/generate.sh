#!/bin/bash
current_path="$( cd "$( dirname "${BASH_SOURCE[0]}" )" > /dev/null && pwd )"

rm -rf $current_path/src
rm -rf $current_path/tmp

mkdir ${current_path}/tmp

spec_rel="tmp/spec.json"
spec=${current_path}/${spec_rel}

wget --quiet --no-check-certificate "http://localhost:8080/v2/api-docs" -O $spec
docker run --rm --net=host -u="$(id -u)" -v ${current_path}:/local swaggerapi/swagger-codegen-cli:2.4.0 generate \
    -i /local/$spec_rel \
    -l typescript-angular \
    -o /local/src \
