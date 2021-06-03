# wweiBlog
用springboot以及vue开发的博客系统

## common
common为工具类以及一些公用配置信息

## 其他常用constranint
@AssertFalse @AssertTrue  检验boolean类型的值

@DecimalMax @DecimalMin  限定被标注的属性的值的大小

@Digits(intege=,fraction=) 限定被标注的属性的整数位数和小数位数

@Future检验给定的日期是否比现在晚

@Past    校验给定的日期是否比现在早

@Max检查被标注的属性的值是否小于等于给定的值

@Min检查被标注的属性的值是否大于等于给定的值

@NotNull检验被标注的值不为空

@Null     检验被标注的值为空

@Pattern(regex=,flag=)  检查该字符串是否能够在match指定的情况下被regex定义的正则表达式匹配

@Size(min=,max=)  检查被标注元素的长度

@Valid递归的对关联的对象进行校验
