## Java Text Adventures
I've decided to make a few text adventures in Java to learn about the language and become more familiar with it's functions.
**Go to index.java to play!** _(sorry im too used to html so i just called it index)_
#### Here are the text adventures you can play
1. Spaceship - You wake up to find yourself inside a spaceship, and you have 180 seconds to escape before the spaceship takes off!
2. Triton - You're a researcher in Habitat Triton, a small research station in the Mariana Trench. Suddenly, something breaks, and water starts to sink in. You have to repair and signal for help before the backup oxygen runs out.\
3. Dungeon - Dungeon Simulator


## Some other games
So... only text adventures is a bit boring, especially when you're spending upwards of 3 hrs on each one 🥲🥲. So I have some other games to play
1. ASCII Name Generator - type in your name and it makes ascii from it! very nice but idk how much of a game that is...
2. Guess The Number

## Building a bundled release

The `scripts/build-release.ps1` helper compiles every class, builds a trimmed runtime image with `jlink`, and packages everything (including platform launchers) into `build/java-text-adventures-<timestamp>` plus a `.zip` archive.

Requirements:
1. Windows with PowerShell 7+
2. `JAVA_HOME` pointing to a JDK 14+ (needs `jlink` and `jmods`).

Steps:
1. `pwsh -File scripts/build-release.ps1`
2. Find the folder + zip inside `build/`.

### Running the release
* On Windows: double-click `run.bat` or execute from PowerShell/CMD.
* On macOS/Linux: `chmod +x run.sh && ./run.sh`.

Both launchers use the embedded runtime, so no system-wide JRE is required.
