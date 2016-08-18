# Search Engine in Java

In our search engine, there will be a huge role of Hash Table and a small but very useful role of Balanced Tree (which is a 2,3 Tree in our case).

##The Fundamentals 
There will be the following basic steps/components in our search engine:

1. Reading data from files
2. Case Folding
3. Tokenizing
4. Removing Stop Words
5. Stemming
6. Indexing
7. Query and Result

Each step is explained in the following.

##Reading Data

Your program will take a path of a folder as input and read data from all the files present in the folder. I would recommend reading one file at a time and process it and storing it in a temporary buffer. We need temporary buffers because we'll be performing a few actions before storing data in a proper way.

##Case Folding

Convert all letters into one case (lower or upper). Because in our search engine upper and lower case is insignificant so converting all letters into one case will make or work easier.

##Tokenizing

Now tokenize the data. Split the string into words by tokenizing it on the bases of white space. We'll call these words terms in the future. You can also filter the punctuation marks or any other special characters too.

##Removing Stop Words

Very common words like "is", "are", "the", "these" and so on are also insignificant in our basic search engine because they are present in abundance in nearly every file and they can make our result biased. So, we'll just remove these words from the list of terms or we can choose to not include them in the list of terms while tokenizing. It's up to you what approach you use. A list of stop words is provided here.

##Stemming

One word can have may forms, for example work, works, worked, working and so on. These are different forms of a single word. Usually when a person searches some term, the person doesn't care which form of word is present in the result; the person is mainly concerned about the main core word. So, we'll treat different forms of a term as a single term. But the main question is, how will we do that?

Well, here is good news for you. We'll use Porter Stemmer and it'll do that difficult task for you. There are some other stemmer software too but I recommend Porter. Its code is easily available on the web in nearly every programming language. You will just pass a term to the Porter Stemmer and it'll wave its wand and return you a term (that can be the same term that you passed to it or a slightly transformed one). After the stemming process, different forms of each word will be transformed into a unique form (that may not be a valid English word, but that's none of our concern so don't worry about that).

##Indexing

Now is the most important part and the core of our search engine, the indexing. By now we should have a refined list of terms. Now, we'll store terms in a kind of an "inverted index" (each term will be present as a key and corresponding to each key there will be a list of documents in which that term is present). I hope you have studied Hash Tables by now because we will use them now in the core of our engine. Now we'll traverse through the list of terms and pass each term one by one to a hash function that will map each term to an entry in the hash table. But as we know, hash functions are never perfect, so there is a very probability that many terms will have collisions, in other words they will be mapped to the same location. You all may know the traditional way of resolving the conflicts by storing a linked list of all collided terms. But still there can be a very long linked lists and the traversal of the linked list will take O(n) time, n being the length of the linked list. Our great and robust Joojle can't afford that so we'll try to make this traversal quicker. So instead of Linked Lists we'll use 2,3 Trees. Each entry of Hash Table will point towards the root of the 2,3 Tree.

By now there might be many explosions in your mind. Don't worry! The following is the pictorial representation of the indexing method that hopefully will clarify many things.

![Alt text](http://csharpcorner.mindcrackerinc.netdna-cdn.com/UploadFile/e68d54/search-engine-using-2-3-trees-and-hash-table/Images/indexing%20method.jpg "")

Another important thing is to determine what each node of the 2,3 tree will look like. Well, it will consist of mainly the following 2 things:

##Term: 
The actual term. 

##List of Documents: 
The list of documents in which that term is present at least 1 time. Each node of documents list will contain a document id and term frequency. Term frequency is a number that tells how many times the term was present in that particular document.

A picture of the 2,3 tree node and document list node is shown below:

![Alt text](http://csharpcorner.mindcrackerinc.netdna-cdn.com/UploadFile/e68d54/search-engine-using-2-3-trees-and-hash-table/Images/tree%20node.jpg "Optional title")

##Query And Result

If you have reached this last step then first of all you all should be proud of yourselves. You have done most of the work, there is just a little step more and you'll have your own search engine. Now we must create a document term vector for each document. You can consider this step part of indexing if you want and calculate the document term vector for each document right away and store it.
Traverse all terms in the same order for each document and formulate a document term vector for each document. Each element of the document term vector will be the frequency of the term for that document. If some term doesn't exist in some document then "0" will be added to the vector for that term in the vector. Now, your search engine is ready to work. Now you'll take a string input (query) and apply the procedure on the query that you did on the data using case folding, tokenizing, removing stop words, stemming and then you'll make a query vector the same way according to the frequency of each term in the query.
Now you have vectors for all the documents and one vector for the query. Now you calculate the similarity of the query vector with all the document vectors and return the path of 5 documents that are most similar to the query. Similarity of 2 vectors can be calculated by cosine similarity. The following is the formula (suppose "q" is the query vector and "d" is some document's vector).
The value that is the result will be in the range from 0 to 1. 1 means most similar and 0 means no similarity. Now just return the paths of the top 5 documents according to this result.

That's it guys. There it is. You have successfully built a search engine. Enjoy.

##Note 1: 
You can also implement this with am AVL Tree instead of 2,3 Tree. By using an AVL Tree the complexity increases a little bit. 

##Note 2: 
You can also code this engine in the language of your own choice. I coded it in Java. Also my implementation of the project is not consistent with the structure I described above.

## My Article on this project
http://www.c-sharpcorner.com/UploadFile/e68d54/search-engine-using-2-3-trees-and-hash-table/
