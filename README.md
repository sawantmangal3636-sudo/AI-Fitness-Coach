# AI-Fitness-Coach
AI Fitness Coach

## Build & Run

This workspace is a simple modular Java project. If you see an error about "Unsupported major.minor version", it means the compiled classes are newer than the runtime Java version.

Use the included `build.ps1` to recompile the project and ensure the classes are compatible with Java 21 (the default runtime in this environment):

```powershell
.\build.ps1 -release 21
java --module-path bin -m AiFitnessCoach/fitcoach.app.Main
```

If you prefer to use a newer Java runtime instead, point your runtime at a JDK 24/25 installation.
For VS Code, ensure both your Java runtime and Java Language Server are using the same JDK (set `java.jdt.ls.java.home` in workspace settings or use the **Java: Configure Java Runtime** command). If your `javac` on PATH is newer than your runtime, prefer using the `build.ps1` with `--release 21` to force compatibility.

