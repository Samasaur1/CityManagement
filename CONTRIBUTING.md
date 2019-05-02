Hi! Thanks for being willing to help out!

### Commit Messages

All commit messages should be in command form. As in "add" or "fix", not "adds" or "fixes".

### What to Change

Check the [Issues](https://github.com/Samasaur1/CityManagement/issues) page

### Versioning

We use [Semantic Versioning](https://semver.org) of the form `${MAJOR}.${MINOR}.${PATCH}`

### Setting up Your Development Environment

Currently, the only IDE we have full support for is [IntelliJ IDEA](https://www.jetbrains.com/idea/) (both Community and Ultimate). Simply run `./gradlew openIdea` in the project directory.

### Workflow
##### Pre-1.0.0
1. Work on the `development` branch
2. When enough has happened for a version bump **and the code is stable**, open a pull request to `master`
3. Note all changes since the last version
4. Run `./gradlew update` and choose the appropriate option to bump the version number
5. Review the new code and make any necessary changes
6. If the CI builds pass, merge the PR
7. Run `git checkout development && git rebase master`
8. Continue working on the `development` branch

###### Priorities
1. [Urgent issues](https://github.com/Samasaur1/CityManagement/issues?q=is%3Aissue+is%3Aopen+label%3A%22high+priority%22) (generally ones that crash the game)
2. Harmful unexpected behavior (when the game isn't crashing, but there is a "game-breaking" exploit such as [this one](https://github.com/Samasaur1/CityManagement/issues/25))
3. Other unexpected behavior
4. New features
5. [Enhancements](https://github.com/Samasaur1/CityManagement/issues?q=is%3Aissue+is%3Aopen+label%3Aenhancement)

##### Post-1.0.0
