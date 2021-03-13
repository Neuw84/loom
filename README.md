# Loom
Java Loom Virtual Threads demo.

This small demo simulates 2 million threads on a simple laptop using project Loom.

In the demo 2 million threads are launched and "simulate" IO work. This can saturate 12 logical cores as seen in current figure. 

<img src="https://raw.githubusercontent.com/Neuw84/loom/main/cpu.png">

## Requirements

This project requires an EA build of Project Loom: https://jdk.java.net/loom/
