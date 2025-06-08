![](https://skillicons.dev/icons?i=java,gradle,spring,react,aws,cloudflare)

 # MedTrace
 > A medical focused equipment maintenance tracking solution. Using a Java springboot backend, with a static React front-end and AWS RDS database.

---

## File Structure

The project is contained in a single mono repo, and split into the `backend/` and `frontend/` directories respectfully

```plaintext
/
├── server/                    # Java Spring Boot backend
│   ├── src/main/java/         # Java source code
│   ├── src/main/resources/    # Application config (application.properties, etc.)
│   ├── build.gradle           # Gradle build file
│   ├── settings.gradle        # Gradle settings
│   └── README.md              # Backend-specific docs
├── client/                    # React + Vite frontend
│   ├── src/                   # React components & pages
│   ├── public/                # Static public assets (index.html, favicon, etc.)
│   ├── package.json           # NPM dependencies & scripts
│   ├── vite.config.js         # Vite configuration
│   └── README.md              # Frontend-specific docs
├── .github/workflows/         # CI/CD workflows (GitHub Actions)
├── .gitignore                 # Git ignore rules (covers both backend + frontend)
└── README.md                  # Project overview
```
