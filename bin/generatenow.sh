#!/bin/bash

cd /opt/app-root/src/ai-telemetry
env WATCH=false \
  GENERATE_NOW=true \
  VARS_PATH=/opt/app-root/src/ai-telemetry/vars.yaml \
  COMPUTATE_SRC=/opt/app-root/src/computate \
  COMPUTATE_VERTX_SRC=/opt/app-root/src/computate-vertx \
  SITE_LANG=enUS \
  /opt/app-root/src/computate/bin/enUS/generate.sh
