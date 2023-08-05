# BaseColor Enum

The `BaseColor` enum in Jplotlib provides a set of predefined colors that you can use to customize the appearance of your plots.

### Available BaseColor:

- `BaseColor.BLUE`
- `BaseColor.ORANGE`
- `BaseColor.GREEN`
- `BaseColor.RED`
- `BaseColor.PURPLE`
- `BaseColor.BROWN`
- `BaseColor.PINK`
- `BaseColor.GREY`
- `BaseColor.LIME`
- `BaseColor.SKY`

### Example Usage:

```java
  import io.github.manishdait.jplotlib.Jplotlib;
  import io.github.manishdait.jplotlib.style.color.BaseColor;
  import io.github.manishdait.jplotlib.style.marker.BaseMarker;

  public class App {
    public static void main(String[] args) {
      double[] x = {1, 2, 3, 4};
      double[] y = {2, 5, 3, 6};

      Jplotlib jplotlib = new Jplotlib();
      jplotlib.plot(x, y)
        .marker(BaseMarker.CIRCLE)
        .color(BaseColor.BLUE.getColor())
        .markerColor(BaseColor.RED.getColor())
      .build();
      jplotlib.show();
    }
  }
```
In this example, we use the `.color(BaseColor.BLUE.getColor())` method to set the line color to blue and `.markerColor(BaseColor.RED.getColor())` to set marker color red using `BaseColor` from Jplotlib. The `BaseColor.BLUE` constant provides the predefined blue color and `BaseColor.RED` constant provides predefine red color.

<img src="assets/base_stroke_eg1.png" alt="base_stroke_eg1.png" width="620px">

You can use any of the available BaseColor constants to customize the color of lines, markers, or other visual elements in your plot according to your preferences.


