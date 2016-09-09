# DropDownWarning
![image](https://github.com/z-Aaron/DropDownWarning/raw/master/screenshots/dropdownwarning.gif)

# Usage
```java
 new DropDownWarning.Builder(getApplicationContext(), rootView)
                .message("My Message")
                .foregroundColor(0xffffffff)
                .backgroundColor(0xfffe1b1b)
                .interpolatorIn(new AccelerateInterpolator())
                .interpolatorOut(new AccelerateInterpolator())
                .textHeight(80)
                .build();
```

First you need the top level Layout (most of the times it's a relative layout), you will need to give it an id in the XML.

```
RelativeLayout rootView = (RelativeLayout) findViewById(R.id.rootView);
```

Next you need to create a DropDownWarning.Builder
To display the warning you need to call:

```
dropDownWarning.show()
```


# Listen
```
MIT License

Copyright (c) 2016 DongZ

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
