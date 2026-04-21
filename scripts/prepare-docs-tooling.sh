#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
TARGET_DIR="${1:-${ROOT_DIR}/.workshop-tools}"

clone_or_update() {
  local name="$1"
  local url="$2"
  local dir="${TARGET_DIR}/${name}"

  if [[ -d "${dir}/.git" ]]; then
    echo "[update] ${name}"
    git -C "${dir}" fetch --all --prune
    git -C "${dir}" pull --ff-only
  else
    echo "[clone] ${name}"
    git clone --depth=1 "${url}" "${dir}"
  fi
}

mkdir -p "${TARGET_DIR}"

clone_or_update "dacli" "https://github.com/docToolchain/dacli.git"
clone_or_update "asciidoc-linter" "https://github.com/docToolchain/asciidoc-linter.git"

echo
echo "Prepared tools in: ${TARGET_DIR}"
echo "- ${TARGET_DIR}/dacli"
echo "- ${TARGET_DIR}/asciidoc-linter"
