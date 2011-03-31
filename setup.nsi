; Setup.nsi
;
; This script is perhaps one of the simplest NSIs you can make. All of the
; optional settings are left to their default settings. The installer simply
; prompts the user asking them where to install, and drops a copy of "MyProg.exe"
; there.

;--------------------------------

;zhtu
; Disable compression
SetCompressor LZMA


;MSetShellVarContext current

AutoCloseWindow True
; The name of the installer
Name "Lernen mit Smiley 1.0"

MiscButtonText "Zurück""Weiter""Abbrechen""Beenden"
DetailsButtonText "Details anzeigen"
CompletedText	 "Installation abgeschlossen"
InstallButtonText "Installieren"
UninstallButtonText "Deinstallieren"
SpaceTexts "Grösse: ""Verfügbarer Speicherplatz: "
XPStyle on
ShowInstDetails show
BrandingText " "

; The file to write
OutFile "Setup.exe"

; The default installation directory
InstallDir "$PROGRAMFILES\Lernen mit Smiley"

InstallDirRegKey HKLM "Software\Nico Bosshard\Lernen mit Smiley" "Install Path"



; The text to prompt the user to enter a directory
DirText "In welches Verzeichnis sollte das Lernprogramm installiert werden?$\nWenn dies ein Update ist, sollten Sie den vorgeschlagen Pfad annehmen, da sonst alle Spielstände verloren gehen."


;Page license
Page components
Page directory
Page instfiles

ComponentText "Überprüfen Sie die Komponenten, die Sie installieren möchten, und deaktivieren Sie die Komponenten, die Sie nicht installieren möchten.$\nWenn Sie nicht viel von Computer verstehen, drücken sie auf Weiter.""""Zu installierenden Komponenten:"
Section "Links für alle Benutzer" g1o1
SetShellVarContext all
SectionEnd
Section "Link auf dem Desktop" g1o2
StrCpy $1 "1"
SectionEnd
Section "Link in die Startprogramme" g1o3
StrCpy $2 "1"
SectionEnd
Section "Link im Startmenü" g1o4
StrCpy $3 "1"
SectionEnd


;LicenseText "Lernen mit Smiley"
;LicenseData Lizens.txt
;LicenseForceSelection checkbox
;LicenseForceSelection checkbox "i accept"


;--------------------------------

; The stuff to install
Section "" ;No components page, name is not important
; Set output path to the installation directory.
SetOutPath $INSTDIR



RMDir /r $INSTDIR\Bilder
RMDir /r $INSTDIR\Sounds
RMDir /r `$SMPROGRAMS\Nico Bosshard`
; Put file there
File /r /x *.bb* /x *.info /x *.db /x *.Mid /x "" ".\Lernen mit Smiley 1.0\"


; Register uninstaller
WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Lernen mit Smiley" \
                 "DisplayName" "Lernen mit Smiley - Lernprogramm 3. bis 5. Klasse"
WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Lernen mit Smiley" \
                 "UninstallString" "$\"$INSTDIR\uninstall.exe$\""

WriteUninstaller $INSTDIR\uninstall.exe

; Startmenu
StrCmp $3 "1" 0 +2
CreateShortCut "$STARTMENU\Lernen mit Smiley.lnk" "$INSTDIR\Lernen mit Smiley.exe"
;Startprogramme
StrCmp $2 "1" 0 +2
CreateShortCut "$SMPROGRAMS\Lernen mit Smiley.lnk" "$INSTDIR\Lernen mit Smiley.exe"
; Desktop Link
StrCmp $1 "1" 0 +2
CreateShortCut "$DESKTOP\Lernen mit Smiley.lnk" "$INSTDIR\Lernen mit Smiley.exe"
; Save Path for updates
WriteRegStr HKLM "Software\Nico Bosshard\Lernen mit Smiley" "Install Path" "$INSTDIR"

MessageBox MB_YESNO "Die Installation wurde erfolgreich abgeschlossen!$\nWollen Sie mein Lernprogramm jetzt starten?" IDYES True IDNO False
True:
  Exec '"$INSTDIR\Lernen mit Smiley.exe"'
  GoTo next
False:
next:

SectionEnd ; end the section




Section "Uninstall"
;AutoCloseWindow true
MessageBox MB_YESNO "Wollen Sie mein Lernprogramm wirklich deinstallieren?" IDYES True1 IDNO False1
True1:
  Delete $INSTDIR\uninstall.exe ; delete self (see explanation below why this works)
  Delete `$INSTDIR\Lernen mit Smiley.exe`
  Delete `$DESKTOP\Lernen mit Smiley.lnk`
  Delete "$SMPROGRAMS\Lernen mit Smiley.lnk"
  Delete "$STARTMENU\Lernen mit Smiley.lnk"
  RMDir /r $INSTDIR
  RMDir /r `$SMPROGRAMS\Nico Bosshard`
  DeleteRegKey HKLM `Software\Microsoft\Windows\CurrentVersion\Uninstall\Lernen mit Smiley`
False1:
Quit
SectionEnd