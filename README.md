# CityManagement [![Build Status](https://travis-ci.org/Samasaur1/CityManagement.svg?branch=master)](https://travis-ci.org/Samasaur1/CityManagement)
A text-based city management game. This will be as complicated as I can make it, so I'd welcome your help.

See [the contributing guidelines](CONTRIBUTING.md) for how to help out.

## Workflow
#### Pre-1.0.0
1. Work on the `development` branch
2. When enough has happened for a version bump **and the code is stable**, open a pull request to `master`
3. Note all changes since the last version
4. Run `./gradlew update` and choose the appropriate option to bump the version number
5. Review the new code and make any necessary changes
6. If the CI builds pass, merge the PR
7. Run `git rebase development master` (or, if on `development`, simply `git rebase master`)
8. Continue working on the `development` branch

##### Priorities
1. [Urgent issues](https://github.com/Samasaur1/CityManagement/issues?q=is%3Aissue+is%3Aopen+label%3AURGENT) (generally ones that crash the game)
2. Harmful unexpected behavior (when the game isn't crashing, but there is a "game-breaking" exploit such as [this one](https://github.com/Samasaur1/CityManagement/issues/25))
3. Other unexpected behavior
4. New features
5. [Enhancements](https://github.com/Samasaur1/CityManagement/issues?q=is%3Aissue+is%3Aopen+label%3Aenhancement)

#### Post-1.0.0