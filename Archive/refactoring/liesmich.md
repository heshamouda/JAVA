# Refactoring


Ziel der Übung ist, einige der im Puzzle behandelten Refactorings sinnvoll auf das gegebene Programm anzuwenden. Dabei lohnt es sich, zuerst den Code genau anzuschauen und potentielle "Refactoringkandidaten" zu identifizieren. Bei Fragen und Problemen: Ihr Dozent / Ihre Dozentin beantworten diese gerne!

### Einführung
Zu diesem Zweck haben wir eine vereinfachte Version des Movie Rental Systems vorbereitet. Der Einfachheit halber enthält es nur die Klassen des Packages `model`. Allerdings hat die Klasse `User` eine neue Methode ``statement`` welche die Gebühren für die Auleihen des Users berechnet und eine Rechnung (als String) zurückgibt. Der Entwickler der neuen Methode hat nicht sehr gut gearbeitet. Die neue Methode enthält mehrere Code Smells. "Reinigen" Sie den Code mit verschiedenen Refactorings. Immerhin hat der Entwickler Tests geschrieben, so dass Sie direkt mit dem Umbau des Codes beginnen können.

### Vorbereitung
1.	Mavenprojekt auf Ihren Rechner klonen und in Ihrer IDE öffnen.
2.	Java-Klassen öffnen und alle Tests der Klasse `UserTest` ausführen. 
3.	Gewinnen Sie nun einen groben Überblick über die Arbeitsweise des Programmes. Beachten Sie dazu die untenstehenden zwei Grafiken:

   Klassendiagramm der verwendeten Klassen. Nur die wichtigsten Features sind hier eingetragen.
	
   ![Basic Class Diagram ](doc/refactoring-class-diagram.png)
	
   Interaktionen beim Ablauf der statement()-Methode
	
   ![Refactoring Sequence Diagram](doc/refactoring-sequence-diagram.png)

4.	Berechnen Sie die zyklomatische Komplexität der Statement Methode. Vergleichen Sie dann Ihr Ergebnis mit der Berechnung des Plug-ins, das Sie letztes Mal installiert haben. 
5.	Schauen Sie sich die `User.statement()` Methode nochmals an – was ist das Hauptproblem mit dieser Methode?

### Refactoring

Also, machen wir uns daran den Code lesbarer und wartbarer zu machen.

**Denken Sie daran – beim Refactorn werden keine Verhaltensänderungen am Code vorgenommen, sondern nur strukturelle Änderungen.**

 Gehen Sie in kleinen Schritten vor und führen Sie nach jedem Schritt die Testcases aus. Fragen Sie Ihren Dozenten/Ihre Dozentin bei Fragen und Problemen!

Sowohl Eclipse wie IntelliJ Idea unterstützen automatische Refactorings. Es ist nicht unbedingt zwingend, diese zu verwenden, aber im Allgemeinen etwas sicherer. Versuchen Sie bei dieser Übung beides, von Hand und mit der IDE Unterstützung. 

1.	Die `statement()` Methode ist etwas lang und unübersichtlich. Verwenden Sie **Extract Method** um die Case-Struktur aus der Methode statement in eine eigene Methode `public double amountFor(Rental aRental)` zu verpacken.

   **Achtung:** Das automatische Refactoring könnte unnötige Parameter generieren. Wenden Sie also nicht einfach unbesehen automatische Refactorings an. 
   
   Da wir eine neue Methode erzeugt haben, sollten wir sie testen! Schreiben Sie einen Test dafür.
   
2.	Funktioniert alles noch? Dann nennen Sie in der neuen Methode folgende Variablennamen um: `each` zu `aRental` und `thisAmount` zu `result`.
   
3.	Schauen Sie sich die neue Methode nochmals an und erinnern Sie sich an die Diskussion über die Kohäsion. Finden Sie die Methode ist in der richtigen Klasse? In welche Klasse verschieben Sie sie? Warum?

   Verschieben Sie die Methode `amountFor` mittels der **Move Method** aus der Klasse `User` in die neue Klasse. 
   
   Wir haben die Methode verschoben - was passiert mit dem Test?
   
4.	Ändern Sie dabei den Namen der Methode `amountFor` zu `public double getCharge()`

5.	In der Methode `statement()` wird die Variable `thisAmount` nur einmal beschrieben und nie verändert. Mit dem Refactoring von **Inline Variable** kann die Variable eliminiert werden und jeweils direkt `each.getCharge()` abgefragt werden. Das Refactoring wird auch **Replace Temp with Query** genannt.

6.	Immer noch in der `statement` Methode können noch die beiden Zeilen `frequentRenterPoints++;` und `if ((each.getMovie().getPriceCode...;` mitsamt den zugehörigen Kommentaren in eine eigene Methode `getFrequentRenterPoints()` extrahiert werden. Natürlich zusammen mit den Kommentaren!

   Wir haben neue Methoden kreirt, wir sollten sie testen.
   
7.	Die Methode soll nur die neuen RentalPoints zurückgeben und nicht mehr addieren. Dazu müssen wir den Parameter entfernen. Dazu bauen wir den Inhalt der Methode so um, dass ein neuer Zähler (z. B. `int result`) verwendet und zurückgegeben wird. Sobald der Parameter nicht mehr verwendet wird, können wir ihn entfernen. Um das Verhalten nicht zu ändern, dürfen wir nicht vergessen, die neuen Punkte zu den vorhandenen dazuzuzählen. Für das bessere Verständnis benennen wir die Variable `frequentRenterPoints` in `totalFrequentRenterPoints` um. (Hier ist es jetzt besonders wichtig, die Tests auszuführen!).

8.	Zum Schluss verschieben wir Methode `getFrequentRenterPoints()`in die Klasse `Rental`. Können Sie begründen, warum?

9.	Die Methode statement ist im Moment auch noch für die Berechnung von `totalAmount` und `totalFrequentRenterPoints` verantwortlich und nicht nur für die reine Ausgabe der entsprechenden Informationen. Um das zu verbessern, soll die Klasse `User` die Methoden `getTotalCharge()` und `getTotalFrequentRenterPoints()` erhalten. Das entsprechende Refactoring heisst wieder **Replace Temp with Query**, allerdings kann es nicht automatisch gemacht werden, weil schreibenderweise auf die Variablen zugegriffen wird. 

   **Zusätzliche Schwierigkeit:** Die for-Schleife wird dabei in den beiden neuen Methoden aufgerufen. Hier ist es besonders wichtig, nach jedem Schritt die Tests auszuführen!

10.	Das Refactoring von der `User.statement()` Methode ist damit beendet, jede Methode hat nun genau eine Verantwortlichkeit. Bevor Sie weiterlesen, schauen sie sich noch die anderen Klassen `Rental` und `Movie` an, was könnten Sie da noch verbessern? 

11.	Sie haben bemerkt, dass die `getCharge()` Methode immer noch nicht am richtigen Ort ist. Wieso nicht? Verschieben Sie sie in die richtige Klasse. Versuchen Sie dabei, keine Abhängigkeit zur Klasse Rentals zu generieren, indem sie zuerst einen Parameter für getDaysRented() einführen (**Introduce Parameter**). Rufen Sie danach alle aufrufenden Stellen auf und ändern den Code so, dass Sie `Rental.movie` wieder privat setzen können. 

12.	Machen Sie das gleiche mit der `getFrequentRenterPoints()`. Entfernen Sie den unnötigen Parameter `Rental`. Schauen Sie sich die Klasse `Rental` nochmals an, sind Sie zufrieden?

13.	Dann bleibt die Klasse `MovieImpl`. Um das swicht-Statment mit Polymorphismus zu ersetzen, könnten drei Subklassen von `MovieImpl` abgeleitet werden: `RegularMovie`, `ChildrensMovie` und `NewReleaseMovie` und jede Subklasse implementiert ihre eigene Version von `getCharge()`. Dabei würden folgende Refactorings zum Tragen kommen: **Self Encapsulate Field**, **Replace Conditional with Polymorphism**. Leider kann dann ein Video aber seine Klassifikation (New, Regular, ...) nicht mehr ändern.
   
   Eine bessere, aber aufwändigere Lösung ist die Verwendung des State Pattern statt der direkten Vererbung -> siehe Klassendiagramm unten. Zusätzlich kommen hier noch die Refactorings **Replace Type Code with State/Strategy**, **Move Method** zum Einsatz. Beginnen Sie dieses Refactoring zunächst mit einem **Self Encapsulate Field** um die Variable `priceCode` besser zu kapseln.

   ![Class Diagram for State Pattern](doc/ApplyStatePattern.png)


*Vergleichen Sie die neue Implementierung mit der alten. Wie beurteilen Sie die Lesbarkeit und Verständlichkeit der beiden Lösungen*

