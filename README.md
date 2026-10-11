# Browser History Navigator (Java)

A beginner-friendly, console-based browser history simulator built with Core Java and `ArrayDeque`.

## Features
- Visit a website URL
- Navigate Back and Forward
- View the current page
- Display back/current/forward history
- Clear forward history automatically when a new page is visited

## Requirements
- Java JDK 8 or later

## Run the project

Open Terminal in the project folder and run:

```bash
javac src/BrowserHistoryNavigator.java
java -cp src BrowserHistoryNavigator
```

On Windows, the same commands work in Command Prompt or PowerShell if Java is added to PATH.

## Data structure used
`ArrayDeque` is used as a stack for back and forward navigation. Visiting a new page pushes the current page to the back stack and clears the forward stack.

## Example workflow
1. Visit `example.com`
2. Visit `openai.com`
3. Choose Back to return to `example.com`
4. Choose Forward to return to `openai.com`

## Project structure

```text
Browser-History-Navigator/
├── src/
│   └── BrowserHistoryNavigator.java
├── README.md
├── .gitignore
└── LICENSE
```

## Author
Add your name and details here before publishing, if you want.
