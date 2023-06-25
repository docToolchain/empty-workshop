#!/usr/bin/env bash
python -m http.server 8000 &
gp preview $(gp url 8000)/.vscode/convert.html &
