![Tech Icons](https://skillicons.dev/icons?i=java,gradle,spring,react,aws,cloudflare)

# 📋 Cura

> A cutting-edge, medical equipment maintenance tracking solution built with a powerful Java Spring Boot backend and a sleek, static React front-end, supported by an AWS RDS database.

---

## 🚀 Key Features

- 🔄 **Real-Time Monitoring**: Track equipment status and maintenance schedules in real time.
- 🛠️ **Automated Reminders**: Get notified when equipment is due for maintenance.
- 📊 **Analytics Dashboard**: Visualize maintenance history and performance trends.
- 🔒 **Secure & Scalable**: Built with industry standards for security and scalability.

---

## 🏗️ Project Stack

A streamlined monorepo split into two primary directories:

### 🖥️ Server (`/server`)

- **Java 21**
- **Spring Boot** Framework
- **Gradle** Build Tool
- **PostgreSQL** on AWS RDS

### 🌐 Client (`/client`)

- **TypeScript** + **React**
- **Vite** for lightning-fast dev builds
- **Tailwind CSS** for utility-first styling
- **Static Hosting** via AWS CloudFront or similar

---

## 📁 File Structure

```plaintext
/
├── server/                    # 🖥️ Java Spring Boot backend
│   ├── src/main/java/         # • Java source code
│   ├── src/main/resources/    # • Config files (application.properties)
│   ├── build.gradle           # • Gradle build script
│   ├── settings.gradle        # • Gradle settings
│   └── README.md              # • Backend-specific docs
├── client/                    # 🌐 React + Vite frontend
│   ├── src/                   # • React components & pages
│   ├── public/                # • Static assets (index.html, favicon)
│   ├── package.json           # • NPM dependencies & scripts
│   ├── vite.config.ts         # • Vite config
│   └── README.md              # • Frontend-specific docs
├── .github/workflows/         # ⚙️ CI/CD (GitHub Actions)
├── .gitignore                 # 🚫 Ignored files for both projects
└── README.md                  # 📖 Project overview
