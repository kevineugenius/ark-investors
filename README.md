### Running the App
Run the project with `mvn spring-boot:run`. Maven should download necessary dependencies during compilation. By default, no profile is active. An active maven profile will automatically activate the  Spring profile of the same name. A profile can by set by adding `-P profile-name` to the above command. Profiles are defined in `pom.xml`. Alternatively, a profile can be set to active in the `pom.xml` file by adding to the declaration:
```
<activation>
    <activeByDefault>true</activeByDefault>
</activation>
```

### App Notes
The app is a very rudimentary and basic start to the given challenge. The database tables only hold the data that is necessary for basic functions to work and would normally include many more columns. 

### Documentation
- Method  
Documentation is written in markdown files and uses Mermaid. These will display correctly in GitHub with no changes, to view in IntelliJ the Markdown plugin is required and the Mermaid extension must be installed and applied to that extension.  
[More details here.](https://www.jetbrains.com/help/idea/markdown.html#diagrams)  
Additionally, you can copy and paste the markdown into a live editor online if you don't want to view on GitHub or IntelliJ.
[Mermaid Live Editor](https://mermaid.live/)  
- Example:

```mermaid
graph TD;
A-->B;
A-->C;
B-->D;
C-->D;
```  
- Additional Documentation  
The project contains more markdown files for individual features in the `/doc` directory.

### Authentication

### Database
The project includes a dev H2 database called tempdb. With the app running, access it by browsing to `http://localhost:8080/api/v1/h2-console`.

### Testing

### Code Cleanliness Tools
This app currently does not use any automated tools for clean or consistent code.  Adding a proper linting tool is on the horizon.  For now, all formatting is done with IntelliJ standards.