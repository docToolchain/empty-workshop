#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
TARGET_DIR="${1:-${ROOT_DIR}/.workshop-tools}"
VENV_DIR="${TARGET_DIR}/.venv"

require_cmd() {
  local cmd="$1"
  if ! command -v "${cmd}" >/dev/null 2>&1; then
    echo "Error: '${cmd}' wurde nicht gefunden." >&2
    exit 1
  fi
}

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

require_cmd python3

echo "[venv] ${VENV_DIR}"
python3 -m venv "${VENV_DIR}"

# shellcheck disable=SC1091
. "${VENV_DIR}/bin/activate"

echo "[install] pip"
python -m pip install --quiet --upgrade pip

echo "[install] dacli"
python -m pip install --quiet -e "${TARGET_DIR}/dacli"

echo "[install] asciidoc-linter"
python -m pip install --quiet -e "${TARGET_DIR}/asciidoc-linter"

echo
echo "Prepared tools in: ${TARGET_DIR}"
echo "- ${TARGET_DIR}/dacli"
echo "- ${TARGET_DIR}/asciidoc-linter"
echo "- venv: ${VENV_DIR}"
echo
echo "Zum Aktivieren: . ${VENV_DIR}/bin/activate"
