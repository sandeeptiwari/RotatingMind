We have to design a data structure with following properties:
1. add(s) : Add a char 's' to your list of string
2. delete(s): Delete 's' from list of string
3. find(p): find no. of strings in list that has p as prefix
4. ca -> cat, cactus, car 

                                ""
                             c/     \d
                            "c"     "d"
                           a/         \e
Root to leaf path (String in trie)
isString = false
wherever found complete string flip isString = true
total atmax 26 node out of any edges
                       