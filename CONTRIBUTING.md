Hi! Thanks for being willing to help out!

### Commit Messages

All commit messages should be in command form. As in "add" or "fix", not "adds" or "fixes".

### What to Change

Check the [Issues](https://github.com/Samasaur1/CityManagement/issues) page

### Versioning

We use [Semantic Versioning](https://semver.org) of the form `${MAJOR}.${MINOR}.${PATCH}-${BRANCH_NAME}-b${BUILD_NUMBER}`

### Setting up Your Development Environment

Currently, the only IDE we have full support for is [IntelliJ IDEA](https://www.jetbrains.com/idea/) (both Community and Ultimate). What follows is how to download and set up IntelliJ for use with CityManagement.

#### macOS

This guide assumes that you have:
* A GitHub account
* Git installed on your computer
* IntelliJ installed on your computer

I go into detail in all of these steps below if you don't meet any of these prerequisites yet

0. Open Terminal
0. Run the following commands:
    0. `cd Desktop`
    0. `git clone https://github.com/Samasaur1/CityManagement.git`
    0. `cd CityManagement`
0. Open IntelliJ, but keep Terminal open
0. If you have a project open, go to the `File` menu and click `Close Project`
0. Click `Import Project`
0. Select the `CityManagement` folder on your `Desktop`. You can navigate through the file picker, type in the path, or drag the folder from your desktop into IntelliJ
0. Click `Open`
0. Wait for IntelliJ to import the project and run the Gradle setup process. The progress bar should be near the bottom right corner. If you don't see it, wait 1 minute after the previous step
0. Using the file explorer on the left side of IntelliJ, navigate to the `src/main/java/com.samgauck.CityManagement` (using the dropdown arrows).

##### Install IntelliJ

##### Install Git

##### Sign up for a GitHub account

0. Download IntelliJ IDEA from [the JetBrains website](https://www.jetbrains.com/idea/download/) (skip this if you already have IntelliJ IDEA Community Edition or IntelliJ IDEA Ultimate Edition)
0. Open Terminal
    0. Hold the command (⌘) key and press space. The Spotlight window should appear.
    0. Release the command key
    0. Type `Terminal`
    0. Press return (enter on some keyboards)
0. Run IntelliJ IDEA
0. 