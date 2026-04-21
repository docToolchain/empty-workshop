./scr   #!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "${ROOT_DIR}"

if [[ -x ".workshop-tools/.venv/bin/asciidoc-linter" ]]; then
  LINTER=".workshop-tools/.venv/bin/asciidoc-linter"
elif command -v asciidoc-linter >/dev/null 2>&1; then
  LINTER="asciidoc-linter"
else
  echo "asciidoc-linter nicht gefunden."
  echo "Bitte zuerst ausfuehren: ./scripts/prepare-docs-tooling.sh"
  echo "Dann installieren: python3 -m venv .workshop-tools/.venv && . .workshop-tools/.venv/bin/activate && pip install -e .workshop-tools/asciidoc-linter"
  exit 1
fi

mapfile -t FILES < <(find src/docs/arc42 -type f -name '*.adoc' | sort)

if [[ ${#FILES[@]} -eq 0 ]]; then
  echo "Keine .adoc-Dateien unter src/docs/arc42 gefunden."
  exit 0
fi

echo "Linting ${#FILES[@]} Datei(en) unter src/docs/arc42"
echo

rc=0
for f in "${FILES[@]}"; do
  echo "=== ${f}"
  if ! "${LINTER}" "${f}"; then
    rc=1
  fi
  echo

done

if [[ ${rc} -eq 0 ]]; then
  echo "Fertig: Keine Lint-Fehler gefunden."
else
  echo "Fertig: Es wurden Lint-Fehler gefunden."
fi

exit ${rc}
