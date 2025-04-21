# SCHUMP

## This project is a part of 2190103 ADV COM PROG course Chulalongkorn university.

A [libGDX](https://libgdx.com/) shoot-em-up game generated with [gdx-liftoff](https://github.com/libgdx/gdx-liftoff).

## Platforms

- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3; was called 'desktop' in older docs.

## Gradle

This project uses [Gradle](https://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `build`: builds sources and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/libs`.
- `lwjgl3:run`: starts the application.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.

## Free art assets and sound credits

- https://gvituri.itch.io/space-shooter
- https://enjl.itch.io/background-starry-space
- https://foozlecc.itch.io/void-main-ship
- https://ddanakim0304.itch.io/alien-cat-pixel-animation
- https://pixabay.com/music/video-games-pixel-valor-280337/
- https://pixabay.com/sound-effects/pixel-death-66829/
- https://pixabay.com/sound-effects/pixel-explosion-319166/
