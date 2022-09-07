### Running the App
Run the project with `mvn spring-boot:run`. Maven should download necessary dependencies during compilation.

### App Notes
The app is a very rudimentary and basic start to the given challenge. The database tables only hold the data that is necessary for basic functions to work and would normally include many more columns. 

### Documentation
*todo: where is the documentation located?*  
Documentation is written in markdown files and uses Mermaid. These will display correctly in GitHub with no changes, to view in IntelliJ the Markdown plugin is required and the Mermaid extension must be installed and applied to that extension.  
[More details here.](https://www.jetbrains.com/help/idea/markdown.html#diagrams)  
Additionally, you can copy and paste the markdown into a live editor online if you don't want to view on GitHub or IntelliJ.
[Mermaid Live Editor](https://mermaid.live/)  
Example:

```mermaid
graph TD;
A-->B;
A-->C;
B-->D;
C-->D;
```
### Authentication

### Testing

### Code Cleanliness Tools
This app currently does not use any automated tools for clean or consistent code.  Adding a proper linting tool is on the horizon.  For now, all formatting is done with IntelliJ standards.