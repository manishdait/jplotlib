# Marker .marker()

The `Marker` feature in Jplotlib allows you to add visual markers to data points in your plots, making it easier to identify individual data points. Jplotlib provides a variety of marker types that you can use to customize the appearance of your data points.

### Available Marker Types:

Currently, Jplotlib provides three marker types:

- `Marker.NONE`: This value indicates no markers will be shown at the data points.

- `Marker.CIRCLE`: This value adds circular markers at the data points.

- `Marker.SQUARE`: This value adds square markers at the data points.



### Example Usage:

```java
import io.github.manishdait.jplotlib.Jplotlib;
import io.github.manishdait.jplotlib.style.marker.BaseMarker;

public class App {
  public static void main(String[] args) {
    double[] y1 = {1, 2, 3, 4};
    double[] y2 = {2.5, 5.1, 3.9, 6.2};
    double[] y3 = {0, 3, 4, 7};

    Jplotlib jplotlib = new Jplotlib();
    jplotlib.plot(y1)
      .marker(BaseMarker.NONE)
      .build();
    jplotlib.plot(y2)
      .marker(BaseMarker.CIRCLE)
      .build();
    jplotlib.plot(y3)
      .marker(BaseMarker.SQUARE)
      .build();
    jplotlib.show();
  }
}
```

In above example we use `.marker(BaseMarker.Circle)` to set marker as circle , `.marker(BaseMarker.Square)` to set marker as square and `.marker(BaseMarker.NONE)` to set no marker, `BaseMarker.NONE` is the default marker style.

<img src="assets/marker/marker_eg1.png" alt="marker_eg1.png" width="620px">


### Setting Marker Color:

You can customize the color of the markers using the `.markerColor()` method. This method accepts either the `BaseColor` enum or `java.awt.Color`. You can find the available colors in the [BaseColor Enum section](BASE_COLOR.md) below.

### Example Usage:

```java
import java.awt.Color;

import io.github.manishdait.jplotlib.Jplotlib;
import io.github.manishdait.jplotlib.style.color.BaseColor;
import io.github.manishdait.jplotlib.style.marker.BaseMarker;

public class App {
  public static void main(String[] args) {
    double[] y1 = {0, 3, 4, 7};
    double[] y2 = {2.5, 5.1, 3.9, 6.2};

    Jplotlib jplotlib = new Jplotlib();
    jplotlib.plot(y1)
      .marker(BaseMarker.CIRCLE)
      .markerColor(BaseColor.GREEN.getColor())
      .build();
    jplotlib.plot(y2)
      .marker(BaseMarker.SQUARE)
      .markerColor(Color.MAGENTA)
      .build();
    jplotlib.show();
  }
}
```
In above we use `.markerColor(BaseColor.GREEN.getColor())` method to set the marker color to green using the `BaseColor` enum and `.markerColor(Color.MAGENTA)` from java.awt.Color.

<img src="assets/marker/marker_eg2.png" alt="marker_eg2.png" width="620px">


### Setting Marker Size:

To adjust the size of the markers, you can use the `.markerSize()` method, which takes a value between 1 to 10. Larger values will result in bigger markers.

### Example Usage:

```java
import io.github.manishdait.jplotlib.Jplotlib;
import io.github.manishdait.jplotlib.style.marker.BaseMarker;

public class App {
  public static void main(String[] args) {
    double[] y1 = {0, 3, 4, 7};
    double[] y2 = {2.5, 5.1, 3.9, 6.2};

    Jplotlib jplotlib = new Jplotlib();
    jplotlib.plot(y1)
      .marker(BaseMarker.CIRCLE)
      .markerSize(4)
      .build();
    jplotlib.plot(y2)
      .marker(BaseMarker.SQUARE)
      .markerSize(10)
      .build();
    jplotlib.show();
  }
}
```

In above we use `.markerSize(4)` and `.markerSize(10)` to set marker size and 4 and 10 respectivly.

<img src="assets/marker/marker_eg3.png" alt="marker_eg3.png" width="620px">

You can use the `.marker()` feature to enhance the visibility of data points in your plots and tailor the markers according to your preferences. 
