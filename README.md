Beispiele zu Spring Security und Apache Shiro
=============================================

Dies sind die vollständigen Beispielprogramme zum Javamagazin-Artikel.


Übersetzen und Generieren von Projektdateien
--------------------------------------------

Die Sourcen können mit [Gradle](http://gradle.org/) übersetzt werden. Es
ist nicht zwingend erforderlich, hierfür Gradle zu installieren. Der
Gradle-Wrapper `gradlew` kümmert sich um alle benötigten Abhängigkeiten.
Mittels

```bash
gradlew war
```

wird eine WAR-Datei erzeugt. Die Befehle

```bash
gradlew idea
gradlew eclipse
```

generieren Projektdateien für IntelliJ Idea bzw. Eclipse.


Tags und Branches
-----------------

Dieses Repository enthält zwei Branches zusätzlich zum Master:
 * master: Die ungesicherte Beispielsanwendung
 * spring: Die einzelnen Schritte mit Spring Security
 * shiro: Die einzelnen Schritte mit Apache Shiro

Entsprechend der Arbeitsschritte im Artikel gibt es Tags:
 * Sicherung mittels URL-Filter
   * `spring-urlfilter`
   * `shiro-urlfilter`
 * Selektives Rendern mit JSP-Tags
   * `spring-jsptags`
   * `shiro-jsptags`
 * Zugriffskontrolle mit Annotations
   * `shiro-annotations`
   * `spring-jsr250` - Verwendung der Annotationen aus JSR 250
   * `spring-annotations` - Verwendung der Spring-Annotationen
 * Eigener Authentisierungs-Provider
   * `shiro-authprov`
   * `spring-authprov`
   * `spring-permauthprov` - eine Skizze für einen (im Artikel nicht
     weiter vorgestellten) Permission Evaluator, um auch mit Spring
     Security Privileges verwenden zu können

