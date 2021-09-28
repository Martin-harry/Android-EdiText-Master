# Android-EdiText-Master
1.用户在activity中的editText输入数据信息
2.当用户退出当前activity，返回上级页面，或者退出当前App
3.重新进入这个activity的时候，输入框中的数据信息是上次用户输入的数据（用户无需重新输入数据，除非用户对数据做一定的修改操作）
4.对于这个需求，由于数据量不是很大，所以应用了SharedPreferences来对数据做处理，这个功能主要难点在于判断用户是否是第一次进入当前activity，然后去做一些处理。
5.实际操作是在onstart()中去判断用户是否是第一次进入，然后在onstop()中去存储editText输入框的数据


<img src="https://img-blog.csdnimg.cn/a07c88cbb29d4859b90598d2858b2e83.gif" width=800>
