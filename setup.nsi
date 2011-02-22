; Setup.nsi
;
; This script is perhaps one of the simplest NSIs you can make. All of the
; optional settings are left to their default settings. The installer simply
; prompts the user asking them where to install, and drops a copy of "MyProg.exe"
; there.

;--------------------------------


AutoCloseWindow true

; The name of the installer
Name "Lernen mit Smiley"

; Disable compression
SetCompressor LZMA

; The file to write
OutFile "Setup.exe"

; The default installation directory
InstallDir "$PROGRAMFILES\Lernen mit Smiley"

InstallDirRegKey HKLM "Software\Nico Bosshard\Lernen mit Smiley" "Install Path"



; The text to prompt the user to enter a directory
DirText "In welches Verzeichnis sollte das Lernprogramm installiert werden?"

;--------------------------------

; The stuff to install
Section "" ;No components page, name is not important

; Set output path to the installation directory.
SetOutPath $INSTDIR


; Put file there
File /r /x *.bb* /x *.info /x *.db /x *.Mid /x "" ".\Lernen mit Smiley 0.5\"


; Register uninstaller
WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Lernen mit Smiley" \
                 "DisplayName" "Lernen mit Smiley -- Lernprogram für 3. bis 5. Klasse"
WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Lernen mit Smiley" \
                 "UninstallString" "$\"$INSTDIR\uninstall.exe$\""

WriteUninstaller $INSTDIR\uninstall.exe

; Startmenu
CreateDirectory "$SMPROGRAMS\Nico Bosshard"
CreateShortCut "$SMPROGRAMS\Nico Bosshard\Lernen mit Smiley.lnk" "$INSTDIR\Lernen mit Smiley.exe"
; Desktop Link

CreateShortCut "$DESKTOP\Lernen mit Smiley.lnk" "$INSTDIR\Lernen mit Smiley.exe"

; Save Path for updates
WriteRegStr HKLM "Software\Nico Bosshard\Lernen mit Smiley" "Install Path" "$INSTDIR"

MessageBox MB_YESNO "Die Instalation wurde erfolgreich abgeschlossen!$\nMit einem Klick auf OK wird mein Lernprogramm automatisch gestartet." IDYES true IDNO false
true:
  Exec '"$INSTDIR\Lernen mit Smiley.exe"'
  GoTo next
false:
next:

SectionEnd ; end the section



Section "Uninstall"
  Delete $INSTDIR\uninstall.exe ; delete self (see explanation below why this works)
  Delete `$INSTDIR\Lernen mit Smiley.exe`
  RMDir /r $INSTDIR
  RMDir /r `$SMPROGRAMS\Nico Bosshard`
  DeleteRegKey HKLM `Software\Microsoft\Windows\CurrentVersion\Uninstall\Lernen mit Smiley`
SectionEnd
