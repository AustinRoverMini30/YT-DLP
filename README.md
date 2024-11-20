
# YouTube Downloader (JavaFX + YT-DLP)

Un téléchargeur YouTube puissant et intuitif développé en JavaFX, utilisant l'exécutable [YT-DLP](https://github.com/yt-dlp/yt-dlp) pour offrir des fonctionnalités avancées de téléchargement. Ce projet ajoute une interface graphique moderne pour simplifier l'expérience utilisateur.

---

## Fonctionnalités

- **Téléchargement vidéo** : Téléchargez des vidéos en plusieurs résolutions disponibles.
- **Téléchargement audio** : Extrayez l'audio des vidéos sous divers formats (MP3, AAC, etc.).
- **Interface intuitive** : Une interface graphique développée avec JavaFX.
- **Support FFmpeg** : Intégration avec FFmpeg pour la conversion audio/vidéo (recommandé).
- **Mises à jour automatiques** : Le programme vérifie et installe les mises à jour directement depuis le dépôt.
- **Support des playlists** : Téléchargez des vidéos en lot à partir de playlists.

---

## Prérequis

- **Java** : Assurez-vous d'avoir Java 11 ou une version ultérieure installée.
- **YT-DLP** : Le programme repose sur [YT-DLP](https://github.com/yt-dlp/yt-dlp). Téléchargez l'exécutable [ici](https://github.com/yt-dlp/yt-dlp/releases).
- **FFmpeg** : Pour les fonctionnalités avancées de conversion, téléchargez [ffmpeg-master-latest-win64-gpl](https://www.gyan.dev/ffmpeg/builds/).

---

## Installation

1. Clonez le projet sur votre machine :
   ```bash
   git clone https://github.com/your-username/youtube-downloader.git
   cd youtube-downloader
   ```

2. Placez l'exécutable YT-DLP dans le répertoire du projet ou configurez le chemin dans les paramètres du programme.

3. Téléchargez et placez **FFmpeg** dans un dossier accessible via le `PATH` système ou configurez son chemin dans le programme.

4. Lancez l'application :
   ```bash
   java -jar YouTubeDownloader.jar
   ```

---

## Utilisation

1. Ajoutez une URL YouTube (ou une playlist).
2. Sélectionnez le format vidéo ou audio souhaité.
3. Cliquez sur **Télécharger**.
4. Accédez au dossier de téléchargement pour récupérer vos fichiers.

![Capture d'écran - Écran principal](#) <!-- Ajouter une capture d'écran ici -->

---

## Captures d'écran

### Écran principal
![Capture d'écran - Écran principal](#)

### Options avancées
![Capture d'écran - Options avancées](#)

---

## Copyright et Avertissements

- Ce projet utilise [YT-DLP](https://github.com/yt-dlp/yt-dlp), un outil open-source. Consultez leur [documentation](https://github.com/yt-dlp/yt-dlp#license) pour en savoir plus sur les droits et restrictions.
- Les utilisateurs sont responsables de respecter les lois sur les droits d'auteur en vigueur dans leur pays lors du téléchargement de contenu.

---

## Contributeurs

- [Nicolas CHAMPY](https://github.com/AustinRoverMini30) – Développeur principal

---
