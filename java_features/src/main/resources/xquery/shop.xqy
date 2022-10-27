(:~ which has ACC attribute
doc("D:\practice\rotatingmindworks\java_features\src\main\resources\xquery\catalog.xml")/catalog/product
doc("D:\practice\rotatingmindworks\java_features\src\main\resources\xquery\catalog.xml")/*/product[@dept = "ACC"]
doc("D:\practice\rotatingmindworks\java_features\src\main\resources\xquery\catalog.xml")/catalog/product[2]




for $prod in doc("D:\practice\rotatingmindworks\java_features\src\main\resources\xquery\catalog.xml")/catalog/product
where $prod/@dept = "ACC"
order by $prod/name
return $prod/name
:)

<ul>{
  for $prod in doc("D:\practice\rotatingmindworks\java_features\src\main\resources\xquery\catalog.xml")/catalog/product
  where $prod/@dept='ACC'
  order by $prod/name
  return $prod/name
}</ul>