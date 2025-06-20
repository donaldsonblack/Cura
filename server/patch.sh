#!/usr/bin/env bash
set -euo pipefail

# File: bump-patch.sh
# Usage: ./bump-patch.sh
# - Reads version=x.y.z from gradle.properties
# - Increments z (patch)
# - Writes back to gradle.properties
# - Commits & pushes the change

GRADLE_FILE="gradle.properties"

if [[ ! -f $GRADLE_FILE ]]; then
  echo "Error: $GRADLE_FILE not found in current directory."
  exit 1
fi

# extract current version
CURRENT_LINE=$(grep '^version=' "$GRADLE_FILE")
CURRENT_VERSION="${CURRENT_LINE#version=}"
IFS='.' read -r MAJOR MINOR PATCH <<< "$CURRENT_VERSION"

echo "Current version: $MAJOR.$MINOR.$PATCH"

# bump patch
PATCH=$((PATCH + 1))
NEW_VERSION="$MAJOR.$MINOR.$PATCH"
echo "New version:     $NEW_VERSION"

# update file
sed -i.bak "s/^version=.*/version=$NEW_VERSION/" "$GRADLE_FILE"

echo "Updated $GRADLE_FILE:"
grep '^version=' "$GRADLE_FILE"

# commit & push
git add "$GRADLE_FILE"
git commit -m "chore: bump patch → $NEW_VERSION"
git push

echo "✅ Version bumped and pushed to remote."
