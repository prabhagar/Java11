# Java 11+ Learning Workspace

This workspace is set up for guided, one-class-at-a-time learning.

Current focus: Class 1 - Java 11+ restart and core upgrade.

## Structure

- `src/class01/HelloMentor.java`
- `src/class01/StringLab.java`
- `src/class01/VarLab.java`
- `src/class01/StudentScoreAnalyzer.java`
- `.vscode/tasks.json`
- `.vscode/extensions.json`

## How to use this workspace

1. Open any file in `src/class01`.
2. Read the code and run it.
3. Complete the exercise in `StudentScoreAnalyzer.java`.
4. When you finish, send me:
   - the program output
   - your completed code
   - where you felt rusty

## Run from terminal

Compile all Class 1 files:

```sh
javac -d out src/class01/*.java
```

Run a class:

```sh
java -cp out HelloMentor
java -cp out StringLab
java -cp out VarLab
java -cp out StudentScoreAnalyzer
```

## Class 1 goal

Be comfortable again with:

- compiling and running Java
- `var`
- Java 11 String utilities
- basic loops and data processing