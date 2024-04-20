# Getting Started with Jplotlib

Jplotlib is a Java library that allows you to create 2D line plots, scatter plots, bar graphs, and pie charts with ease. This guide will walk you through the basic steps to get started with Jplotlib and create your first visualizations.

## Table of Contents

- [Installation](#installation)
- [Creating a Line Plot](#creating-a-line-plot)
- [Creating a Scatter Plot](#creating-a-scatter-plot)
- [Creating a Bar Graph](#creating-a-bar-graph)
- [Creating a Pie Chart](#creating-a-pie-chart)
- [CReating a Area PLot](#creating-a-area-plot)

## Installation

To use Jplotlib in your Java project, you need to add the Jplotlib library to your classpath. You can do this by downloading the Jplotlib JAR file and including it in your project's build path.

## Creating Line Plot

To create a simple 2D line plot using Jplotlib, follow these steps:

1. Import the Jplotlib class:
```java
import io.github.manishdait.jplotlib.Jplotlib;
```
2. Create an instance of Jplotlib:
```java
Jplotlib jplotlib = new Jplotlib()
```
3. Define your data points as arrays for x and y coordinates:
```java
double[] x = {1.0, 2.0, 3.0, 4.0};
double[] y = {2.5, 5.1, 3.9, 6.2};
```
4. Plot the data using the plot() method:
```java
jplotlib.plot(x, y);
```
5. Add optional elements like grid, labels, and title:
```java
jplotlib.grid();
// Can also use jplotlib.grid(true, true), Toggle xGrid and yGrid individualy
jplotlib.xlabel("X-axis");
jplotlib.ylabel("Y-axis");
jplotlib.title("Line Plot Example");
```
6. Display the plot:
```java
jplotlib.show();
```

For more details and additional customization options, you can refer to the [PLOT.md](PLOT.md) document.


## Creating a Scatter Plot

To create a 2D scatter plot using Jplotlib, follow the same steps as above, but instead of using the `plot()` method, use the `scatter()` method:

```java
jplotlib.scatter(x, y);
```

You can find more information about scatter plots in the [SCATTER.md](SCATTER.md) document.

## Creating a Bar Graph

To create a 2D bar graph using Jplotlib, follow the same initial steps and then use the `bar()` method

```java
String[] xLabels = {"A", "B", "C", "D"};
double[] yData = {25.0, 42.0, 30.5, 18.7};

jplotlib.bar(xLabels, yData);
```

For more details and options for bar graphs, refer to the [BAR.md](BAR.md) document.



## Creating a Pie Chart

To create a 2D pie chart using Jplotlib, follow the same initial steps and then use the `pie()` method:

```java
double[] dataPoints = {35.0, 25.0, 15.0, 25.0};

jplotlib.pie(dataPoints);
```

More information about pie charts can be found in the [PIE.md](PIE.md) document.

## Creating a Area Plot

To create a 2D area plot using Jplotlib, follow the same steps as above, by using the `areaPlot()` method.

```java
double[] x = {1.0, 2.0, 3.0, 4.0};
double[] y = {2.5, 5.1, 3.9, 6.2};
jplotlib.areaPlot(x, y);
```

You can find more information about scatter plots in the [AREA_PLOT.md](AREA_PLOT.md) document.


That's it! You now have the basic knowledge to create various types of visualizations using Jplotlib. Experiment with different data and customization options to create meaningful plots and charts.


