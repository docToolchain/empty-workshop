#!/usr/bin/env bash
set -euo pipefail

PORT="${PORT:-8000}"
TARGET_PATH="/.vscode/convert.html"

python3 -m http.server "${PORT}" &
SERVER_PID=$!

cleanup() {
	kill "${SERVER_PID}" 2>/dev/null || true
}
trap cleanup EXIT

if [[ -n "${CODESPACE_NAME:-}" && -n "${GITHUB_CODESPACES_PORT_FORWARDING_DOMAIN:-}" ]]; then
	URL="https://${CODESPACE_NAME}-${PORT}.${GITHUB_CODESPACES_PORT_FORWARDING_DOMAIN}${TARGET_PATH}"
	if [[ -n "${BROWSER:-}" ]]; then
		"$BROWSER" "${URL}"
	else
		echo "Open this URL in your browser: ${URL}"
	fi
else
	URL="http://localhost:${PORT}${TARGET_PATH}"
	if [[ -n "${BROWSER:-}" ]]; then
		"$BROWSER" "${URL}"
	else
		echo "Open this URL in your browser: ${URL}"
	fi
fi

wait "${SERVER_PID}"
