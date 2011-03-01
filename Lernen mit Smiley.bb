AppTitle "Lernen mit Smiley"
Const width=1280,height=1024
Const xsize=16
Const ysize=16
Const xdiv=width/xsize
Const ydiv=height/ysize
Const total=xdiv*ydiv
Const frames=25
Const choice=total/frames
Const fps=25
Const ZeitMaxRS = 50  ; 0.1 Sekunden

HidePointer

Global NNWA
Global DNGA1GB
Global Spielfigur$
Global g
Global FY
Global FX
Global HGrundSF
Global SFG#
Global WarnungF$
Global JaO
Global NeinO
Global Name$
Global Aufgaben
Global Schwierigkeitsstufe
Global Smiley
Global Saund$
Global Protokoll$
Global AAAB
Global KTIBWG
Global filename$
Global ERINV
Global ESPS
Global BildSagen
Global hgjkhkgkh
Global AndGetroffenS
Global Fehler16SS2
Global Fehler16SS3
Global Fehler16SS4
Global Fehler16SS5
Global Fehler16SS6
Global Anfang
Global HGrund1
Global HGrund2
Global HGrund3
Global HGrund4
Global HGrund5
Global HGrund6
Global HGrund7
Global HGrund8
Global HGrund9
Global HGrund10
Global HGrund11
Global HGrund12
Global HGrund13
Global HGrund14
Global HGrund15
Global HGrund16
Global HGrund17
Global HGrund18
Global HGrund19
Global HGrund20
Global Auswahl0
Global Auswahl1
Global Auswahl2
Global Auswahl3
Global Auswahl4
Global Auswahl5
Global Auswahl6
Global Auswahl7
Global Auswahl8
Global Auswahl9
;Global Uebersicht
Global UebersichtA
Global SchwierikeitsstufeA
Global HRTZUIO
Global HERHZ
Global NameS$
Global NameN$
Global SpielstandLA
Global ASDREFGHHGHUJK
Global roket
;Global L
;Global A
Global hotX
Global hotY
Global hotW
Global hotH
Global hotX1
Global hotY1
Global hotW1
Global hotH1
;Global x
;Global y
Global gfxCircle
Global Textverstentnis
Global circleX
Global circleY
Global Nomen
Global Nomen1
Global Nomen2
Global Smeili

.PStart

Modus=GfxModeExists(1280,1024,16)
If Modus=0 Then
filename$=".\Grafik.txt"
If FileType(filename$)=0 Then
ESPS=1
fileout = WriteFile(".\Grafik.txt")
WriteLine fileout,"Grafik: 1280,1024,0,3"
CloseFile fileout
EndIf
Else
filename$=".\Grafik.txt"
If FileType(filename$)=0 Then
ESPS=1
fileout = WriteFile(".\Grafik.txt")
WriteLine fileout,"Grafik: 1280,1024,0,2"
CloseFile fileout
EndIf
EndIf

filein = ReadFile(".\Grafik.txt")
Grafik$ = ReadLine$(filein)
Pos=Instr(Grafik$," ")
Grafik$=Right$(Grafik$,Len(Grafik$)-Pos)

Pos1=Instr(Grafik$,",")
Grafik1$=Left$ (Grafik$,Pos1-1)
Pos2=Instr(Grafik$,",",Pos1+1)
Grafik2$=Mid$ (Grafik$,Pos1+1,(Pos2-Pos1)-1)
Pos3=Instr(Grafik$,",",Pos2+1)
Grafik3$=Mid$ (Grafik$,Pos2+1,(Pos3-Pos2)-1)
Pos4=Instr(Grafik$,",",Pos3+1)
Grafik4$=Mid$ (Grafik$,Pos3+1,(Pos4-Pos3)-1)

CloseFile filein

Graphics Grafik1$,Grafik2$,Grafik3$,Grafik4$




TB=LoadImage(".\Bilder\Titelbild.jpg")
TileBlock TB
Schrift = LoadFont ("Arial",130,20100)
SetFont Schrift
Color 0,0,0
Text 170,400,"Lernen mit Smiley"
StartZeit = MilliSecs()
Const ZeitMaxSLMS = 1500  ; 2 Sekunden
Dim RST$(1499)
Dim DVGHJFHMHJG(8)
Dim SteinK(8)
Dim GetroffenS(6)
Dim A14Z(6)
Dim Fehler16SS(8)
Dim sf(11)
Dim SFRXP(4)
Dim SFRXM(4)
Dim WMZM$(20)
Dim QWM$(20)
Dim NBIMWM$(20)
Dim NZDGW(30)
Delay 100

ZPFN$=zielpfad$
zielpfad$=zielpfad$+".\"

Color 0,0,0
Dateiname$="Neuste_Version.txt"
rocket = LoadWebImage ("http://www.nicobosshard.ch/cgi-bin/Neuste_Version.txt")

    Flip
zielpfad$=ZPFN$
ExecFile DateiLMS$


Function LoadWebImage (webFile$)
DA=DA-1
    If BlitzGet (webFile$, CurrentDir (), Dateiname$)
        image = LoadImage (Dateiname$)
    EndIf
    Return image
End Function

Function BlitzGet (webFile$, saveDir$, saveFile$)
DATTEX$=webFile$
    If Left (webFile$, 7) = "http://" Then webFile$ = Right (webFile$, Len (webFile$) - 7)
    slash = Instr (webFile$, "/")
    If slash
        webHost$ = Left (webFile$, slash - 1)
        webFile$ = Right (webFile$, Len (webFile$) - slash + 1)
    Else
        webHost$ = webFile$
        webFile$ = "/"
    EndIf
    If Right (saveDir$, 1) <> "\" Then saveDir$ = saveDir$ + "\"
    If saveFile$ = ""
        If webFile = "/"
            saveFile$ = "Unknown file.txt"
        Else
            For findSlash = Len (webFile$) To 1 Step - 1
                testForSlash$ = Mid (webFile$, findSlash, 1)
                If testForSlash$ = "/"
                    saveFile$ = Right (webFile$, Len (webFile$) - findSlash)
                    Exit
                EndIf
            Next
            If saveFile$ = "" Then saveFile$ = "Unknown file.txt"
        EndIf
    EndIf
    www = OpenTCPStream (webHost$, 80)

    If www
    
        WriteLine www, "GET " + webFile$ + " HTTP/1.1"
        WriteLine www, "Host: " + webHost$
        WriteLine www, "User-Agent: BlitzGet Deluxe"
        WriteLine www, "Accept: */*"
        WriteLine www, ""
        Repeat
            header$ = ReadLine (www)
            If Left (header$, 16) = "Content-Length: "
                bytesToRead = Right (header$, Len (header$) - 16)
            EndIf
        Until header$ = "" Or (Eof (www))
        
        If bytesToRead = 0 Then Goto skipDownLoad
        save = WriteFile (saveDir$ + saveFile$)
        If Not save Then Goto skipDownload

        For readWebFile = 1 To bytesToRead
        
            If Not Eof (www) Then WriteByte save, ReadByte (www)
            
            
            tReadWebFile = readWebFile
            ;Geschwindikeit
            If tReadWebFile Mod 100000 = 0 Then BytesReceived (readWebFile, bytesToRead)

        Next
        EIW$=Right (WebFile$,4)
        CloseFile save
        
        If (readWebFile - 1) = bytesToRead
            success = 1
        EndIf
        
        BytesReceived (bytesToRead, bytesToRead)
        
        .skipDownload
        CloseTCPStream www
        
    Else
    
        ERINV=1
        Goto KINVB1
        
    EndIf
    
    Return success
.KINVB1
End Function

Function BytesReceived (posByte, totalBytes)
  If KTIBWG=1 Then
    Cls
    Text 20, 20, "Dateien werden heruntergeladen, bitte warten..."
    Text 20, 60,DATTEX$
    If posByte<1000000 Then Text 20, 100,"0,"+Left(posByte,1)+"/" + totalBytes/1000000 + " Megabytes wurden heruntergeladen (" + Percent (posByte, totalBytes) + "%)"
    If posByte>=1000000 And posByte<10000000 Then Text 20, 100, Left(posByte,1)+","+Mid(posByte,2,1)+"/" + totalBytes/1000000 + " Megabytes wurden heruntergeladen (" + Percent (posByte, totalBytes) + "%)"
    If posByte>=10000000 And posByte<100000000 Then Text 20, 100, Left(posByte,2)+","+Mid(posByte,3,1)+"/" + totalBytes/1000000 + " Megabytes wurden heruntergeladen (" + Percent (posByte, totalBytes) + "%)"
    If posByte>=100000000 And posByte<1000000000 Then Text 20, 100, Left(posByte,3)+","+Mid(posByte,4,1)+"/" + totalBytes/1000000 + " Megabytes wurden heruntergeladen (" + Percent (posByte, totalBytes) + "%)"
    If posByte>=1000000000 Then Text 20, 100, Left(posByte,2)+","+Mid(posByte,3,1)+"/" + totalBytes/1000000 + " Megabytes wurden heruntergeladen (" + Percent (posByte, totalBytes) + "%)"
	If posByte=>10000000000 Then RuntimeError"Datei darf nicht grösser als 1 Gigabite sein!"
VWait
  EndIf
End Function

Function Percent (part#, total#)
    Return Int (100 * (part / total))
End Function

If ERINV=1 Then Goto KINVB2
filein = ReadFile("Neuste_Version.txt")
ReadLine$(filein)
NV$ = ReadLine$(filein)
CloseFile filein
filein = ReadFile(".\Aktuelle Version.txt")
ReadLine$(filein)
AV$ = ReadLine$(filein)
CloseFile filein
AAAB=0
E=0
filename$="Nicht an diese Version erinnern.txt"
If FileType(filename$)=1 Then AAAB=1
If FileType(filename$)=0 Then AAAB=2
If AAAB=1 Then
filein = ReadFile("Nicht an diese Version erinnern.txt")
NE$ = ReadLine$(filein)
CloseFile filein
Else
NE$ = "0"
EndIf
If AV$<>NV$ And NV$<>NE$ Then
Cls
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial",50,20100)
SetFont Schrift
Print "Neue Version "+NV$+" wurde gefunden."
Print "Soll sie jetzt heruntergeladen und installiert werden?"
Print "Der Vorgang kann einige Minuten in Anspruch nehmen."
Print ""
Print "Ja: Drücke 1"
Print "Nein: Drücke 2"
Print "An diese Version nicht mehr erinnern: Drücke 3"
Taste=WaitKey()
Cls
Locate 1,1
If Taste=49 Then
ClsColor 255,155,255
Cls
Color 0,0,0
Delay 100
ZPFN$=zielpfad$
zielpfad$=zielpfad$+".\"
KTIBWG=1
Dateiname$="Setup.html"
rocket = LoadWebImage ("http://www.nicobosshard.ch/cgi-bin/Setup.exe")
CreateDir ".\Setup"
CopyFile ".\Setup.exe",".\Update\Setup.exe"
DeleteFile ".\Setup.exe"
Datei$=".\Update\Setup.exe"
ExecFile Datei$
End
EndIf
If Taste=50 Then
Cls
TB=LoadImage(".\Bilder\Titelbild.jpg")
TileBlock TB
Schrift = LoadFont ("Arial",130,20100)
SetFont Schrift
Color 0,0,0
Text 170,400,"Lernen mit Smiley"
Delay 100
EndIf
If Taste=51 Then
fileout = WriteFile("Nicht an diese Version erinnern.txt")
WriteLine fileout,NV$
CloseFile(fileout)
Cls
TB=LoadImage(".\Bilder\Titelbild.jpg")
TileBlock TB
Schrift = LoadFont ("Arial",130,20100)
SetFont Schrift
Color 0,0,0
Text 170,400,"Lernen mit Smiley"
Delay 100
EndIf
EndIf


.KINVB2

a$="n"
Auswahl=LoadImage (".\Bilder\Gletscher.jpg")
Auswahl1a=LoadImage (".\Bilder\Spiel starten.jpg")
Auswahl1b=LoadImage (".\Bilder\Spiel startenO.jpg")
Auswahl2a=LoadImage (".\Bilder\Übersicht.jpg")
Auswahl2b=LoadImage (".\Bilder\ÜbersichtO.jpg")
Auswahl3a=LoadImage (".\Bilder\Protokoll.jpg")
Auswahl3b=LoadImage (".\Bilder\ProtokollO.jpg")
Auswahl4a=LoadImage (".\Bilder\Spielfigur wählen.jpg")
Auswahl4b=LoadImage (".\Bilder\Spielfigur wählenO.jpg")
Auswahl5a=LoadImage (".\Bilder\Schwierigkeitsstufe wählen.jpg")
Auswahl5b=LoadImage (".\Bilder\Schwierigkeitsstufe wählenO.jpg")
Auswahl6a=LoadImage (".\Bilder\Spielstandoptionen.jpg")
Auswahl6b=LoadImage (".\Bilder\SpielstandoptionenO.jpg")
Auswahl7a=LoadImage (".\Bilder\Grafik.jpg")
Auswahl7b=LoadImage (".\Bilder\GrafikO.jpg")
Auswahl8a=LoadImage (".\Bilder\Programm beenden.jpg")
Auswahl8b=LoadImage (".\Bilder\Programm beendenO.jpg")
SW=Auswahl;LoadImage (".\Bilder\Gletscher.jpg")
SWK1=LoadImage (".\Bilder\SchwierigkeitsstufeK1.jpg")
SWK2=LoadImage (".\Bilder\SchwierigkeitsstufeK2.jpg")
SWK3=LoadImage (".\Bilder\SchwierigkeitsstufeK3.jpg")
SWK4=LoadImage (".\Bilder\SchwierigkeitsstufeK4.jpg")
SWK5=LoadImage (".\Bilder\SchwierigkeitsstufeK5.jpg")
SWK1O=LoadImage (".\Bilder\SchwierigkeitsstufeK1O.jpg")
SWK2O=LoadImage (".\Bilder\SchwierigkeitsstufeK2O.jpg")
SWK3O=LoadImage (".\Bilder\SchwierigkeitsstufeK3O.jpg")
SWK4O=LoadImage (".\Bilder\SchwierigkeitsstufeK4O.jpg")
SWK5O=LoadImage (".\Bilder\SchwierigkeitsstufeK5O.jpg")
Uebersicht=Auswahl;LoadImage (".\Bilder\Gletscher.jpg")
Uebersicht1a=LoadImage (".\Bilder\Übersicht1a.jpg")
Uebersicht2a=LoadImage (".\Bilder\Übersicht2a.jpg")
Uebersicht3a=LoadImage (".\Bilder\Übersicht3a.jpg")
Uebersicht4a=LoadImage (".\Bilder\Übersicht4a.jpg")
Uebersicht5a=LoadImage (".\Bilder\Übersicht5a.jpg")
Uebersicht6a=LoadImage (".\Bilder\Übersicht6a.jpg")
Uebersicht7a=LoadImage (".\Bilder\Übersicht7a.jpg")
Uebersicht8a=LoadImage (".\Bilder\Übersicht8a.jpg")
Uebersicht9a=LoadImage (".\Bilder\Übersicht9a.jpg")
Uebersicht10a=LoadImage (".\Bilder\Übersicht10a.jpg")
Uebersicht11a=LoadImage (".\Bilder\Übersicht11a.jpg")
Uebersicht12a=LoadImage (".\Bilder\Übersicht12a.jpg")
Uebersicht13a=LoadImage (".\Bilder\Übersicht13a.jpg")
Uebersicht14a=LoadImage (".\Bilder\Übersicht14a.jpg")
Uebersicht15a=LoadImage (".\Bilder\Übersicht15a.jpg")
Uebersicht16a=LoadImage (".\Bilder\Übersicht16a.jpg")
Uebersicht17a=LoadImage (".\Bilder\Übersicht17a.jpg")
Uebersicht18a=LoadImage (".\Bilder\Übersicht18a.jpg")
Uebersicht19a=LoadImage (".\Bilder\Übersicht19a.jpg")
Uebersicht20a=LoadImage (".\Bilder\Übersicht20a.jpg")
Uebersicht21a=LoadImage (".\Bilder\Übersicht21a.jpg")
Uebersicht1b=LoadImage (".\Bilder\Übersicht1b.jpg")
Uebersicht2b=LoadImage (".\Bilder\Übersicht2b.jpg")
Uebersicht3b=LoadImage (".\Bilder\Übersicht3b.jpg")
Uebersicht4b=LoadImage (".\Bilder\Übersicht4b.jpg")
Uebersicht5b=LoadImage (".\Bilder\Übersicht5b.jpg")
Uebersicht6b=LoadImage (".\Bilder\Übersicht6b.jpg")
Uebersicht7b=LoadImage (".\Bilder\Übersicht7b.jpg")
Uebersicht8b=LoadImage (".\Bilder\Übersicht8b.jpg")
Uebersicht9b=LoadImage (".\Bilder\Übersicht9b.jpg")
Uebersicht10b=LoadImage (".\Bilder\Übersicht10b.jpg")
Uebersicht11b=LoadImage (".\Bilder\Übersicht11b.jpg")
Uebersicht12b=LoadImage (".\Bilder\Übersicht12b.jpg")
Uebersicht13b=LoadImage (".\Bilder\Übersicht13b.jpg")
Uebersicht14b=LoadImage (".\Bilder\Übersicht14b.jpg")
Uebersicht15b=LoadImage (".\Bilder\Übersicht15b.jpg")
Uebersicht16b=LoadImage (".\Bilder\Übersicht16b.jpg")
Uebersicht17b=LoadImage (".\Bilder\Übersicht17b.jpg")
Uebersicht18b=LoadImage (".\Bilder\Übersicht18b.jpg")
Uebersicht19b=LoadImage (".\Bilder\Übersicht19b.jpg")
Uebersicht20b=LoadImage (".\Bilder\Übersicht20b.jpg")
Uebersicht21b=LoadImage (".\Bilder\Übersicht21b.jpg")
SPK=Auswahl;LoadImage (".\Bilder\Gletscher.jpg")
SPK1=LoadImage (".\Bilder\SpielstandoptionenK1.jpg")
SPK2=LoadImage (".\Bilder\SpielstandoptionenK2.jpg")
SPK3=LoadImage (".\Bilder\SpielstandoptionenK3.jpg")
SPK4=LoadImage (".\Bilder\SpielstandoptionenK4.jpg")
SPK5=LoadImage (".\Bilder\SpielstandoptionenK5.jpg")
SPK6=LoadImage (".\Bilder\SpielstandoptionenK6.jpg")
SPK1O=LoadImage (".\Bilder\SpielstandoptionenK1O.jpg")
SPK2O=LoadImage (".\Bilder\SpielstandoptionenK2O.jpg")
SPK3O=LoadImage (".\Bilder\SpielstandoptionenK3O.jpg")
SPK4O=LoadImage (".\Bilder\SpielstandoptionenK4O.jpg")
SPK5O=LoadImage (".\Bilder\SpielstandoptionenK5O.jpg")
SPK6O=LoadImage (".\Bilder\SpielstandoptionenK6O.jpg")
NA=Auswahl;LoadImage (".\Bilder\Gletscher.jpg")
NAK1=LoadImage (".\Bilder\NAK1.jpg")
NAK2=LoadImage (".\Bilder\NAK2.jpg")
NAK3=LoadImage (".\Bilder\NAK3.jpg")
NAK1O=LoadImage (".\Bilder\NAK1O.jpg")
NAK2O=LoadImage (".\Bilder\NAK2O.jpg")
NAK3O=LoadImage (".\Bilder\NAK3O.jpg")



MaskImage Uebersicht1a,0,0,255
MaskImage Uebersicht2a,0,0,255
MaskImage Uebersicht3a,0,0,255
MaskImage Uebersicht4a,0,0,255
MaskImage Uebersicht5a,0,0,255
MaskImage Uebersicht6a,0,0,255
MaskImage Uebersicht7a,0,0,255
MaskImage Uebersicht8a,0,0,255
MaskImage Uebersicht9a,0,0,255
MaskImage Uebersicht10a,0,0,255
MaskImage Uebersicht11a,0,0,255
MaskImage Uebersicht12a,0,0,255
MaskImage Uebersicht13a,0,0,255
MaskImage Uebersicht14a,0,0,255
MaskImage Uebersicht15a,0,0,255
MaskImage Uebersicht16a,0,0,255
MaskImage Uebersicht17a,0,0,255
MaskImage Uebersicht18a,0,0,255
MaskImage Uebersicht19a,0,0,255
MaskImage Uebersicht20a,0,0,255
MaskImage Uebersicht21a,0,0,255
MaskImage Uebersicht1b,0,0,255
MaskImage Uebersicht2b,0,0,255
MaskImage Uebersicht3b,0,0,255
MaskImage Uebersicht4b,0,0,255
MaskImage Uebersicht5b,0,0,255
MaskImage Uebersicht6b,0,0,255
MaskImage Uebersicht7b,0,0,255
MaskImage Uebersicht8b,0,0,255
MaskImage Uebersicht9b,0,0,255
MaskImage Uebersicht10b,0,0,255
MaskImage Uebersicht11b,0,0,255
MaskImage Uebersicht12b,0,0,255
MaskImage Uebersicht13b,0,0,255
MaskImage Uebersicht14b,0,0,255
MaskImage Uebersicht15b,0,0,255
MaskImage Uebersicht16b,0,0,255
MaskImage Uebersicht17b,0,0,255
MaskImage Uebersicht18b,0,0,255
MaskImage Uebersicht19b,0,0,255
MaskImage Uebersicht20b,0,0,255
MaskImage Uebersicht21b,0,0,255
MaskImage SPK1,255,0,0
MaskImage SPK2,255,0,0
MaskImage SPK3,255,0,0
MaskImage SPK4,255,0,0
MaskImage SPK5,255,0,0
MaskImage SPK6,255,0,0
MaskImage SPK1O,255,0,0
MaskImage SPK2O,255,0,0
MaskImage SPK3O,255,0,0
MaskImage SPK4O,255,0,0
MaskImage SPK5O,255,0,0
MaskImage SPK6O,255,0,0
MaskImage NAK1,0,0,255
MaskImage NAK2,0,0,255
MaskImage NAK3,0,0,255
MaskImage NAK1O,0,0,255
MaskImage NAK2O,0,0,255
MaskImage NAK3O,0,0,255
MaskImage SWK1,0,0,255
MaskImage SWK2,0,0,255
MaskImage SWK3,0,0,255
MaskImage SWK4,0,0,255
MaskImage SWK5,0,0,255
MaskImage SWK1O,0,0,255
MaskImage SWK2O,0,0,255
MaskImage SWK3O,0,0,255
MaskImage SWK4O,0,0,255
MaskImage SWK5O,0,0,255

AuswahOBL=1
If KeyHit(57) Then
ESPS=1
EndIf
FlushKeys
FlushMouse


If ESPS=1 Then Goto Anfang Else Goto AnfangN



.Anfang            
Cls
Locate 1,1
Schrift = LoadFont ("Arial",30,201)
SetFont Schrift
Anfang=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage Anfang, 0,0
Print "Ich bedanke mich herzlich, dass Sie mein Lernprogramm installiert haben!"
Print ""
Print "Bei Problemen schreiben Sie mir einfach unter nico@bosshome.ch ein E-Mail."
Print "Viel Spass beim Lernen mit meinem Lernprogramm!"
Input()
Goto AnfangN
End







.AnfangN
HGrundH=LoadImage (".\Bilder\Titelbild.jpg")
Schrift = LoadFont ("Arial",60,True)
SchriftF = LoadFont ("Arial",50,True)
Datum$=CurrentDate$()
DATUMM$=Mid$(Datum$,4,3)
If DATUMM$="Jan" Then DATUMM$="Januar"
If DATUMM$="Feb" Then DATUMM$="Februar"
If DATUMM$="Mar" Then DATUMM$="März"
If DATUMM$="Apr" Then DATUMM$="April"
If DATUMM$="May" Then DATUMM$="Mai"
If DATUMM$="Jun" Then DATUMM$="Juni"
If DATUMM$="Jul" Then DATUMM$="Juli"
If DATUMM$="Aug" Then DATUMM$="August"
If DATUMM$="Sep" Then DATUMM$="September"
If DATUMM$="Oct" Then DATUMM$="Oktober"
If DATUMM$="Nov" Then DATUMM$="November"
If DATUMM$="Dec" Then DATUMM$="Dezember"
Protokoll1$=" "
Protokoll2$=Left$(Datum$,2)+" "+DATUMM$+" "+Right$(Datum$,4)
Repeat
JetztZeit = MilliSecs()
Delay 25
Until JetztZeit-StartZeit >= ZeitMaxSLMS
Locate 510,160
TileBlock HGrundH
Color 253,243,0
Rect 72,64,1153,195,1

SetFont Schrift
Color 0,0,0
ClsColor 2,12,255
Text 640,100,"Gib deinen Namen ein und drücke auf Enter",1
FlushMouse
FlushKeys

Name$ = Input()


If KeyHit(1)=True
End
EndIf
If Len (Name$)<3 Then Goto Fehler1

If FileType(Name$+".txt") = 0 Then
fileout = WriteFile(Name$+".txt")
CloseFile fileout
SpielstandS
EndIf

filein = ReadFile(Name$+".txt")
Aufgabenst$=ReadLine$(filein)
Aufgabenst$=Right$(Aufgabenst$,Len(Aufgabenst$)-Instr(Aufgabenst$,"="))
Aufgaben=Aufgabenst$
SchwierigkeitsstufeRL$=ReadLine$(filein)
SchwierigkeitsstufeRL$=Right$(SchwierigkeitsstufeRL$,Len(SchwierigkeitsstufeRL$)-Instr(SchwierigkeitsstufeRL$,"="))
Schwierigkeitsstufe=SchwierigkeitsstufeRL$
Spielfigur$=ReadLine$(filein)
Spielfigur$=Right$(Spielfigur$,Len(Spielfigur$)-Instr(Spielfigur$,"="))
CloseFile filein


filein = ReadFile(Name$+".txt")
ReadLine$(filein)
ReadLine$(filein)
ReadLine$(filein)
ReadLine$(filein)
For i=1 To 1499
RST$(i)=ReadLine$(filein)
If RST$(i)=Protokoll2$ Then Protokoll1$="" Protokoll2$="" Exit
hfjdvbkvsl=hfjdvbkvsl+1
If hfjdvbkvsl=25 Then hfjdvbkvsl=0 PSeiten=PSeiten+1
Next
CloseFile filein

Protokoll$=Protokoll1$
SpielstandS
Protokoll$=Protokoll2$
SpielstandS
Protokoll$=""

SeedRnd MilliSecs()
If Aufgaben=0 Then Sound$="Harfe 3"
If Aufgaben=1 Then Sound$="Harfe 3"
If Aufgaben=2 Then Sound$="Harfe 3"
If Aufgaben=3 Then Sound$="Harfe 3"
If Aufgaben=4 Then Sound$="Harfe 2"
If Aufgaben=5 Then Sound$="Harfe 2"
If Aufgaben=6 Then Sound$="Harfe 2"
If Aufgaben=7 Then Sound$="Harfe 1"
If Aufgaben=8 Then Sound$="Harfe 1"
If Aufgaben=9 Then Sound$="Harfe 1"
If Aufgaben=10 Then Sound$="Harfe 1"
If Aufgaben=11 Then Sound$="Harfe 1"
If Aufgaben=12 Then Sound$="Harfe 1"
If Aufgaben=13 Then Sound$="Harfe 1"
If Aufgaben=14 Then Sound$="Harfe 1"
If Aufgaben=15 Then Sound$="Harfe 1"
If Aufgaben=16 Then Sound$="Harfe 1"
If Aufgaben=17 Then Sound$="Harfe 1"
If Aufgaben=18 Then Sound$="Harfe 1"
If Aufgaben=19 Then Sound$="Harfe 1"
If Aufgaben=100 Then Sound$="Harfe "+Rand(1,3)
HM=LoadSound(".\Sounds\"+Sound$+".mp3")
LoopSound HM
HGM=PlaySound (HM)



Goto F2

.Fehler1
Cls
Locate 1,1
Locate 510,160
TileBlock HGrundH
Color 253,243,0
Rect 72,64,1153,195,1

SetFont SchriftF
Color 0,0,0
ClsColor 2,12,255
Text 640,100,"Der Name muss mindestens aus drei Zeichen bestehen!",1
FlushMouse
FlushKeys
Delay 2750
FlushKeys
Goto AnfangN
End


.F2
If Spielfigur$="" Then
ClsVB
TFormFilter 0
Schrift = LoadFont ("Arial",50,20100)
SetFont Schrift
HGrundH=LoadImage (".\Bilder\Gletscher.jpg")
DrawImage HGrundH, 0,0
Fig1=LoadImage (".\Bilder\Figur1.bmp")
Fig2=LoadImage (".\Bilder\Figur2.bmp")
Fig3=LoadImage (".\Bilder\Figur3.bmp")
Fig4=LoadImage (".\Bilder\Figur4.bmp")
Fig5=LoadImage (".\Bilder\Figur5.bmp")
Fig6=LoadImage (".\Bilder\Figur6.bmp")
Fig7=LoadImage (".\Bilder\Figur7.bmp")
Fig8=LoadImage (".\Bilder\Figur8.bmp")
ResizeImage Fig1,ImageWidth(Fig1)*3,ImageHeight(Fig1)*3
ResizeImage Fig2,ImageWidth(Fig2)*3,ImageHeight(Fig2)*3
ResizeImage Fig3,ImageWidth(Fig3)*3,ImageHeight(Fig3)*3
ResizeImage Fig4,ImageWidth(Fig4)*3,ImageHeight(Fig4)*3
ResizeImage Fig5,ImageWidth(Fig5)*3,ImageHeight(Fig5)*3
ResizeImage Fig6,ImageWidth(Fig6)*3,ImageHeight(Fig6)*3
ResizeImage Fig7,ImageWidth(Fig7)*3,ImageHeight(Fig7)*3
ResizeImage Fig8,ImageWidth(Fig8)*3,ImageHeight(Fig8)*3
DrawImage Fig1, 5,120
DrawImage Fig2, 330,120
DrawImage Fig3, 660,120
DrawImage Fig4, 985,120
DrawImage Fig5, 5,500
DrawImage Fig6, 330,500
DrawImage Fig7, 660,500
DrawImage Fig8, 985,500
Text 612,20,"Welche Spielfigur willst du haben?",1,1
Text 612,70,"Gib die Nummer der Spielfigur ein.",1,1
Text 115,420,"1"
Text 458,420,"2"
Text 785,420,"3"
Text 1100,420,"4"
Text 115,800,"5"
Text 458,800,"6"
Text 785,800,"7"
Text 1100,800,"8"
Repeat
Taste=WaitKey()
If Taste=49 Then
Spielfigur$=".\Bilder\Figur1.bmp"
SpielstandS
Exit
ElseIf Taste=50 Then
Spielfigur$=".\Bilder\Figur2.bmp"
SpielstandS
Exit
ElseIf Taste=51 Then
Spielfigur$=".\Bilder\Figur3.bmp"
SpielstandS
Exit
ElseIf Taste=52 Then
Spielfigur$=".\Bilder\Figur4.bmp"
Exit
ElseIf Taste=53 Then
Spielfigur$=".\Bilder\Figur5.bmp"
Exit
ElseIf Taste=54 Then
Spielfigur$=".\Bilder\Figur6.bmp"
Exit
ElseIf Taste=55 Then
Spielfigur$=".\Bilder\Figur7.bmp"
Exit
ElseIf Taste=56 Then
Spielfigur$=".\Bilder\Figur8.bmp"
Exit
EndIf
Forever
EndIf

SF(1)=LoadImage (Spielfigur$)
SF(2)=LoadImage (Spielfigur$)
SF(3)=LoadImage (Spielfigur$)
SF(4)=LoadImage (Spielfigur$)
SF(5)=LoadImage (Spielfigur$)
SF(6)=LoadImage (Spielfigur$)
SF(7)=LoadImage (Spielfigur$)
SF(8)=LoadImage (Spielfigur$)
SF(9)=LoadImage (Spielfigur$)
SF(10)=LoadImage (Spielfigur$)
SF(11)=LoadImage (Spielfigur$)
TFormFilter 0
VWait
ResizeImage SF(1),ImageWidth(SF(1))*3,ImageHeight(SF(1))*3
ResizeImage SF(2),ImageWidth(SF(2))*2.8,ImageHeight(SF(2))*2.8
ResizeImage SF(3),ImageWidth(SF(3))*2.6,ImageHeight(SF(3))*2.6
ResizeImage SF(4),ImageWidth(SF(4))*2.4,ImageHeight(SF(4))*2.4
ResizeImage SF(5),ImageWidth(SF(5))*2.2,ImageHeight(SF(5))*2.2
ResizeImage SF(6),ImageWidth(SF(6))*2,ImageHeight(SF(6))*2
ResizeImage SF(7),ImageWidth(SF(7))*1.8,ImageHeight(SF(7))*1.8
ResizeImage SF(8),ImageWidth(SF(8))*1.6,ImageHeight(SF(8))*1.6
ResizeImage SF(9),ImageWidth(SF(9))*1.4,ImageHeight(SF(9))*1.4
ResizeImage SF(10),ImageWidth(SF(10))*1.2,ImageHeight(SF(10))*1.2
VWait



AAAB=0
;Wichtig!
;Wichtig!
;Wichtig!
ASDREFGHHGHUJK=1


;Name$=0
SpielstandLA=0
NameN$=0
HERHZ=0
NameS$=0
HRTZUIO=0
SchwierikeitsstufeA=0
UebersichtA=0
SpielstandKopierenA=0
HERHZ=0

If Schwierigkeitsstufe=0 Then AuswahOBL=0 SWZH=1 Goto SchwierikeitsstufeW



.Auswahl
Protokoll$=""
FlushKeys
FlushMouse
FreeSound GameP
FreeSound Game
If AuswahOBL=1 Then Goto AuswahOB
AppTitle "Lernen mit Smiley"
;Sachen =0
roket=0
x=0
y=0
X=0
Y=0
HGrundH=0
ASDREFGHHGHUJK=0
hotX=0
hotY=0
hotW=0
hotH=0
hotX1=0
hotY1=0
hotW1=0
hotH1=0
Textverstentnis=0
circleX=0
circleY=0
Nomen=0
Nomen1=0
Nomen2=0
ClsVB
If jhhfgfsSFGjsgjmsgmsztzsh=1 Then
PauseChannel MXP
Goto Uebersicht
EndIf
UebersichtA=0

.AuswahOB
Auswahl=LoadImage (".\Bilder\Gletscher.jpg")
AuswahOBL=0
;Wichtig!
;Wichtig!
;Wichtig!
ASDREFGHHGHUJK=1
gfxCircle=CreateImage(20,20)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 0,0,20,20,1
SetBuffer BackBuffer()
Color 0,0,255


Auswahl1=Auswahl1a
Auswahl2=Auswahl2a
Auswahl3=Auswahl3a
Auswahl4=Auswahl4a
Auswahl5=Auswahl5a
Auswahl6=Auswahl6a
Auswahl7=Auswahl7a
Auswahl8=Auswahl8a

StartZeit = MilliSecs()
Const ZeitMaxHA = 1000  ; 1 Sekunden


Repeat
circleX=MouseX()
circleY=MouseY()
NNEZKAW=0
DrawImage Auswahl, 0,0
DrawImage Auswahl1, 340,110
DrawImage Auswahl2, 340,210
DrawImage Auswahl3, 340,310
DrawImage Auswahl4, 340,410
DrawImage Auswahl5, 340,510
DrawImage Auswahl6, 340,610
DrawImage Auswahl7, 340,710
DrawImage Auswahl8, 340,810
DrawImage gfxCircle,circleX,circleY
Flip
JetztZeit = MilliSecs()

If ImageRectOverlap (gfxCircle,circleX,circleY,340,110,600,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxHA) Then Goto Programmstart
Auswahl1=Auswahl1b
NNEZKAW=1
Else
Auswahl1=Auswahl1a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,210,600,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxHA) Then Goto Uebersicht
Auswahl2=Auswahl2b
NNEZKAW=1
Else
Auswahl2=Auswahl2a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,310,600,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxHA) Then Goto Protokoll
Auswahl3=Auswahl3b
NNEZKAW=1
Else
Auswahl3=Auswahl3a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,410,600,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxHA) Then Goto SpielfigurW
Auswahl4=Auswahl4b
NNEZKAW=1
Else
Auswahl4=Auswahl4a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,510,600,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxHA) Then Goto SchwierikeitsstufeW
Auswahl5=Auswahl5b
NNEZKAW=1
Else
Auswahl5=Auswahl5a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,610,600,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxHA) Then Goto SpielstandKopieren
Auswahl6=Auswahl6b
NNEZKAW=1
Else
Auswahl6=Auswahl6a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,710,600,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxHA) Then Goto Grafik
Auswahl7=Auswahl7b
NNEZKAW=1
Else
Auswahl7=Auswahl7a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,810,600,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxHA) Then Goto EPro
Auswahl8=Auswahl8b
NNEZKAW=1
Else
Auswahl8=Auswahl8a
EndIf
Delay 50
Forever


.EPro
SeedRnd MilliSecs()
ClsVB
img = CreateImage (1280,1024)
SetBuffer ImageBuffer (img)
TB=LoadImage(".\Bilder\Titelbild.jpg")
TileBlock TB
Schrift = LoadFont ("Arial",130,20100)
SetFont Schrift
Color 0,0,0
Text 640,375,"Lernen mit Smiley",1
Text 640,525,"von Nico Bosshard",1
VWait
SetBuffer FrontBuffer()
HGML#=1

Dim matrix(xdiv,ydiv)
For ii = 1 To frames
	For I = 1 To choice
		Repeat
			x=Rnd(0,xdiv)
			y=Rnd(0,ydiv)
		Until matrix(x,y)=0
		matrix(x,y)=ii
	Next
Next
dly=CreateTimer(fps)
For frm=0 To frames
	WaitTimer(dly)
	For x=0 To xdiv
		For y=0 To ydiv
			If matrix(x,y)=frm
				DrawImageRect img,x*xsize,y*ysize,x*xsize,y*ysize,xsize,ysize
			End If
		Next
	Next
Next
Delay 2500
Color 0,0,0
For frm=0 To frames
	WaitTimer(dly)
	For x=0 To xdiv
		For y=0 To ydiv
			If matrix(x,y)=frm
				Rect x*xsize,y*ysize,xsize,ysize
			End If
		Next
		ChannelVolume HGM,HGML#
HGML#=HGML#-0.0005
	Next
Next
VWait
Delay 150
End







.Uebersicht
ClsVB
jhhfgfsSFGjsgjmsgmsztzsh=0
AuswahOBL=0
;Wichtig!
;Wichtig!
;Wichtig!
ASDREFGHHGHUJK=1

NNEZKAW=0

SetBuffer BackBuffer()

UebersichtA=1
FlushKeys
FlushMouse
StartZeit = MilliSecs()
Const ZeitMaxU = 1000  ; 1 Sekunden
Uebersicht1=Uebersicht1a
Uebersicht2=Uebersicht2a
Uebersicht3=Uebersicht3a
Uebersicht4=Uebersicht4a
Uebersicht5=Uebersicht5a
Uebersicht6=Uebersicht6a
Uebersicht7=Uebersicht7a
Uebersicht8=Uebersicht8a
Uebersicht9=Uebersicht9a
Uebersicht10=Uebersicht10a
Uebersicht11=Uebersicht11a
Uebersicht12=Uebersicht12a
Uebersicht13=Uebersicht13a
Uebersicht14=Uebersicht14a
Uebersicht15=Uebersicht15a
Uebersicht16=Uebersicht16a
Uebersicht17=Uebersicht17a
Uebersicht18=Uebersicht18a
Uebersicht19=Uebersicht19a
Uebersicht20=Uebersicht20a
Uebersicht21=Uebersicht21a
Repeat
NNEZKAW=0
circleX=MouseX()
circleY=MouseY()
DrawImage Uebersicht,0,0
DrawImage Uebersicht1, 380,0
DrawImage Uebersicht2, 380,48
DrawImage Uebersicht3, 380,96
DrawImage Uebersicht4, 380,144
DrawImage Uebersicht5, 380,192
DrawImage Uebersicht6, 380,240
DrawImage Uebersicht7, 380,288
DrawImage Uebersicht8, 380,336
DrawImage Uebersicht9, 380,384
DrawImage Uebersicht10, 380,432
DrawImage Uebersicht11, 380,480
DrawImage Uebersicht12, 380,528
DrawImage Uebersicht13, 380,576
DrawImage Uebersicht14, 380,624
DrawImage Uebersicht15, 380,672
DrawImage Uebersicht16, 380,720
DrawImage Uebersicht17, 380,768
DrawImage Uebersicht18, 380,816
DrawImage Uebersicht19, 380,864
DrawImage Uebersicht20, 380,912
DrawImage Uebersicht21, 380,960
DrawImage gfxCircle,circleX,circleY
Flip
Delay 50
JetztZeit = MilliSecs()

If ImageRectOverlap (gfxCircle,circleX,circleY,380,0,520,48) And NNEZKAW=0 Then
Uebersicht1=Uebersicht1b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe1
Else Uebersicht1=Uebersicht1a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,48,520,48) And NNEZKAW=0 Then
Uebersicht2=Uebersicht2b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe2
Else Uebersicht2=Uebersicht2a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,96,520,48) And NNEZKAW=0 Then
Uebersicht3=Uebersicht3b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe3
Else Uebersicht3=Uebersicht3a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,144,520,48) And NNEZKAW=0 Then
Uebersicht4=Uebersicht4b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe4
Else Uebersicht4=Uebersicht4a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,192,520,48) And NNEZKAW=0 Then
Uebersicht5=Uebersicht5b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe5
Else Uebersicht5=Uebersicht5a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,240,520,48) And NNEZKAW=0 Then
Uebersicht6=Uebersicht6b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe6
Else Uebersicht6=Uebersicht6a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,288,520,48) And NNEZKAW=0 Then
Uebersicht7=Uebersicht7b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe7
Else Uebersicht7=Uebersicht7a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,336,520,48) And NNEZKAW=0 Then
Uebersicht8=Uebersicht8b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe8
Else Uebersicht8=Uebersicht8a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,384,520,48) And NNEZKAW=0 Then
Uebersicht9=Uebersicht9b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe9
Else Uebersicht9=Uebersicht9a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,432,520,48) And NNEZKAW=0 Then
Uebersicht10=Uebersicht10b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe10
Else Uebersicht10=Uebersicht10a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,480,520,48) And NNEZKAW=0 Then
Uebersicht11=Uebersicht11b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe11
Else Uebersicht11=Uebersicht11a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,528,520,48) And NNEZKAW=0 Then
Uebersicht12=Uebersicht12b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe12
Else Uebersicht12=Uebersicht12a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,576,520,48) And NNEZKAW=0 Then
Uebersicht13=Uebersicht13b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe13
Else Uebersicht13=Uebersicht13a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,624,520,48) And NNEZKAW=0 Then
Uebersicht14=Uebersicht14b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe14
Else Uebersicht14=Uebersicht14a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,672,520,48) And NNEZKAW=0 Then
Uebersicht15=Uebersicht15b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe15
Else Uebersicht15=Uebersicht15a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,720,520,48) And NNEZKAW=0 Then
Uebersicht16=Uebersicht16b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe16
Else Uebersicht16=Uebersicht16a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,768,520,48) And NNEZKAW=0 Then
Uebersicht17=Uebersicht17b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe17
Else Uebersicht17=Uebersicht17a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,816,520,48) And NNEZKAW=0 Then
Uebersicht18=Uebersicht18b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe18
Else Uebersicht18=Uebersicht18a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,864,520,48) And NNEZKAW=0 Then
Uebersicht19=Uebersicht19b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe19
Else Uebersicht19=Uebersicht19a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,912,520,48) And NNEZKAW=0 Then
Uebersicht20=Uebersicht20b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto LAufgabe
Else Uebersicht20=Uebersicht20a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,380,960,520,48) And NNEZKAW=0 Then
Uebersicht21=Uebersicht21b NNEZKAW=1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Auswahl
Else Uebersicht21=Uebersicht21a
EndIf
Forever

.Uebersicht3
ResumeChannel HGM
jhhfgfsSFGjsgjmsgmsztzsh=1
Goto Auswahl
End




.Protokoll
ClsVB
PROAZOZ=20
hfjdvbkvsl=0
PSeiten=1
filein = ReadFile(Name$+".txt")
ReadLine$(filein)
ReadLine$(filein)
ReadLine$(filein)
ReadLine$(filein)
For i=1 To 1499
RST$(i)=ReadLine$(filein)
If RST$(i+1)="" Then Exit
hfjdvbkvsl=hfjdvbkvsl+1
If hfjdvbkvsl=29 Then hfjdvbkvsl=0 PSeiten=PSeiten+1
Next
CloseFile filein


ClsColor 253,202,13
Cls
Color 1,1,1
PSeitenA=1
Schrift55 = LoadFont ("Arial",55,True)
SetFont Schrift55
Text 640,10,"Protokoll Seite "+PSeitenA+"/"+PSeiten,1
Schrift30 = LoadFont ("Arial",30,True)
SetFont Schrift30
Text 640,970,"Weiter mit beliebiger Taste",1
SchriftN = LoadFont ("Arial",30)
SetFont SchriftN
SchriftF = LoadFont ("Arial",30,True)
SchriftD = LoadFont ("Arial",35,True)
filein = ReadFile(Name$+".txt")
ReadLine$(filein)
ReadLine$(filein)
ReadLine$(filein)
ReadLine$(filein)
NUESSCH=0
For i=1 To 1499
NUESSCH=NUESSCH+1
RST$(i)=ReadLine$(filein)
If RST$(i)="Plusrechnen" Or RST$(i)="Wörterdiktat" Or RST$(i)="Textverständnis (Der Standhafte Zinnsoldat)" Or RST$(i)="Nomen" Or RST$(i)="Labyrinth (Mit Hilfe der Lösung)" Or RST$(i)="Labyrinth" Or RST$(i)="Verben" Or RST$(i)="Wörter erraten" Or RST$(i)="Zeitverstänbtnis" Or RST$(i)="Witze" Or RST$(i)="Artikel" Or RST$(i)="Zahlen erraten" Or RST$(i)="Tennis" Or RST$(i)="Wortfeld Sagen" Or RST$(i)="Lotto" Or RST$(i)="Wörter merken" Or RST$(i)="Rechenspiel" Or RST$(i)="Schnellrechnen" Or RST$(i)="Adjektive" Or RST$(i)="Pronomen" Or RST$(i)="Letzte Aufgabe" Then SetFont SchriftF Else SetFont SchriftN
PDatK1$=Mid$(RST$(i),3,3)
PDatK2$=Mid$(RST$(i),4,3)
If PDatK1="Jan" Or PDatK1="Feb" Or PDatK1="Mär" Or PDatK1="Apr" Or PDatK1="Mai" Or PDatK1="Jun" Or PDatK1="Jul" Or PDatK1="Aug" Or PDatK1="Sep" Or PDatK1="Okt" Or PDatK1="Nov" Or PDatK1="Dez" Then SetFont SchriftD PDBEGA=PDBEGA+7
If PDatK2="Jan" Or PDatK2="Feb" Or PDatK2="Mär" Or PDatK2="Apr" Or PDatK2="Mai" Or PDatK2="Jun" Or PDatK2="Jul" Or PDatK2="Aug" Or PDatK2="Sep" Or PDatK2="Okt" Or PDatK2="Nov" Or PDatK2="Dez" Then SetFont SchriftD PDBEGA=PDBEGA+7
Text 640,((NUESSCH*30)+PROAZOZ)+PDBEGA,RST$(i),1
If RST$(i)="" Then Exit
If NUESSCH=29 And RST$(i+1)<>"" Then
WaitKey
Cls
PROAZOZ=50
PDBEGA=0
PSeitenA=PSeitenA+1
NUESSCH=0
SetFont Schrift55
Text 640,10,"Protokoll Seite "+PSeitenA+"/"+PSeiten,1
SetFont Schrift30
Text 640,970,"Weiter mit beliebiger Taste",1
EndIf
Next

CloseFile filein


WaitKey
Goto Auswahl
End



.SpielfigurW
Color 0,0,0
ClsColor 0,0,0
SetBuffer FrontBuffer()
Cls
FlushKeys
FlushMouse
TFormFilter 0
Schrift = LoadFont ("Arial",50,20100)
SetFont Schrift
HGrundH=LoadImage (".\Bilder\Gletscher.jpg")
DrawImage HGrundH, 0,0
Fig1=LoadImage (".\Bilder\Figur1.bmp")
Fig2=LoadImage (".\Bilder\Figur2.bmp")
Fig3=LoadImage (".\Bilder\Figur3.bmp")
Fig4=LoadImage (".\Bilder\Figur4.bmp")
Fig5=LoadImage (".\Bilder\Figur5.bmp")
Fig6=LoadImage (".\Bilder\Figur6.bmp")
Fig7=LoadImage (".\Bilder\Figur7.bmp")
Fig8=LoadImage (".\Bilder\Figur8.bmp")
ResizeImage Fig1,ImageWidth(Fig1)*3,ImageHeight(Fig1)*3
ResizeImage Fig2,ImageWidth(Fig2)*3,ImageHeight(Fig2)*3
ResizeImage Fig3,ImageWidth(Fig3)*3,ImageHeight(Fig3)*3
ResizeImage Fig4,ImageWidth(Fig4)*3,ImageHeight(Fig4)*3
ResizeImage Fig5,ImageWidth(Fig5)*3,ImageHeight(Fig5)*3
ResizeImage Fig6,ImageWidth(Fig6)*3,ImageHeight(Fig6)*3
ResizeImage Fig7,ImageWidth(Fig7)*3,ImageHeight(Fig7)*3
ResizeImage Fig8,ImageWidth(Fig8)*3,ImageHeight(Fig8)*3
DrawImage Fig1, 5,120
DrawImage Fig2, 330,120
DrawImage Fig3, 660,120
DrawImage Fig4, 985,120
DrawImage Fig5, 5,500
DrawImage Fig6, 330,500
DrawImage Fig7, 660,500
DrawImage Fig8, 985,500
Text 612,20,"Welche Spielfigur willst du haben?",1,1
Text 612,70,"Gib die Nummer der Spielfigur ein.",1,1
Text 115,420,"1"
Text 458,420,"2"
Text 785,420,"3"
Text 1100,420,"4"
Text 115,800,"5"
Text 458,800,"6"
Text 785,800,"7"
Text 1100,800,"8"
Repeat
Taste=WaitKey()
If Taste=49 Then
Spielfigur$=".\Bilder\Figur1.bmp"
SpielstandS
Exit
ElseIf Taste=50 Then
Spielfigur$=".\Bilder\Figur2.bmp"
SpielstandS
Exit
ElseIf Taste=51 Then
Spielfigur$=".\Bilder\Figur3.bmp"
SpielstandS
Exit
ElseIf Taste=52 Then
Spielfigur$=".\Bilder\Figur4.bmp"
Exit
ElseIf Taste=53 Then
Spielfigur$=".\Bilder\Figur5.bmp"
Exit
ElseIf Taste=54 Then
Spielfigur$=".\Bilder\Figur6.bmp"
Exit
ElseIf Taste=55 Then
Spielfigur$=".\Bilder\Figur7.bmp"
Exit
ElseIf Taste=56 Then
Spielfigur$=".\Bilder\Figur8.bmp"
Exit
EndIf
Forever
ClsVB
SF(1)=LoadImage (Spielfigur$)
SF(2)=LoadImage (Spielfigur$)
SF(3)=LoadImage (Spielfigur$)
SF(4)=LoadImage (Spielfigur$)
SF(5)=LoadImage (Spielfigur$)
SF(6)=LoadImage (Spielfigur$)
SF(7)=LoadImage (Spielfigur$)
SF(8)=LoadImage (Spielfigur$)
SF(9)=LoadImage (Spielfigur$)
SF(10)=LoadImage (Spielfigur$)
SF(11)=LoadImage (Spielfigur$)
TFormFilter 0
VWait
ResizeImage SF(1),ImageWidth(SF(1))*3,ImageHeight(SF(1))*3
ResizeImage SF(2),ImageWidth(SF(2))*2.8,ImageHeight(SF(2))*2.8
ResizeImage SF(3),ImageWidth(SF(3))*2.6,ImageHeight(SF(3))*2.6
ResizeImage SF(4),ImageWidth(SF(4))*2.4,ImageHeight(SF(4))*2.4
ResizeImage SF(5),ImageWidth(SF(5))*2.2,ImageHeight(SF(5))*2.2
ResizeImage SF(6),ImageWidth(SF(6))*2,ImageHeight(SF(6))*2
ResizeImage SF(7),ImageWidth(SF(7))*1.8,ImageHeight(SF(7))*1.8
ResizeImage SF(8),ImageWidth(SF(8))*1.6,ImageHeight(SF(8))*1.6
ResizeImage SF(9),ImageWidth(SF(9))*1.4,ImageHeight(SF(9))*1.4
ResizeImage SF(10),ImageWidth(SF(10))*1.2,ImageHeight(SF(10))*1.2
VWait
ClsVB
Delay 10
Cls

;Wichtig!
;Wichtig!
;Wichtig!
ASDREFGHHGHUJK=1
Goto Auswahl
End





.SchwierikeitsstufeW
ClsVB
Const ZeitMaxSW=1000  ; 1 Sekunden
gfxCircle=CreateImage(20,20)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 0,0,20,20,1
SetBuffer BackBuffer()
Color 0,0,255
SWKA1=SWK1
SWKA2=SWK2
SWKA3=SWK3
SWKA4=SWK4
SWKA5=SWK5

StartZeit = MilliSecs()

Repeat
circleX=MouseX()
circleY=MouseY()
NNEZKAW=0
DrawImage SW, 0,0
DrawImage SWKA1, 140,262
DrawImage SWKA2, 140,362
DrawImage SWKA3, 140,462
DrawImage SWKA4, 140,562
If SWZH=0 DrawImage SWKA5, 140,662
DrawImage gfxCircle,circleX,circleY
Flip
Delay 50
JetztZeit = MilliSecs()

If ImageRectOverlap (gfxCircle,circleX,circleY,140,262,1000,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxSW) Then Schwierigkeitsstufe=1 Exit
SWKA1=SWK1O
NNEZKAW=1
Else
SWKA1=SWK1
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,140,362,1000,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxSW) Then Schwierigkeitsstufe=2 Exit
SWKA2=SWK2O
NNEZKAW=1
Else
SWKA2=SWK2
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,140,462,1000,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxSW) Then Schwierigkeitsstufe=3 Exit
SWKA3=SWK3O
NNEZKAW=1
Else
SWKA3=SWK3
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,140,562,1000,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxSW) Then Schwierigkeitsstufe=4 Exit
SWKA4=SWK4O
NNEZKAW=1
Else
SWKA4=SWK4
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,140,662,1000,100) And SWZH=0 And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxSW) Then Exit
SWKA5=SWK5O
NNEZKAW=1
Else
SWKA5=SWK5
EndIf
Forever

SpielstandS
If SWZH=1 Then SWZH=0 Goto Vorfilm
Goto Auswahl
End




.SpielstandKopieren
CLSVB
gfxCircle=CreateImage(20,20)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 0,0,20,20,1
SetBuffer BackBuffer()
Color 0,0,255
SPKA1=SPK1
SPKA2=SPK2
SPKA3=SPK3
SPKA4=SPK4
SPKA5=SPK5
SPKA6=SPK6

StartZeit = MilliSecs()
Const ZeitMaxSK=1000  ; 1 Sekunden
Repeat
circleX=MouseX()
circleY=MouseY()
NNEZKAW=0
DrawImage SPK, 0,0
DrawImage SPKA1, 340,212
DrawImage SPKA2, 340,312
DrawImage SPKA3, 340,412
DrawImage SPKA4, 340,512
DrawImage SPKA5, 340,612
DrawImage SPKA6, 340,712
DrawImage gfxCircle,circleX,circleY
Flip
Delay 50
JetztZeit = MilliSecs()

If ImageRectOverlap (gfxCircle,circleX,circleY,340,212,600,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxSK) Then
quellpfad$ = ".\"+Name$+".txt"
zielpfad$ = ".\"+Name$+"BAK.txt"
CopyFile quellpfad$, zielpfad$

SpielstandKopierenA=0
;Wichtig!
;Wichtig!
;Wichtig!
ASDREFGHHGHUJK=1
ClsColor 253,202,13
Cls
Color 1,1,1
Locate 1,1
Print "Sicherungsdatei wurde erstellt!"
Delay 1500
Goto Auswahl
EndIf
SPKA1=SPK1O
NNEZKAW=1
Else
SPKA1=SPK1
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,312,600,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxSK) Then
WarnungF$="Willst du wirklich deinen Spielstand mit der letzten Sicherungsdatei überschreiben?"
WarnungA
If JaO=1 Then
Cls
If FileType(Name$+"BAK.txt") = 1 Then

DeleteFile ".\"+Name$+".txt"

quellpfad$ = ".\"+Name$+"BAK.txt"
zielpfad$ = ".\"+Name$+".txt"
CopyFile quellpfad$, zielpfad$
Print "Spielstand erfolgreich mit der letzten Sicherungsdatei überschrieben!"
Else
Print "Sicherungsdatei wurde nicht gefunden!"
EndIf
Delay 2500
EndIf
SpielstandKopierenA=0
;Wichtig!
;Wichtig!
;Wichtig!
ASDREFGHHGHUJK=1
Goto Auswahl
EndIf
SPKA2=SPK2O
NNEZKAW=1
Else
SPKA2=SPK2
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,412,600,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxSK) Then
ClsVB
HGrundH=LoadImage (".\Bilder\Zugersee.jpg")
DrawImage HGrundH, 0,0
HGrundH=LoadImage (".\Bilder\Lava.jpg")
TileBlock HGrundH
FlushKeys
Schrift = LoadFont ("Arial",35,201)
SetFont Schrift
Print "Gib bitte den Namen ein, dessen Spielstand du auf deinen Spielstand kopieren willst."
NameS$ = Input()
filename$=NameS$
If FileType(filename$)=1 Then
quellpfad$ = ".\"+NameS$+".txt"
zielpfad$ = ".\"+Name$+".txt"
CopyFile quellpfad$, zielpfad$



Schwierigkeitsstufe=SFFFFF
SpielstandKopierenA=0
;Wichtig!
;Wichtig!
;Wichtig!
ASDREFGHHGHUJK=1
Goto Auswahl
Else
Goto Fehler
EndIf
EndIf
SPKA3=SPK3O
NNEZKAW=1
Else
SPKA3=SPK3
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,512,600,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxSK) Then Goto SpielstandUn
SPKA4=SPK4O
NNEZKAW=1
Else
SPKA4=SPK4
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,612,600,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxSK) Then Goto SpielstandL
SPKA5=SPK5O
NNEZKAW=1
Else
SPKA5=SPK5
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,712,600,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxSK) Then Goto Auswahl
SPKA6=SPK6O
NNEZKAW=1
Else
SPKA6=SPK6
EndIf
Forever


.Fehler
ClsVB
Schrift = LoadFont ("Arial",45,201)
SetFont Schrift
ClsColor 253,202,13
Cls
Color 1,1,1
Print "Spielstand existiert nicht!"
Delay 3000
SpielstandKopierenA=0
Goto Auswahl
End





.Grafik
ClsVB
ClsColor 255,201,14
Cls
Schrift = LoadFont ("Arial",55,201)
SetFont Schrift
Print "Grafik"
Schrift = LoadFont ("Arial",28,201)
SetFont Schrift
fntArialB=LoadFont("Arial",32,True,False,False)
Print ""
SetFont fntArialB
Print "1280,1024,16,1 (Nicht empfohlen)"
SetFont Schrift
Print "Bei dieser Grafik wird mein Lernprogramm so verzogen, dass es den ganzen Bildschirm bedeckt."
Print "Vorteile:"
Print "Keine Ablenkungen von Hintergrundsfenstern."
Print "Wird von fast allen Bildschirmen unterstützt."
Print "Nachteile:"
Print "Lernprogramm wird eventuell sehr verzogen."
Print "Spiele die sehr viel Grafik benötigen werden wegen der Hochrechnumng der Grafik sehr langsam. "
Print "Das Fenster kann bei Problemen nicht einfach oben rechts geschlossen werden,"
Print "da das Kreuzchen schliessen fehlt."
Print ""
SetFont fntArialB
Print "1280,1024,16,2 (empfolen)"
SetFont Schrift
Print "Vorteile:"
Print "Die Grafik muss nicht umgerechnet werden."
Print "sehr schneller Grafikaufbau."
Print "Das Fenster kann bei Problenen einfach geschlossen werden"
Print "Nachteile:"
Print "Bei grossen Bildschirmen können  andere Fenster im Hintergrund stören"
Print "Wird nur von ca. 80% aller Bildschirmen unterstützt."
Print ""
SetFont fntArialB
Print "1280,1024,16,3 (empfohlen)"
SetFont Schrift
Print "Vorteile"
Print "Dieses Fenster ist skalierbar, dass heisst man kann es manuell vergrössern und verkleinern (mit der Maus"
Print "am Fensterrand ziehen) und so sich selber eine eigene Fenstergrösse formen"
Print "Wird von fast allen Bildschirmen unterstützt."
Print "Das Fenster kann bei Problenen einfach geschlossen werden"
Print "Nachteile:"
Print "Wird nach jedem Programmstart automatisch wieder auf den Standard verkleinert."
Print "Spiele die sehr viel Grafik benötigen werden wegen der Umrechnung der Grafik sehr langsam."
Print ""
Print "Um die Grafik zu ändern, schreiben Sie einfach in die Datei .\Grafik.txt die Grafik rein z.b. 1280,1024,16,3."
Print ""
Print "Zur Auswahl mit beliebiger Taste."
WaitKey
Goto Auswahl
End






.SpielstandUn
WarnungF$="Willst du wirklich deinen Spielstand mit allen Sicherungsdateien umbenennen?"
WarnungA
If JaO=1 Then
ClsVB
Schrift = LoadFont ("Arial",40,20100)
SetFont Schrift
Color 0,255,0
Lava=LoadImage (".\Bilder\Lava.jpg")
TileBlock Lava
Name$=NameS$
Print "Gib bitte deinen neuen Namen ein um deinen Spielstand umzubenennen."
Name$ = Input()



quellpfad$ = ".\"+NameS$+".txt"
zielpfad$ = ".\"+Name$+".txt"
CopyFile quellpfad$, zielpfad$


DeleteFile ".\"+NameS$+".txt"
DeleteFile ".\"+NameS$+"BAK.txt"
Else
Goto Auswahl
EndIf
End




.SpielstandL
WarnungF$="Willst du wirklich deinen Spielstand mit allen Sicherungsdateien löschen?"
WarnungA
If JaO=1 Then
DeleteFile ".\"+Name$+".txt"
DeleteFile ".\"+Name$+"BAK.txt"
FreeSound HM
Goto PStart
Else
;Wichtig!
;Wichtig!
;Wichtig!
ASDREFGHHGHUJK=1
Goto Auswahl
EndIf
End



;Programmstart
.Programmstart
If Protokoll$="" Or Aufgaben=100 Then NAJN=0 Else NAJN=1
Protokoll$=""
FreeSound Game
ResumeChannel HGM
SpielstandS

;Sachen=0
roket=0
x=0
y=0
X=0
Y=0
HGrundH=0
ASDREFGHHGHUJK=0
hotX=0
hotY=0
hotW=0
hotH=0
hotX1=0
hotY1=0
hotW1=0
hotH1=0
Textverstentnis=0
circleX=0
circleY=0
Nomen=0
Nomen1=0
Nomen2=0
FlushKeys
FlushMouse

CLSVB

Const ZeitMaxNA=1000  ; 1 Sekunden
If NAJN=1 Then
NAKA1=NAK1
NAKA2=NAK2
NAKA3=NAK3

StartZeit = MilliSecs()

Repeat
circleX=MouseX()
circleY=MouseY()
NNEZKAW=0
Cls
DrawImage NA, 1,0
DrawImage NAKA1, 240,362
DrawImage NAKA2, 240,462
DrawImage NAKA3, 240,562
DrawImage gfxCircle,circleX,circleY
Delay 50
Flip
JetztZeit = MilliSecs()

If ImageRectOverlap (gfxCircle,circleX,circleY,240,362,800,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxNA) Then Exit
NAKA1=NAK1O
NNEZKAW=1
Else
NAKA1=NAK1
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,240,462,800,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxNA) Then Goto Auswahl
NAKA2=NAK2O
NNEZKAW=1
Else
NAKA2=NAK2
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,240,562,800,100) And NNEZKAW=0 Then
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxNA) Then Goto EPro
NAKA3=NAK3O
NNEZKAW=1
Else
NAKA3=NAK3
EndIf
Forever
EndIf

If Aufgaben=1 Then Goto Teil2
If Aufgaben=2 Then Goto Teil3
If Aufgaben=3 Then Goto Teil4
If Aufgaben=4 Then Goto Teil5
If Aufgaben=5 Then Goto Teil6
If Aufgaben=6 Then Goto Teil7
If Aufgaben=7 Then Goto Teil8
If Aufgaben=8 Then Goto Teil9
If Aufgaben=9 Then Goto Teil10
If Aufgaben=10 Then Goto Teil11
If Aufgaben=11 Then Goto Teil12
If Aufgaben=12 Then Goto Teil13
If Aufgaben=13 Then Goto Teil14
If Aufgaben=14 Then Goto Teil15
If Aufgaben=15 Then Goto Teil16
If Aufgaben=16 Then Goto Teil17
If Aufgaben=17 Then Goto Teil18
If Aufgaben=18 Then Goto Teil19
If Aufgaben=19 Then Goto Teil20
If Aufgaben=100 Then Goto Uebersicht
Goto Vorfilm
End


.Teil1
ClsVB
FY=720
FX=500
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\Höle1.jpg")
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 0*SFG#, 64*SFG#, 22*SFG#, 32*SFG#
Delay 500
Cls
Repeat
SYP
SFGG=SFGG+1
Until SFGG=5
Goto Aufgabe1
End



.Teil2
ClsVB
FY=950
FX=520
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\Höle2&4.jpg")
Repeat
SYP
SYP
g=g+1
GZSFG
SYP
g=g+1
GZSFG
SFGG=SFGG+1
Until SFGG=3
ClsVB
FY=950
FX=550
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\Höle3.jpg")
Repeat
SYP
SYP
g=g+1
GZSFG
SYP
g=g+1
GZSFG
SFGG=SFGG+1
Until SFGG=3
Goto Aufgabe2
End


.Teil3
ClsVB
FY=950
FX=520
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\Höle2&4.jpg")
Repeat
SYP
SYP
g=g+1
GZSFG
SYP
g=g+1
GZSFG
SFGG=SFGG+1
Until SFGG=3
ClsVB
FY=950
FX=750
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\Höle5.jpg")
Repeat
SYP
SYP
g=g+1
GZSFG
SYP
g=g+1
GZSFG
SFGG=SFGG+1
Until SFGG=2
Goto Aufgabe3
End



.Teil4
ClsVB
HGML#=1
FY=950
FX=520
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\Höle6.jpg")
SYP
SYP
g=g+1
GZSFG
SYP
g=g+1
GZSFG
SFGG=SFGG+1
SYP
SYP
Repeat
ChannelVolume HGM,HGML#
HGML#=HGML#-0.0006
Delay 1
Until HGML#=<0
FreeSound HM
HM=LoadSound(".\Sounds\Harfe 2.mp3")
LoopSound HM
HGM=PlaySound (HM)
ChannelVolume HGM,HGML#
Repeat
ChannelVolume HGM,HGML#
HGML#=HGML#+0.0006
Delay 1
Until HGML#=>1
ClsVB
FY=365
FX=20
G=1
SFGG=0
GZSFG
HGrundSFOS=LoadImage (".\Bilder\Brücke.jpg")
SmileyB=LoadImage (".\Bilder\Smiley.bmp")
MaskImage SmileyB,255,255,255
DrawImage HGrundSFOS,0,0
DrawImage SmileyB,328,261
DrawImage SmileyB,605,175
DrawImage SmileyB,874,235
HGrundSF = CreateImage (1280,1024)
SetBuffer ImageBuffer (HGrundSF)
CopyRect 0,0,1280,1024,0,0,FrontBuffer(),ImageBuffer(HGrundSF)
SetBuffer FrontBuffer()
Repeat
SXPB
SFGG=SFGG+1
Until SFGG=3
Goto Aufgabe4
End




.Teil5
ClsVB
FY=260
FX=261
G=1
SFGG=0
GZSFG
HGrundSFOS=LoadImage (".\Bilder\Brücke.jpg")
SmileyB=LoadImage (".\Bilder\Smiley.bmp")
MaskImage SmileyB,255,255,255
DrawImage HGrundSFOS,0,0
DrawImage SmileyB,605,175
DrawImage SmileyB,874,235
HGrundSF = CreateImage (1280,1024)
SetBuffer ImageBuffer (HGrundSF)
CopyRect 0,0,1280,1024,0,0,FrontBuffer(),ImageBuffer(HGrundSF)
SetBuffer FrontBuffer()
Repeat
SXPB1
SFGG=SFGG+1
Until SFGG=3
Goto Aufgabe5
End



.Teil6
ClsVB
FY=140
FX=605
G=1
SFGG=0
GZSFG
HGrundSFOS=LoadImage (".\Bilder\Brücke.jpg")
SmileyB=LoadImage (".\Bilder\Smiley.bmp")
MaskImage SmileyB,255,255,255
DrawImage HGrundSFOS,0,0
DrawImage SmileyB,874,235
HGrundSF = CreateImage (1280,1024)
SetBuffer ImageBuffer (HGrundSF)
CopyRect 0,0,1280,1024,0,0,FrontBuffer(),ImageBuffer(HGrundSF)
SetBuffer FrontBuffer()
Repeat
SXPB2
SFGG=SFGG+1
Until SFGG=2
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 0*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+20
FY=FY+5
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 19*SFG#,32*SFG#, 22*SFG#, 32*SFG#
Delay 200
FX=FX+20
FY=FY+5
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 0*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+20
FY=FY+5
Goto Aufgabe6
End



.Teil7
ClsVB
FY=200
FX=874
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\Brücke.jpg")
TB1=LoadImage (".\Bilder\01.jpg")
Repeat
SXPB3
SFGG=SFGG+1
Until SFGG=5
SeedRnd MilliSecs()
ClsVB
img = CreateImage (1280,1024)
SetBuffer ImageBuffer (img)
TB=HGrundSF
DrawImage TB,0,0
VWait
SetBuffer FrontBuffer()
DrawImage TB,0,0
Dim matrix(xdiv,ydiv)
For ii = 1 To frames
	For I = 1 To choice
		Repeat
			x=Rnd(0,xdiv)
			y=Rnd(0,ydiv)
		Until matrix(x,y)=0
		matrix(x,y)=ii
	Next
Next
dly=CreateTimer(fps)
Color 0,0,0
For frm=0 To frames
	WaitTimer(dly)
	For x=0 To xdiv
		For y=0 To ydiv
			If matrix(x,y)=frm
				Rect x*xsize,y*ysize,xsize,ysize
			End If
		Next
	Next
Next
SeedRnd MilliSecs()
HGML#=1
ClsVB
img = CreateImage (1280,1024)
SetBuffer ImageBuffer (img)
DrawImage TB1,0,0
SetBuffer FrontBuffer()
Repeat
ChannelVolume HGM,HGML#
HGML#=HGML#-0.0006
Delay 1
Until HGML#=<0
FreeSound HM
HM=LoadSound(".\Sounds\Harfe 1.mp3")
LoopSound HM
HGM=PlaySound (HM)
ChannelVolume HGM,HGML#
Repeat
ChannelVolume HGM,HGML#
HGML#=HGML#+0.0006
Delay 1
Until HGML#=>1
Dim matrix(xdiv,ydiv)
For ii = 1 To frames
	For I = 1 To choice
		Repeat
			x=Rnd(0,xdiv)
			y=Rnd(0,ydiv)
			Until matrix(x,y)=0
		matrix(x,y)=ii
	Next
Next
dly=CreateTimer(fps)
For frm=0 To frames
	WaitTimer(dly)
	For x=0 To xdiv
		For y=0 To ydiv
			If matrix(x,y)=frm
				DrawImageRect img,x*xsize,y*ysize,x*xsize,y*ysize,xsize,ysize
			End If
		Next
	Next
Next
Delay 1000
ClsVB
FY=950
FX=600
G=1
SFGG=0
GZSFG
HGrundSF=TB1
Repeat
SYP
SYP
g=g+1
GZSFG
SYP
g=g+1
GZSFG
SFGG=SFGG+1
Until SFGG=5
SYP
Goto Aufgabe7
End



.Teil8
ClsVB
FY=950
FX=635
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\02.jpg")
Repeat
SYP
SYP
g=g+1
GZSFG
SYP
g=g+1
GZSFG
SFGG=SFGG+1
Until SFGG=3
Repeat
SFGG=SFGG+1
SYP
Until SFGG=12
Goto Aufgabe8
End


.Teil9
ClsVB
FY=950
FX=675
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\03.jpg")
Repeat
SYP
SYP
g=g+1
GZSFG
SYP
g=g+1
GZSFG
SFGG=SFGG+1
Until SFGG=4
Goto Aufgabe9
End


.Teil10
ClsVB
FY=950
FX=500
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\04.jpg")
Repeat
SYP
SYP
g=g+1
GZSFG
SYP
SYP
g=g+1
GZSFG
SYP
SFGG=SFGG+1
Until SFGG=3
SYP
Goto Aufgabe10
End


.Teil11
ClsVB
FY=950
FX=570
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\05.jpg")
Repeat
SYP
SYP
g=g+1
GZSFG
SYP
g=g+1
GZSFG
SFGG=SFGG+1
Until SFGG=5
Goto Aufgabe11
End

.Teil12
ClsVB
FY=950
FX=675
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\06.jpg")
Repeat
SYP
SYP
g=g+1
GZSFG
SYP
g=g+1
GZSFG
SFGG=SFGG+1
Until SFGG=4
SXM
SXM
SXM
SXM
SXM
SXM
SXM
SXM
SYP
SYP
g=g+1
GZSFG
SYP
g=g+1
GZSFG
SFGG=SFGG+1

SYP
SYP
SYP
Goto Aufgabe12
End

.Teil13
ClsVB
FY=950
FX=675
G=3
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\07.jpg")
SYP
SYP
SYP
SXM
SXM
SXM
SXM
g=g+1
GZSFG
SYP
SYP
SYP
SYP
g=g+1
GZSFG
SYP
SYP
SYP
SXP
SYP
SXP
g=g+1
GZSFG
SYP
SYP
SYP
SYP
SXP
SYP
SYP
Goto Aufgabe13
End

.Teil14
ClsVB
FY=650
FX=1200
G=2
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\08.jpg")
SXM
SXM
SXM
SXM
SXM
g=g+1
GZSFG
SYP
SXM
SXM
SXM
SXM
SXM
g=g+1
GZSFG
SYP
SXM
SXM
SXM
SXM
SXM
g=g+1
GZSFG
SXM
SXM
SYP
SXM
SXM
SXM
g=g+1
GZSFG
SYP
SYP
Goto Aufgabe14
End

.Teil15
ClsVB
FY=950
FX=690
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\09.jpg")
Repeat
SYP
SYP
g=g+1
GZSFG
SYP
g=g+1
GZSFG
SFGG=SFGG+1
Until SFGG=2
SYP
Goto Aufgabe15
End

.Teil16
ClsVB
FY=950
FX=50
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\10.jpg")
Repeat
SYP
SYP
SYP
g=g+1
GZSFG
SFGG=SFGG+1
Until SFGG=7
SYP
Goto Aufgabe16
End

.Teil17
ClsVB
FY=950
FX=450
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\11.jpg")
Repeat
SYP
SYP
g=g+1
GZSFG
SYP
g=g+1
GZSFG
SFGG=SFGG+1
Until SFGG=2
SYP
SXP
g=g+1
GZSFG
SXP
SXP
SXP
g=g+1
GZSFG
SYP
SYP

Goto Aufgabe17
End

.Teil18
ClsVB
Schrift = LoadFont ("Arial",55,True)
SetFont Schrift
FY=950
FX=730
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\12.jpg")
BildSU=HGrundSF
CLSVB
Repeat
SYP
SYP
g=g+1
GZSFG
SYP
g=g+1
GZSFG
SFGG=SFGG+1
Until SFGG=2
SYP
SYP
Bild = CreateImage (1280,1024)
SetBuffer ImageBuffer (Bild)
CopyRect 0,0,1280,1024,0,0,FrontBuffer(),ImageBuffer(Bild)
SetBuffer FrontBuffer()
Color 0,255,0
Text 640,10,"Laden...",1
VWait
Delay 1000
SetBuffer BackBuffer()
DrawImage Bild,0,0
LockBuffer BackBuffer()
Repeat
rgb=ReadPixelFast(x,y,BackBuffer)
r=(rgb And $FF0000)/$10000
g=(rgb And $FF00)/$100
b=rgb And $FF
r=r/4
g=g/4
b=b/4
Farbe=r*$10000 + g*$100 + b
WritePixelFast x,y,Farbe
x=x+1
If x=1280 Then y=y+1 x=0
If y=1023 And x=1279 Then
UnlockBuffer BackBuffer()
Exit
EndIf
Forever
SetBuffer FrontBuffer()
Flip
Schrift = LoadFont ("Arial",40,True)
SetFont Schrift
Color 0,255,0
Text 640,10,"Du bist nicht mehr weit von deinem Haus entfernt,",1
Text 640,60,"Achtung: Vor deinem Haus wartet schon dein Feind",1
Text 640,110,"auf dich!",1
Text 640,160,"Ich war ihm begegnet,  konnte mich aber zum Glück noch",1
Text 640,210,"ganz knapp in diesem hohlen Baumstamm verstecken!",1
Schrift = LoadFont ("Arial",30,201)
SetFont Schrift
Text 640,970,"Weiter mit beliebiger Taste",1
WaitKey
CLSVB
G=4
SFGG=0
GZSFG
SXM
SXM
SXM
SYP
SYP
SYP
g=g+1
GZSFG
SYP
SYP
g=g+1
GZSFG
SYP
g=g+1
GZSFG
SFGG=SFGG+1
SYP
SYP
Goto Aufgabe18
End

.Teil19
ClsVB
FY=950
FX=350
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\13.jpg")
Repeat
SYP
SYP
SYP
g=g+1
GZSFG
SFGG=SFGG+1
Until SFGG=6
SYP
SYP
Goto Aufgabe19
End

.Teil20
ClsVB
FY=950
FX=570
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\14e.jpg")
SYP
SYP
SYP
g=g+1
GZSFG
SFGG=SFGG+1
SYP
SYP
SYP
Goto LAufgabe
End


.Aufgabe1
ClsVB
ClsColor 253,202,13
Cls
Schrift = LoadFont ("Arial",100,201)
SetFont Schrift
Print "Plusrechnen"
Schrift = LoadFont ("Arial",40,201)
SetFont Schrift
Print ""
Print "Rechne die folgenden Rechnungen aus."
Print "Du musst mindestens 17 von zwanzig Rechnungen richtig lösen,"
Print "damit du weiter zur nächsten Aufgabe kommst."
Print ""
Print "Viel Glück!"
Input()
StartZeit = MilliSecs()
Richtig=0
Falsch=0
Aufgabe=0
ClsVB
HGrund1=LoadImage (".\Bilder\Wald1.jpg")
HGrund2=LoadImage (".\Bilder\Wald2.jpg")
HGrund3=LoadImage (".\Bilder\Wald3.jpg")
HGrund4=LoadImage (".\Bilder\Wald4.jpg")
HGrund5=LoadImage (".\Bilder\Wald5.jpg")
HGrund6=LoadImage (".\Bilder\Wald6.jpg")
HGrund7=LoadImage (".\Bilder\Wald7.jpg")
HGrund8=LoadImage (".\Bilder\Wald8.jpg")
HGrund9=LoadImage (".\Bilder\Wald9.jpg")
HGrund10=LoadImage (".\Bilder\Wald10.jpg")
HGrund11=LoadImage (".\Bilder\Wald11.jpg")
HGrund12=LoadImage (".\Bilder\Wald12.jpg")
HGrund13=LoadImage (".\Bilder\Wald13.jpg")
HGrund14=LoadImage (".\Bilder\Wald14.jpg")
HGrund15=LoadImage (".\Bilder\Wald15.jpg")
HGrund16=LoadImage (".\Bilder\Wald16.jpg")
HGrund17=LoadImage (".\Bilder\Wald17.jpg")
HGrund18=LoadImage (".\Bilder\Wald18.jpg")
HGrund19=LoadImage (".\Bilder\Wald19.jpg")
HGrund20=LoadImage (".\Bilder\Wald20.jpg")

PauseChannel HGM
FlushKeys
Schrift = LoadFont ("Arial",30,True)
SetFont Schrift
Color 255,255,255
Cls
Locate 1,1
SeedRnd MilliSecs()
Falsch=0
Richtig=0
Aufgabe=0
;Hier wird dei Spielfigur für Teil1a oder Teil1S gelagden!
rocket = LoadImage (".\Bilder\"+Name+"bmp")

Repeat
Color 255,255,255


If Schwierigkeitsstufe=1 Then Goto W1
If Schwierigkeitsstufe=2 Then Goto W2
If Schwierigkeitsstufe=3 Then Goto W3
If Schwierigkeitsstufe=4 Then Goto W4


.W1
If Schwierigkeitsstufe=1 Then Zahl1= Rand(0,10) Zahl2= Rand(0,10)
Goto Aufgabe1a
End

.W2
If Schwierigkeitsstufe=2 Then Zahl1= Rand(0,100) Zahl2= Rand(0,100)
Goto Aufgabe1a
End

.W3
If Schwierigkeitsstufe=3 Then Zahl1= Rand(0,1000) Zahl2= Rand(0,1000)
Goto Aufgabe1a
End

.W4
If Schwierigkeitsstufe=4 Then Zahl1= Rand(0,10000) Zahl2= Rand(0,10000)
Goto Aufgabe1a
End



.Aufgabe1a
FlushKeys
FlushMouse
Repeat
Ergebnis=Input(Zahl1 +"+"+Zahl2 + "=" ) 
If Ergebnis=Zahl1+Zahl2 Then Print "Richtig!" Richtig=Richtig+1  RichtigR=1
If Ergebnis<>Zahl1+Zahl2 Then
Print "Falsch!"
Falsch=Falsch+1
EndIf
FlushKeys
Delay 1500
Cls
Locate 1,1
If Richtig =1 Then DrawImage HGrund1, 200,0
If Richtig =2 Then DrawImage HGrund2, 416,0
If Richtig =3 Then DrawImage HGrund3, 632,0
If Richtig =4 Then DrawImage HGrund4, 848,0
If Richtig =5 Then DrawImage HGrund5, 1064,0
If Richtig =6 Then DrawImage HGrund6, 200,256
If Richtig =7 Then DrawImage HGrund7, 416,256
If Richtig =8 Then DrawImage HGrund8, 632,256
If Richtig =9 Then DrawImage HGrund9, 848,256
If Richtig =10 Then DrawImage HGrund10, 1064,256
If Richtig =11 Then DrawImage HGrund11, 200,512
If Richtig =12 Then DrawImage HGrund12, 416,512
If Richtig =13 Then DrawImage HGrund13, 632,512
If Richtig =14 Then DrawImage HGrund14, 848,512
If Richtig =15 Then DrawImage HGrund15, 1064,512
If Richtig =16 Then DrawImage HGrund16, 200,768
If Richtig =17 Then DrawImage HGrund17, 416,768
If Richtig =18 Then DrawImage HGrund18, 632,768
If Richtig =19 Then DrawImage HGrund19, 848,768
If Richtig =1 Then DrawImage HGrund1, 200,0
If Richtig >1 Then DrawImage HGrund1, 200,0
If Richtig >2 Then DrawImage HGrund2, 416,0
If Richtig >3 Then DrawImage HGrund3, 632,0
If Richtig >4 Then DrawImage HGrund4, 848,0
If Richtig >5 Then DrawImage HGrund5, 1064,0
If Richtig >6 Then DrawImage HGrund6, 200,256
If Richtig >7 Then DrawImage HGrund7, 416,256
If Richtig >8 Then DrawImage HGrund8, 632,256
If Richtig >9 Then DrawImage HGrund9, 848,256
If Richtig >10 Then DrawImage HGrund10, 1064,256
If Richtig >11 Then DrawImage HGrund11, 200,512
If Richtig >12 Then DrawImage HGrund12, 416,512
If Richtig >13 Then DrawImage HGrund13, 632,512
If Richtig >14 Then DrawImage HGrund14, 848,512
If Richtig >15 Then DrawImage HGrund15, 1064,512
If Richtig >16 Then DrawImage HGrund16, 200,768
If Richtig >17 Then DrawImage HGrund17, 416,768
If Richtig >18 Then DrawImage HGrund18, 632,768
If Richtig >19 Then DrawImage HGrund19, 848,768
If Richtig =20 Then DrawImage HGrund20, 1064,768 Delay 3000 Goto Aufgabe1b
Until RichtigR=1
RichtigR=0
Aufgabe=Aufgabe+1
Until Aufgabe=20


.Aufgabe1b
Cls
Locate 1,1
FlushKeys
FlushMouse
Print "Du hast "+(20-Falsch)+"/20 Aufgaben richtig gelöst!"
Input()
Protokoll$="Plusrechnen" SpielstandS
Protokoll$="Punkte: "+(20-Falsch)+"/20" SpielstandS
Gosub PZeit
If 20-Falsch<17 Then Print "Du hast zu viele Fehler, versuche die Aufgabe nochmals!" Delay 4000 SpielstandS Goto Aufgabe1
SpielstandS
If UebersichtA=1 Then Goto Uebersicht3
;Spielstandsicherung
Aufgaben=Aufgaben+1
FlushKeys
FlushMouse
Goto Programmstart
End



.Aufgabe2
ClsVB
PauseChannel HGM
ClsColor 253,202,13
Cls
Schrift = LoadFont ("Arial",100,201)
SetFont Schrift
Print "Wörterdiktat"
Schrift = LoadFont ("Arial",40,201)
SetFont Schrift
Print ""
Print "Zuerst wird ein Wort je nach Schwierigkeitsstufe"
Print "0.75 bis 3 Sekunden lang gezeigt, dann wird es gelöscht."
Print "Du musst es dann fehlerfrei schreiben (und Enter drücken)."
Print ""
Print "Viel Glück!"
HGrundH=LoadImage (".\Bilder\Waldsw.jpg")
HGrund1=LoadImage (".\Bilder\Wald1.jpg")
HGrund2=LoadImage (".\Bilder\Wald2.jpg")
HGrund3=LoadImage (".\Bilder\Wald3.jpg")
HGrund4=LoadImage (".\Bilder\Wald4.jpg")
HGrund5=LoadImage (".\Bilder\Wald5.jpg")
HGrund6=LoadImage (".\Bilder\Wald6.jpg")
HGrund7=LoadImage (".\Bilder\Wald7.jpg")
HGrund8=LoadImage (".\Bilder\Wald8.jpg")
HGrund9=LoadImage (".\Bilder\Wald9.jpg")
HGrund10=LoadImage (".\Bilder\Wald10.jpg")
HGrund11=LoadImage (".\Bilder\Wald11.jpg")
HGrund12=LoadImage (".\Bilder\Wald12.jpg")
HGrund13=LoadImage (".\Bilder\Wald13.jpg")
HGrund14=LoadImage (".\Bilder\Wald14.jpg")
HGrund15=LoadImage (".\Bilder\Wald15.jpg")
HGrund16=LoadImage (".\Bilder\Wald16.jpg")
HGrund17=LoadImage (".\Bilder\Wald17.jpg")
HGrund18=LoadImage (".\Bilder\Wald18.jpg")
HGrund19=LoadImage (".\Bilder\Wald19.jpg")
HGrund20=LoadImage (".\Bilder\Wald20.jpg")
Input()
StartZeit = MilliSecs()
Cls
Locate 1,1
Schrift = LoadFont ("Arial",24)
SetFont Schrift
Falsch=0 : Richtig=0 : Aufgabe=0
Restore Woerter2
 ;Einleseschlaufe für 140 Wörter
      Const Maxs = 139
Dim Wort$(Maxs)

ClsColor 0,0,0
Cls
Color 255,255,255

.Woerter2


DrawImage HGrundH, 200,0

Data "ihm", "ihn", "ihr", "ihnen", "riechen", "fernsehen", "bezahlen"
Data "ruhig", "mehr", "mehrere", "wohnen", "während", "stehen", "schief"
Data "sehr", "nehmen", "ehrlich", "fröhlich", "allmählich", "fahren", "tief"
Data "ähnlich", "wahr", "gefährlich", "gehen", "ohne", "wohl", "zuviel"
Data "erzählen", "bleiben", "bleibt", "blieb", "geblieben", "bringen", "bringt"
Data "brachte", "gebracht", "denken", "denkt", "dachte", "gedacht"
Data "erschrecken", "erschrickt", "erschrak", "erschrocken"
Data "essen", "isst", "ass", "gegessen", "fahren", "fährt", "fuhr", "gefahren"
Data "fallen", "fällt", "fiel", "gefallen", "finden", "findet", "fand"
Data "gefunden", "fliegen", "fliegt", "flog", "geflogen", "geben", "gibt"
Data "gefällt", "gefiel", "gehen", "geht", "ging", "gegangen"
Data "geschehen", "geschieht", "geschah", "haben", "hat", "hatte", "gehabt"
Data "halten", "hält", "hielt", "gehalten", "kommen", "kommt", "kam", "gekommen" 
Data "können", "kann", "konnte", "gekonnt", "laden", "lädt", "lud", "geladen"
Data "laufen", "läuft", "lief", "gelaufen", "legen", "legt", "legte", "gelegen"
Data "leiden", "leidet", "litt", "gelitten", "lesen", "liest", "las", "gelesen"
Data "liegen", "liegt", "lag", "gelegen", "messen", "misst", "mass", "gemessen"
Data "nehmen", "nimmt", "nahm", "genommen", "rufen", "ruft", "rief", "gerufen"
Data "schlafen", "schläft", "schlief", "geschlafen", "schreiben", "schreibt"
Data "schrieb", "geschrieben", "sehen" ,"hören" , "bemalen" , "arbeiten"

For i = 0 To Maxs
  ;
Read Wort$(i)
Next

Repeat
; Zufallsschlaufe 
    SeedRnd MilliSecs() 
    Zufall$ = Wort$(Rand(0,Maxs))




Repeat
Print Zufall

If Schwierigkeitsstufe=1 Then Delay 3000
If Schwierigkeitsstufe=2 Then Delay 750 Delay 750 Delay 750
If Schwierigkeitsstufe=3 Then Delay 750 Delay 750
If Schwierigkeitsstufe=4 Then Delay 750

Color 0,0,0
Rect 0,0,200,1024
Color 255,255,255
Locate 1,1
Ratwort$ = Input()

If Ratwort$ = Zufall$ Then
  Print "Richtig!" Worteraten = Worteraten +1
  WortRichtig=1
Else
  Print "War wohl nix"
EndIf
;Cls
Locate 1,1
DrawImage HGrundH, 200,0
If Worteraten =1 Then DrawImage HGrund1, 200,0
If Worteraten =2 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0
If Worteraten =3 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0
If Worteraten =4 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0 DrawImage HGrund4, 848,0
If Worteraten =5 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0 DrawImage HGrund4, 848,0 DrawImage HGrund5, 1064,0
If Worteraten =6 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0 DrawImage HGrund4, 848,0 DrawImage HGrund5, 1064,0 DrawImage HGrund6, 200,256
If Worteraten =7 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0 DrawImage HGrund4, 848,0 DrawImage HGrund5, 1064,0 DrawImage HGrund6, 200,256 DrawImage HGrund7, 416,256
If Worteraten =8 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0 DrawImage HGrund4, 848,0 DrawImage HGrund5, 1064,0 DrawImage HGrund6, 200,256 DrawImage HGrund7, 416,256 DrawImage HGrund8, 632,256
If Worteraten =9 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0 DrawImage HGrund4, 848,0 DrawImage HGrund5, 1064,0 DrawImage HGrund6, 200,256 DrawImage HGrund7, 416,256 DrawImage HGrund8, 632,256 DrawImage HGrund9, 848,256
If Worteraten =10 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0 DrawImage HGrund4, 848,0 DrawImage HGrund5, 1064,0 DrawImage HGrund6, 200,256 DrawImage HGrund7, 416,256 DrawImage HGrund8, 632,256 DrawImage HGrund9, 848,256 DrawImage HGrund10, 1064,256
If Worteraten =11 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0 DrawImage HGrund4, 848,0 DrawImage HGrund5, 1064,0 DrawImage HGrund6, 200,256 DrawImage HGrund7, 416,256 DrawImage HGrund8, 632,256 DrawImage HGrund9, 848,256 DrawImage HGrund10, 1064,256 DrawImage HGrund11, 200,512
If Worteraten =12 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0 DrawImage HGrund4, 848,0 DrawImage HGrund5, 1064,0 DrawImage HGrund6, 200,256 DrawImage HGrund7, 416,256 DrawImage HGrund8, 632,256 DrawImage HGrund9, 848,256 DrawImage HGrund10, 1064,256 DrawImage HGrund11, 200,512 DrawImage HGrund12, 416,512
If Worteraten =13 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0 DrawImage HGrund4, 848,0 DrawImage HGrund5, 1064,0 DrawImage HGrund6, 200,256 DrawImage HGrund7, 416,256 DrawImage HGrund8, 632,256 DrawImage HGrund9, 848,256 DrawImage HGrund10, 1064,256 DrawImage HGrund11, 200,512 DrawImage HGrund12, 416,512 DrawImage HGrund13, 632,512
If Worteraten =14 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0 DrawImage HGrund4, 848,0 DrawImage HGrund5, 1064,0 DrawImage HGrund6, 200,256 DrawImage HGrund7, 416,256 DrawImage HGrund8, 632,256 DrawImage HGrund9, 848,256 DrawImage HGrund10, 1064,256 DrawImage HGrund11, 200,512 DrawImage HGrund12, 416,512 DrawImage HGrund13, 632,512 DrawImage HGrund14, 848,512
If Worteraten =15 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0 DrawImage HGrund4, 848,0 DrawImage HGrund5, 1064,0 DrawImage HGrund6, 200,256 DrawImage HGrund7, 416,256 DrawImage HGrund8, 632,256 DrawImage HGrund9, 848,256 DrawImage HGrund10, 1064,256 DrawImage HGrund11, 200,512 DrawImage HGrund12, 416,512 DrawImage HGrund13, 632,512 DrawImage HGrund14, 848,512 DrawImage HGrund15, 1064,512
If Worteraten =16 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0 DrawImage HGrund4, 848,0 DrawImage HGrund5, 1064,0 DrawImage HGrund6, 200,256 DrawImage HGrund7, 416,256 DrawImage HGrund8, 632,256 DrawImage HGrund9, 848,256 DrawImage HGrund10, 1064,256 DrawImage HGrund11, 200,512 DrawImage HGrund12, 416,512 DrawImage HGrund13, 632,512 DrawImage HGrund14, 848,512 DrawImage HGrund15, 1064,512 DrawImage HGrund16, 200,768
If Worteraten =17 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0 DrawImage HGrund4, 848,0 DrawImage HGrund5, 1064,0 DrawImage HGrund6, 200,256 DrawImage HGrund7, 416,256 DrawImage HGrund8, 632,256 DrawImage HGrund9, 848,256 DrawImage HGrund10, 1064,256 DrawImage HGrund11, 200,512 DrawImage HGrund12, 416,512 DrawImage HGrund13, 632,512 DrawImage HGrund14, 848,512 DrawImage HGrund15, 1064,512 DrawImage HGrund16, 200,768 DrawImage HGrund17, 416,768
If Worteraten =18 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0 DrawImage HGrund4, 848,0 DrawImage HGrund5, 1064,0 DrawImage HGrund6, 200,256 DrawImage HGrund7, 416,256 DrawImage HGrund8, 632,256 DrawImage HGrund9, 848,256 DrawImage HGrund10, 1064,256 DrawImage HGrund11, 200,512 DrawImage HGrund12, 416,512 DrawImage HGrund13, 632,512 DrawImage HGrund14, 848,512 DrawImage HGrund15, 1064,512 DrawImage HGrund16, 200,768 DrawImage HGrund17, 416,768 DrawImage HGrund18, 632,768
If Worteraten =19 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0 DrawImage HGrund4, 848,0 DrawImage HGrund5, 1064,0 DrawImage HGrund6, 200,256 DrawImage HGrund7, 416,256 DrawImage HGrund8, 632,256 DrawImage HGrund9, 848,256 DrawImage HGrund10, 1064,256 DrawImage HGrund11, 200,512 DrawImage HGrund12, 416,512 DrawImage HGrund13, 632,512 DrawImage HGrund14, 848,512 DrawImage HGrund15, 1064,512 DrawImage HGrund16, 200,768 DrawImage HGrund17, 416,768 DrawImage HGrund18, 632,768 DrawImage HGrund19, 848,768
If Worteraten =20 Then DrawImage HGrund1, 200,0 DrawImage HGrund2, 416,0 DrawImage HGrund3, 632,0 DrawImage HGrund4, 848,0 DrawImage HGrund5, 1064,0 DrawImage HGrund6, 200,256 DrawImage HGrund7, 416,256 DrawImage HGrund8, 632,256 DrawImage HGrund9, 848,256 DrawImage HGrund10, 1064,256 DrawImage HGrund11, 200,512 DrawImage HGrund12, 416,512 DrawImage HGrund13, 632,512 DrawImage HGrund14, 848,512 DrawImage HGrund15, 1064,512 DrawImage HGrund16, 200,768 DrawImage HGrund17, 416,768 DrawImage HGrund18, 632,768 DrawImage HGrund19, 848,768 DrawImage HGrund20, 1064,768
Delay 1000
Color 0,0,0
Rect 0,0,200,1024
Color 255,255,255
If WortRichtig=0 Then WDRVP=WDRVP+1
Until WortRichtig=1
WortRichtig=0
FlushKeys
FlushMouse
Until Worteraten = 20
;Spielstandsicherung
FlushKeys
FlushMouse
Protokoll$="Wörterdiktat" SpielstandS
Protokoll$="Punkte: "+(20-WDRVP)+"/20" SpielstandS
Gosub PZeit
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=Aufgaben+1
Smeili=2
FlushKeys
FlushMouse
Goto Programmstart
End






.Aufgabe3
Goto Zinn
End


.Zinn
ClsVB
PauseChannel HGM
FlushKeys
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 60,True)
SetFont Schrift
Text 9,1,"Der Standhafte Zinnsoldat"
Locate 1,70
Schrift = LoadFont ("Arial", 23,True)
SetFont Schrift
Textverstentnis=0
Print "  Es waren einmal fünfundzwanzig Zinnsoldaten, die waren alle Brüder, denn sie waren aus"
Print "  einem alten zinnernen Löffel gemacht worden. Das Gewehr hielten sie"
Print "  im Arm und das Gesicht geradeaus; rot und blau, überaus herrlich war die Uniform; das"
Print "  allererste, was sie in dieser Welt hörten, als der Deckel von der"
Print "  Schachtel genommen wurde, in der sie lagen, war das Wort Zinnsoldaten. Das rief ein"
Print "  kleiner Knabe und klatschte in die Hände; er hatte sie erhalten, denn es" 
Print "  war sein Geburtstag, und er stellte sie nun auf dem Tische auf. Der eine Soldat"
Print "  glich dem andern leibhaft, nur ein einziger war etwas anders; er hatte nur ein Bein,"
Print "  denn er war zuletzt gegossen worden, und da war nicht mehr Zinn genug da; doch stand"
Print "  er ebenso fest auf seinem einen Bein wie die andern auf ihren zweien, und"
Print "  gerade er war es, der sich bemerkbar machte. "
Print
Print
Print
Print "  Seite 1 von 7"
WaitKey ()
Cls
Locate 1,1
DrawImage HGrundH, 0,0
Print "  Auf dem Tisch, auf dem sie aufgestellt wurden, stand vieles andere Spielzeug; aber"
Print "  das, was am meisten in die Augen fiel, war ein niedliches Schloss von Papier;"
Print "  durch die kleinen Fenster konnte man gerade in die Säle hineinsehen. Draußen vor ihm"
Print "  standen kleine Bäume rings um einen kleinen Spiegel, der wie ein kleiner"
Print "  See aussehen sollte. Schwäne von Wachs schwammen darauf und spiegelten sich. Das war"
Print "  alles niedlich, aber das niedlichste war doch ein kleines Mädchen, das"
Print "  mitten in der offenen Schlosstür stand; sie war auch aus Papier ausgeschnitten, aber"
Print "  sie hatte ein schönes Kleid und ein kleines, schmales, blaues Band über den"
Print "  Schultern, gerade wie ein Schärpe; mitten in diesem saß ein glänzender Stern, gerade"
Print "  so groß wir ihr Gesicht."
Print "  Das kleine Mädchen streckte seine beiden Arme aus, denn es war eine Tänzerin, und dann"
Print "  hob es das eine Bein so hoch empor, dass der Zinnsoldat es durchaus"
Print "  nicht finden konnte und glaubte, dass es gerade wie er nur ein Bein habe." 
Print " ,Das wäre eine Frau für mich', dachte er, aber sie ist etwas vornehm, sie wohnt in"
Print "  einem Schlosse, ich habe nur eine Schachtel, und da sind wir fünfundzwanzig"
Print "  darin, das ist kein Ort für sie, doch ich muss suchen, Bekanntschaft mit ihr anzuknüpfen!'"
Print
Print
Print
Print "  Seite 2 von 7"
WaitKey ()
Locate 1,1
Cls
DrawImage HGrundH, 0,0
Print "  Und dann legte er sich, so lang er war, hinter eine Schnupftabaksdose,"
Print "  die auf dem Tische stand. Da konnte er recht die kleine, feine Dame betrachten, die fortfuhr"
Print "  auf einem Bein zu stehen, ohne umzufallen." 
Print "  Als es Abend wurde, kamen alle die andern Zinnsoldaten in ihre Schachtel, und die Leute im"
Print "  Hause gingen zu Bette. Nun fing das Spielzeug an zu spielen,"
Print "  sowohl ,Es kommt Besuch!' als auch ,Krieg führen' und ,Ball geben'; die Zinnsoldaten"
Print "  rasselten in der Schachtel, denn sie wollten mit dabei sein, aber sie"
Print "  konnten den Deckel nicht aufheben. Der Nussknacker schoss Purzelbäume, und der Griffel"
Print "  belustigte sich auf der Tafel; es war ein Lärm, dass der Kanarienvogel"
Print "  davon erwachte und anfing mitzusprechen, und zwar in Versen. Die beiden einzigen, die"
Print "  sich nicht von der Stelle bewegten, waren der Zinnsoldat und die Tänzerin;"
Print "  sie hielt sich gerade auf der Zehenspitze und beide Arme ausgestreckt; er war ebenso"
Print "  standhaft auf seinem einen Bein; seine Augen wandte er keinen Augenblick"
Print "  von ihr weg."
Print "  Nun schlug die Uhr zwölf, und klatsch, da sprang der Deckel von der Schnupftabaksdose"
Print "  auf, aber da war kein Tabak darin, nein, sondern ein kleiner, schwarzer"
Print "  Kobold." 
Print "  Das war ein Kunststück!" 
Print "  Zinnsoldat sagte der Kobold, halte deine Augen im Zaum! Aber der Zinnsoldat"
Print
Print
Print
Print "  Seite 3 von 7"
WaitKey ()
Locate 1,1
Cls
DrawImage HGrundH, 0,0
Print "  tat, als ob er es nicht hörte." 
Print "  Ja, warte nur bis morgen! sagte der Kobold." 
Print "  Als es nun Morgen wurde und die Kinder aufstanden, wurde der Zinnsoldat in das"
Print "  Fenster gestellt, und war es nun der Kobold oder der Zugwind, auf einmal flog"
Print "  das Fenster zu, und der Soldat stürzte drei Stockwerke tief hinunter." 
Print "  Das war eine erschreckliche Fahrt. Er streckte das Bein gerade in die Höhe und"
Print "  blieb auf der Helmspitze mit dem Bajonett abwärts zwischen den Pflastersteinen"
Print "  stecken."
Print "  Das Dienstmädchen und der kleine Knabe kamen sogleich hinunter, um zu suchen; aber"
Print "  obgleich sie nahe daran waren, auf ihn zu treten, so konnten sie ihn doch"
Print "  nicht erblicken. Hätte der Zinnsoldat gerufen: Hier Bin ich!, so hätten sie ihn wohl"
Print "  gefunden, aber er fand es nicht passend, laut zu schreien, weil er in Uniform"
Print "  war." 
Print "  Nun fing es an zu regnen; die Tropfen fielen immer dichter, es ward ein ordentlicher"
Print "  Platzregen; als der zu Ende war, kamen zwei Straßenjungen vorbei."
Print "  Sieh du! sagte der eine, da liegt ein Zinnsoldat! Der soll hinaus und segeln!" 
Print "  Sie machten ein Boot aus einer Zeitung, setzten den Soldaten mitten hinein, und nun"
Print "  segelte er den Rinnstein hinunter; beide Knaben liefen nebenher und"
Print "  klatschten in die Hände. Was schlugen da für Wellen in dem Rinnstein, und welcher Strom"
Print
Print
Print
Print "  Seite 4 von 7"
WaitKey ()
Locate 1,1
Cls
DrawImage HGrundH, 0,0
Print "  war da! Ja, der Regen hatte aber auch geströmt. Das Papierboot"
Print "  schaukelte auf und nieder, mitunter drehte es sich so geschwind, dass der"
Print "  Zinnsoldat bebte; aber er blieb standhaft, verzog keine Miene, sah geradeaus und hielt"
Print "  das Gewehr im Arm." 
Print "  Mit einem Male trieb das Boot unter eine lange Rinnsteinbrücke; da wurde es"
Print "  gerade so dunkel, als wäre er in seiner Schachtel." 
Print "  ,Wohin mag ich nun kommen?' dachte er. Ja, Ja, das ist des Kobolds Schuld! Ach, säße"
Print "  doch das kleine Mädchen hier im Boote, da könnte es meinetwegen noch"
Print "  einmal so dunkel sein!' "
Print "  Da kam plötzlich eine große Wasserratte, die unter der Rinnsteinbrücke wohnte. "
Print "  Hast du einen Pass? fragte die Ratte. Her mit dem Passe!" 
Print "  Aber der Zinnsoldat schwieg still und hielt das Gewehr noch fester."
Print "  Das Boot fuhr davon und die Ratte hinterher. Hu, wie fletschte sie die Zähne und"
Print "  rief den Holzspänen und dem Stroh zu: Halt auf! Halt auf! Er hat keinen Zoll"
Print "  bezahlt; er hat den Pass nicht gezeigt!" 
Print "  Aber die Strömung wurde stärker und stärker! Der Zinnsoldat konnte schon da, wo"
Print "  das Brett aufhörte, den hellen Tag erblicken, aber er hörte auch einen"
Print "  brausenden Ton, der wohl einen tapfern Mann erschrecken konnte." 
Print "  Denkt nur, der Rinnstein stürzte, wo die Brücke endete, geradehinaus in einen"
Print "  großen Kanal; das würde für den armen Zinnsoldaten ebenso gefährlich gewesen"
Print "  Nun war er schon so nahe dabei, dass er nicht mehr anhalten konnte. Das Boot fuhr"
Print
Print
Print
Print "  Seite 5 von 7"
WaitKey ()
Locate 1,1
Cls
DrawImage HGrundH, 0,0
Print "  hinaus, der Zinnsoldat hielt sich so steif, wie er konnte; niemand sollte ihm"
Print "  nachsagen, dass er mit den Augen blinke. Das Boot schnurrte drei-, viermal herum und"
Print "  war bis zum Rande mit Wasser gefüllt, es musste sinken. Der Zinnsoldat"
Print "  stand bis zum Halse im Wasser, und tiefer und tiefer sank das Boot, mehr und mehr löste"
Print "  das Papier sich auf; nun ging das Wasser über des Soldaten Kopf. Da"
Print "  dachte er an die kleine, niedliche Tänzerin, die er nie mehr zu Gesicht bekommen"
Print "  sollte, und es klang vor des Zinnsoldaten Ohren das Lied:" 
Print "  ,Fahre, fahre Kriegsmann!"
Print "  Den Tod musst du erleiden!'"
Print "  Nun ging das Papier entzwei, und der Zinnsoldat stürzte hindurch, wurde aber"
Print "  augenblicklich von einem großen Fisch verschlungen." 
Print "  Wie war es dunkel da drinnen!"
Print "  Da war es noch schlimmer als unter der Rinnsteinbrücke, und dann war es so sehr"
Print "  eng; aber der Zinnsoldat war standhaft und lag, so lang er war, mit dem"
Print "  Gewehr im Arm."
Print "  Der Fisch fuhr umher, er machte die allerschrecklichsten Bewegungen; endlich"
Print "  wurde er ganz still, es fuhr wie ein Blitzstrahl durch ihn hin. Das Licht schien ganz"
Print "  klar, und jemand rief laut: Der Zinnsoldat! Der Fisch war gefangen worden, auf den"
Print "  Markt gebracht, verkauft und in die Küche hinaufgekommen, wo die"
Print "  Köchin ihn mit einem großen Messer aufschnitt. Sie nahm mit zwei Fingern den Soldaten"
Print
Print
Print
Print "  Seite 6 von 7"
WaitKey ()
Locate 1,1
Cls
DrawImage HGrundH, 0,0
Print "  mitten um den Leib und trug ihn in die Stube hinein, wo alle den"
Print "  merkwürdigen Mann sehen wollten, der im Magen eines Fisches herumgereist war; aber der"
Print "  Zinnsoldat war gar nicht stolz. Sie stellten ihn auf den Tisch und"
Print "  da - wie sonderbar kann es doch in der Welt zugehen! Der Zinnsoldat war in derselben"
Print "  Stube, in der er früher gewesen war, er sah dieselben Kinder, und das"
Print "  gleiche Spielzeug stand auf dem Tische, das herrliche Schloss mit der"
Print "  niedlichen, kleinen Tänzerin. Die hielt sich noch auf dem einen Bein und hatte das andere"
Print "  hoch in der Luft, sie war auch standhaft. Das rührte den Zinnsoldaten, er war nahe"
Print "  daran, Zinn zu weinen, aber es schickte sich nicht. Er sah sie an, aber sie"
Print "  sagten gar nichts." 
Print "  da nahm der eine der kleinen Knaben den Soldaten und warf ihn gerade in den Ofen,"
Print "  obwohl er gar keinen Grund dafür hatte; es war sicher der Kobold in der"
Print "  Dose, der schuld daran war." 
Print "  Der Zinnsoldat stand ganz beleuchtet da und fühlte eine Hitze, die erschrecklich"
Print "  war; aber ob sie von dem wirklichen Feuer oder von der Liebe herrührte, das"
Print "  wusste er nicht. Die Farben waren ganz von ihm abgegangen - ob das auf der Reise"
Print "  geschehen oder ob der Kummer daran schuld war, konnte niemand sagen."
Print "  Er sah das kleine Mädchen an, sie blickte ihn an, und er fühlte, dass er schmelze,"
Print "  aber noch stand er standhaft mit dem Gewehre im Arm. Da ging eine Tür auf,"
Print "  der Wind ergriff die Tänzerin, und sie flog, einer Sylphide gleich, gerade in den"
Print "  Ofen zum Zinnsoldaten, loderte in Flammen auf und war verschwunden."
Print "  Da schmolz der Zinnsoldat zu einem Klumpen, und als das Mädchen am folgenden Tage"
Print "  die Asche herausnahm, fand sie ihn als ein kleines Zinnherz; von der"
Print "  Tänzerin hingegen war nur der Stern noch da, und der war kohlschwarz gebrannt." 
Print
Print
Print
Print "  Seite 7 von 7"
WaitKey ()
Locate 1,1
Cls
DrawImage HGrundH, 0,0
Print "In wen war der Zinnsoldat mit nur einem Bein verliebt?"
Zinnsoldat1$ = Input()
If Zinnsoldat1$ = "In die Tänzerin"Then Print "Richtig 2P" Textverstentnis=2 Goto ZinnB
If Zinnsoldat1$ = "In die Tenzerin"Then Print "Richtig aber die Rechtschreibung nicht! 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto ZinnB
If Zinnsoldat1$ = "Täntzerin"Then Print "Richtig aber die Rechtschreibung nicht! 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto ZinnB
If Zinnsoldat1$ = "In die Täntzerin"Then Print "Richtig aber die Rechtschreibung nicht! 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto ZinnB
If Zinnsoldat1$ = "Tenzerin"Then Print "Richtig aber die Rechtschreibung nicht! 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto ZinnB
If Zinnsoldat1$ = "Tänzerin"Then Print "Richtig 2P" Delay 3000 Textverstentnis =2 Goto ZinnB
If Zinnsoldat1$ = "In die Ballerina"Then Print "Richtig 2P" Delay 3000 Textverstentnis =2 Goto ZinnB
If Zinnsoldat1$ = "Ballerina"Then Print "Richtig 2P" Delay 3000 Textverstentnis =2 Goto ZinnB
Print "Falsch!"
Delay 3000
Goto ZinnB 
End
.ZinnB
Locate 1,1
Cls
DrawImage HGrundH, 0,0
Print "Wie viele Zinnsoldaten hatte der Junge in seinem Zinner?"
Zinnsoldat2$ = Input()
If Zinnsoldat2$ = "50" Then Print "Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto ZinnC
If Zinnsoldat2$ = "Fünfzig" Then Print "Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto ZinnC
If Zinnsoldat2$ = "fünfzig" Then Print "Richtig 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto ZinnC
Print "Falsch"
Goto ZinnC
End
.ZinnC
Locate 1,1
Cls
DrawImage HGrundH, 0,0
Print "Was dachte der Zinnsoldaten als das Boot unterging?"
Zinnsoldat3$ = Input()
If Zinnsoldat3$ = "Er dachte, dass er die Täntzerin nie wieder sehen würde" Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto Zinnvergleich1
If Zinnsoldat3$ = "Er dachte an die Tänzerin" Then Print " Fast Richtig aber die Rechtschreibung nicht 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto Zinnvergleich1
If Zinnsoldat3$ = "Er dachte dass er die Tentzerin nie wieder sehen würde" Then Print"Richtig aber die Rechtschreibung nicht 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto Zinnvergleich1
If Zinnsoldat3$ = "dass er die Täntzerin nie wieder sehen würde" Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto Zinnvergleich1
If Zinnsoldat3$ = "An die Tänzerin"Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto Zinnvergleich1
If Zinnsoldat3$ = "Tänzerin"Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto Zinnvergleich1
Print "Falsch!"
Goto Zinnvergleich1 
End
.Zinnvergleich1
Locate 1,1
Cls
DrawImage HGrundH, 0,0
If Textverstentnis = 0 Then Print "Lese bitte die Geschichte bitte später noch einmal etwas genauer!" Delay 3000 Protokoll$="Textverständnis (Der Standhafte Zinnsoldat)" SpielstandS If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
If Textverstentnis = 1 Then Print "Lese bitte die Geschichte bitte später noch einmal etwas genauer!" Delay 3000 Protokoll$="Textverständnis (Der Standhafte Zinnsoldat)" SpielstandS If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
If Textverstentnis = 2 Then Goto ZinnD
If Textverstentnis = 3 Then Goto ZinnD
If Textverstentnis = 4 Then Goto ZinnD
If Textverstentnis = 5 Then Goto ZinnD
If Textverstentnis = 6 Then Protokoll$="Textverständnis (Der Standhafte Zinnsoldat)" Print "Du hast die Geschichte sehr gut gelesen!" Delay 3000 Protokoll$="Textverständnis (Der Standhafte Zinnsoldat)" SpielstandS Goto PunkteZinn
End
.ZinnD
Locate 1,1
Cls
DrawImage HGrundH, 0,0
Print "Wie viele Beine hat der Zinnsoldaten der sehr oft in der Geschichte vorkommt?"
Zinnsoldat4$ = Input()
If Zinnsoldat4$ = "1" Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto Zinnvergleich2
If Zinnsoldat4$ = "eins" Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto Zinnvergleich2
If Zinnsoldat4$ = "Eins" Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto Zinnvergleich2
If Zinnsoldat4$ = "Er hatte ein Bein" Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto Zinnvergleich2
Print "Falsch!"
Goto Zinnvergleich2 
End
.Zinnvergleich2
Locate 1,1
Cls
DrawImage HGrundH, 0,0
If Textverstentnis = 2 Then Print "Lese bitte die Geschichte bitte später noch einmal etwas genauer!" Delay 3000 Protokoll$="Textverständnis (Der Standhafte Zinnsoldat)" SpielstandS If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
If Textverstentnis = 3 Then Print "Lese bitte die Geschichte bitte später noch einmal etwas genauer!" Delay 3000 Protokoll$="Textverständnis (Der Standhafte Zinnsoldat)" SpielstandS If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
If Textverstentnis = 4 Then Goto ZinnE
If Textverstentnis = 5 Then Goto ZinnE
If Textverstentnis = 6 Then Print "Du hast die Geschichte gut gelesen!" Delay 3000 Protokoll$="Textverständnis (Der Standhafte Zinnsoldat)" SpielstandS Goto PunkteZinn
If Textverstentnis = 7 Then Print "Du hast die Geschichte sehr gut gelesen!" Delay 3000 Protokoll$="Textverständnis (Der Standhafte Zinnsoldat)" SpielstandS Goto PunkteZinn
End
.ZinnE
Locate 1,1
Cls
DrawImage HGrundH, 0,0
Print "Wie heisst der Titel dieser Geschichte?
Zinnsoldat5$ = Input()
If Zinnsoldat5$ = "Der Standhafte Zinnsoldat"Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto Zinnvergleich3
If Zinnsoldat5$ = "Der standhafte Zinnsoldat"Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto Zinnvergleich3
If Zinnsoldat5$ = "der Standhafte Zinnsoldat"Then Print"Richtig 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto Zinnvergleich3
If Zinnsoldat5$ = "der standhafte Zinnsoldat"Then Print"Richtig 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto Zinnvergleich3
Print "Falsch"
Goto Zinnvergleich3
End
.Zinnvergleich3
Locate 1,1
Cls
DrawImage HGrundH, 0,0
If Textverstentnis = 4 Then Print "Lese bitte die Geschichte bitte später noch einmal etwas genauer!" Delay 3000 Protokoll$="Textverständnis (Der Standhafte Zinnsoldat)" SpielstandS If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
If Textverstentnis = 5 Then Print "Lese bitte die Geschichte bitte später noch einmal etwas genauer!" Delay 3000 Protokoll$="Textverständnis (Der Standhafte Zinnsoldat)" SpielstandS If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
If Textverstentnis = 6 Then Print "Du hast die Geschichte gut gelesen!" Delay 3000 Protokoll$="Textverständnis (Der Standhafte Zinnsoldat)" SpielstandS Goto PunkteZinn
If Textverstentnis = 7 Then Print "Du hast die Geschichte sehr gut gelesen!" Delay 3000 Protokoll$="Textverständnis (Der Standhafte Zinnsoldat)" SpielstandS Goto PunkteZinn
Goto Programmstart
End

.PunkteZinn
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=Aufgaben+1
Smeili=1
Goto Programmstart
End


.Aufgabe4
ClsVB
PauseChannel HGM
StartZeit = MilliSecs()
FlushKeys
Nomen = 0   Nomen1 = 0    Nomen2 = 0 
HGrundH=LoadImage (".\Bilder\SElba.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,0,0

Print"Erkenne das Nomen in dem folgenden Satz."
Print"Schreibe das Nomen und drücke Enter"
Print
Print "Dies ist ein einfacher Satz."
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "Satz" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!" 
  Nomen = Nomen +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "Satz"

Print "Welcher Artikel hat das Nomen?"
Print"Schreibe der, die oder das und drücke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "der" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
Nomen1 = Nomen1 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "der"

Print
Print "Schreibe die Mehrzahl von (Satz) und drücke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "Sätze" Or Ratwort1$ = "Saetze" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
Nomen2 = Nomen2 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "Sätze" Or Ratwort1$ = "Saetze"
Print

;Brief
Cls 
Locate 1,1
HGrundH=LoadImage (".\Bilder\SElba.jpg")
DrawImage HGrundH, 0,0
Nomen = 0   Nomen1 = 0    Nomen2 = 0   
Print"Erkenne das Nomen in dem folgenden Satz."
Print"Schreibe das Nomen und drücke Enter"
Print
Print "Ich schreibe dir einen Brief."
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "Brief" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"Nomen = Nomen +1 
PlayMusic (".\Sounds\Door1.mp3")
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "Brief"

Print
Print "Welcher Artikel hat das Nomen?"
Print"Schreibe der, die oder das und drücke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "der" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"Nomen1 = Nomen1 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "der"

Print
Print "Schreibe die Mehrzahl von (Brief) und drücke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "Briefe" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"Nomen2 = Nomen2 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "Briefe"
Print

;Tagebuch
Cls 
Locate 1,1
HGrundH=LoadImage (".\Bilder\SElba.jpg")
DrawImage HGrundH, 0,0
Nomen = 0   Nomen1 = 0    Nomen2 = 0 
Print"Erkenne das Nomen in dem folgenden Satz."
Print"Schreibe das Nomen und drücke Enter"
Print
Print "Hast du heute schon ins Tagebuch geschrieben?"

Repeat
Ratwort1$ = Input()
If Ratwort1$ = "Tagebuch" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"Nomen = Nomen +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "Tagebuch"

Print
Print "Welcher Artikel hat das Nomen?"
Print"Schreibe der, die oder das und drücke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "das" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"Nomen1 = Nomen1 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "das"

Print
Print "Schreibe die Mehrzahl von (Tagebuch) und drücke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "Tagebücher" Or Ratwort1$ = "Tagebuecher" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"Nomen2 = Nomen2 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "Tagebücher" Or Ratwort1$ = "Tagebuecher"
Print

;Dorf
Cls 
Locate 1,1
HGrundH=LoadImage (".\Bilder\SElba.jpg")
DrawImage HGrundH, 0,0
Nomen = 0   Nomen1 = 0    Nomen2 = 0 
Print"Erkenne das Nomen in dem folgenden Satz."
Print"Schreibe das Nomen und drücke Enter"
Print
Print "Ich wohne im Dorf."

Repeat
Ratwort1$ = Input()
If Ratwort1$ = "Dorf" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"Nomen = Nomen +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "Dorf"

Print
Print "Welcher Artikel hat das Nomen?"
Print"Schreibe der, die oder das und drücke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "das" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"Nomen1 = Nomen1 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "das"

Print
Print "Schreibe die Mehrzahl von (Dorf) und drücke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "Dörfer" Or Ratwort1$ = "Doerfer" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"Nomen2 = Nomen2 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "Dörfer" Or Ratwort1$ = "Doerfer"
Print
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=Aufgaben+1
Protokoll$="Nomen"
Gosub PZeit
Goto Programmstart
End






.Aufgabe5
ClsVB
Global Looo
.maze_endofintro

; the main structure for a maze, use 'maze_create' to create one of these
Type maze
	Field width,height
	Field buffer
	Field crossing
End Type

; internal representation of a maze cell, don't use in your code
Type maze_loc
	Field x,y
End Type

; internal control structure, don't use in your code
Type maze_control
	Field imgname$
	Field imgwidth, imgheight
	Field img
	Field count
End Type

Function maze_getcell(m.maze,x,y)
	Return PeekByte(m\buffer,y*m\width+x)
End Function

Function maze_setcell(m.maze,x,y,value)
	PokeByte m\buffer,y*m\width+x,value
End Function

Function maze_GetDir(m.maze,x,y,dir)
	Return (maze_getcell(m,x,y) And (2^dir))
End Function

Function maze_SetDir(m.maze,x,y,dir,value)
	c = maze_getcell(m,x,y) And (255-(2^dir))
	If value = 1 Then
		c = c Or (2^dir)
	End If
	maze_setcell(m,x,y,c)
End Function

Function maze_DirOpen(m.maze,x,y,dir)
	Return (maze_getDir(m,x,y,dir) = (2^dir))
End Function

Function maze_NorthOpen(m.maze,x,y)
	Return maze_diropen(m,x,y,0)
End Function

Function maze_EastOpen(m.maze,x,y)
	Return maze_diropen(m,x,y,1)
End Function

Function maze_SouthOpen(m.maze,x,y)
	Return maze_diropen(m,x,y,2)
End Function

Function maze_WestOpen(m.maze,x,y)
	Return maze_diropen(m,x,y,3)
End Function

; display the maze on screen
Function maze_display(m.maze,route)

	l.maze_loc = New maze_loc
	For x = 0 To m\width - 1
		For y = 0 To m\height - 1
			l\x = x
			l\y = y
			maze_drawcell(m,l)
			If route Then
				If (maze_getcell(m,x,y) And 240) > 0 Then
					maze_drawincell(x,y,0,255,0)
				End If
			End If
		Next
	Next
	Delete l

End Function

; draw a single maze cell
Function maze_drawcell(m.maze,l.maze_loc)
	
	mc.maze_control = First maze_control 
	If mc <> Null Then
	
		x=l\x*mc\imgwidth
		y=l\y*mc\imgheight
	
		p = maze_getcell(m,l\x,l\y) Mod 16
	
		DrawImage mc\img,x,y,p
	End If
	
End Function

Function maze_drawIncell(px,py,r,g,b)
	
	mc.maze_control = First maze_control 
	If mc <> Null Then
	
		x=px*mc\imgwidth
		y=py*mc\imgheight
		
		Color r,g,b
		Rect x+2,y+2,mc\imgwidth-4,mc\imgheight-4,1
	End If
	
End Function



Function maze_Create.maze(width,height,seed,crossovers)
	m.maze = New maze
	
	m\width = width
	m\height = height
	m\crossing = (crossovers > 0)
	
	m\buffer = CreateBank(width * height)	
	mc.maze_control = First maze_control
	If mc <> Null Then
		mc\count = mc\count + 1
	End If
	
	maze_generate(m,crossovers,seed)
	
	Return m
End Function

; delete an individual maze
Function maze_Delete(m.maze)

	mc.maze_control = First maze_control
	If mc <> Null Then
		mc\count = mc\count + 1
	End If

	FreeBank m\buffer
	Delete m  
End Function

; initialisation routine
; call at the start of the program, but after the graphics command
Function maze_startup(filename$,imgwidth,imgheight)
	mc.maze_control = New maze_control
	mc\imgwidth = imgwidth
	mc\imgheight = imgheight
	mc\imgname$ = filename$
;	mc\img = LoadAnimImage(filename$,32,32,0,16)
	mc\img = LoadAnimImage(".\Bilder\mazeblocks.png",32,32,0,16)
	ResizeImage mc\img,imgwidth,imgheight

End Function

; cleanup routine, call at the end of the program to clear
; up any mazes left hanging round
Function maze_shutdown()
	For m.maze = Each maze
		maze_delete(m)
	Next
	
	mc.maze_control = First maze_control
	If mc <> Null Then
		FreeImage mc\img
		Delete mc
	End If
	
End Function


; calculate offset direction
Function maze_dircalc(l.maze_loc,dir,r.maze_loc)
	Select dir
		Case 0
			dx = 0
			dy = -1
		Case 1
			dx = 1
			dy = 0
		Case 2
			dx = 0
			dy = 1
		Case 3
			dx = -1
			dy = 0
	End Select
	
	r\x = l\x+dx
	r\y = l\y+dy
	
End Function	

;Invert offset direction
Function maze_Invdir(dir)
	Return (dir + 2) Mod 4
End Function


Function maze_validdirs(m.maze,l.maze_loc,flags)

;	DrawImage img,x,y,p

	c = 0
;	mc = First(maze_control)
;	If mc <> Null Then

		r.maze_loc = New maze_loc
		For i = 0 To 3
			maze_dircalc(l,i,r)
			
			If (r\x >= 0) And (r\x < m\width) And (r\y >= 0) And (r\y < m\height) Then
				If (flags And 1) Then
					If maze_getcell(m,r\x,r\y) > 0 Then c=c+1
				End If
				
				If (flags And 2) Then 
					If maze_getcell(m,r\x,r\y) = 0 Then c=c+1				
				End If
				
				If (flags And 4) Then
					If (maze_getcell(m,l\x,l\y) And (2^i)) =0 Then c = c + 1
				End If
			End If
	
		Next 
		Delete r
		

	
	Return c

End Function

; flag xxxxxxx1 = new dir must be empty cell
;      xxxxxx1x = new dir must be 'used' cell
;      xxxxx1xx = new dir must not have an opening already
Function maze_dir(m.maze,l.maze_loc,flags,r.maze_loc)


	safe = 0
	result = -1
	
	If maze_validdirs(m,l,flags) = 0 Then result = 0
	
	While result = -1
	
;		d=(Rnd(1)*4)-.5
		d=Rand(0,3)
		safe = safe + 1
		If safe > 100 Then Stop
			
		maze_dircalc(l,d,r)	
		
		If (r\x >= 0) And (r\x < m\width) And (r\y >= 0) And (r\y < m\height) Then
			If (flags And 1) Then
				If maze_getcell(m,r\x,r\y) > 0 Then result = 1
			End If
			
			If (flags And 2) Then 
				If maze_getcell(m,r\x,r\y) = 0 Then result = 1		
			End If

			If (flags And 4) Then
				If (maze_getcell(m,l\x,l\y) And (2^d)) =0 Then result = 1
			End If
			
		End If
		
	Wend
			
	If result = 0 Then			
		Return -1
	Else
		Return d
	End If

End Function

Function maze_generate(m.maze,crossovers,seed)
	SeedRnd seed
	finished = 0
	
	For x = 0 To m\width-1
		For y = 0 To m\height -1
			maze_setcell(m,x,y,0) 
		Next
	Next 
	
	l.maze_loc = New maze_loc
	r.maze_loc = New maze_loc
	b.maze_loc = New maze_loc
	b\x = 0
	b\y = 0
	l\x=b\x
	l\y=b\y

	maze_setcell(m,l\x,l\y,16) 
	While Not finished
		; move to new location
		If maze_dir(m,l,2,r) > -1 Then
			l\x = r\x
			l\y = r\y
		Else
			newstart = 0
			While Not newstart
				b\x = b\x + 1
				
				If b\x = m\width Then
					b\x = 0
					b\y = b\y + 1
					If b\y = m\height Then
						finished = 1
						newstart = 1
					End If
				End If
				
				If Not finished Then
					If maze_getcell(m,b\x,b\y) = 0 Then 
						newstart = 1
					End If
				End If
			Wend
	
			l\x = b\x
			l\y = b\y
		End If
		
		If Not finished Then
			d = maze_dir(m,l,1,r)
			If d > -1 Then
				maze_setcell(m,l\x,l\y,maze_getcell(m,l\x,l\y) Or (2^d))
				maze_setcell(m,r\x,r\y,maze_getcell(m,r\x,r\y) Or (2^((d + 2) Mod 4)))	
;				maze_drawcell(m,r)
			End If
		End If
	
	Wend
		
	maze_setcell(m,0,0,maze_getcell(m,0,0) - 16)
	
	
	; generate crossovers
	i = 0
	While i < crossovers
		fails = 0
		Repeat
			l\x = Rnd(1,m\width-2)
			l\y = Rnd(1,m\height-2)
			d = maze_dir(m,l,4,r)
			If d > -1 Then
				m0 = maze_getcell(m,l\x,l\y)
				m1 = maze_getcell(m,r\x,r\y)

				If (((m0 And 1)=1)+((m0 And 2)=2)+((m0 And 4)=4)+((m0 And 8)=8) > 1) Or (((m1 And 1)=1)+((m1 And 2)=2)+((m1 And 4)=4)+((m1 And 8)=8) > 1) Then
					d = -1
				Else
					If d = 0 Or d=2 Then
						If (((m0 And 2) = 2) And ((m1 And 2) = 2)) Or (((m0 And 8) = 8) And ((m1 And 8) = 8)) Then
							d = -1
						End If
					Else
						If (((m0 And 1) = 1) And ((m1 And 1) = 1)) Or (((m0 And 4) = 4) And ((m1 And 4) = 4)) Then
							d = -1
						End If				
					End If
				End If
			End If
			If d = -1 Then fails = fails + 1
		Until d > -1 Or fails > 50
		
		If d > -1 Then
				maze_setcell(m,l\x,l\y,maze_getcell(m,l\x,l\y) Or (2^d))
				maze_setcell(m,r\x,r\y,maze_getcell(m,r\x,r\y) Or (2^((d + 2) Mod 4)))	
		End If
	
		i = i + 1
	Wend
	
	
	Delete l
	Delete r
	Delete b

End Function

Type maze_node
	Field x,y
	Field dir,tries
	Field edir
End Type

Function maze_clearRoute(m.maze)
	; clear out route information
	For x = 0 To m\width-1
		For y = 0 To m\height-1
			maze_setcell(m,x,y,(maze_getcell(m,x,y) And 15))
		Next
	Next
End Function

Function maze_allSolve(m.maze,fx,fy)
	maze_clearroute(m.maze)
	For x = 0 To m\width-1
		For y = 0 To m\height-1
			If (x <> fx Or y <> fy) And ((maze_getcell(m,x,y) And 240) = 0) Then
				maze_solve(m,x,y,fx,fy)
			End If
		Next
	Next
End Function

; solve the maze using a fairly simple "wall hugger" style process
Function maze_solve(m.maze,sx,sy,fx,fy)
 If Not m\crossing Then
	; create a workspace same size as the map.
	count = 1
	
	n.maze_node = New maze_node
	n\x = sx
	n\y = sy
	n\dir = -1
	n\tries = 0
	n\edir = 16
	finished = 0
	
	
	l.maze_loc = New maze_loc
	r.maze_loc = New maze_loc
	
	While (n\x <> fx Or n\y <> fy) And (finished = 0)

	
		n\tries = n\tries + 1
		n\dir = (n\dir + 1) Mod 4
		If n\tries > 4 Then
			Delete n
			n = Last maze_node
		Else
			If maze_diropen(m,n\x,n\y,n\dir) And n\dir <> n\edir Then
				count = count + 1
				; that dir is open	
				l\x = n\x
				l\y = n\y
				dir = n\dir
				maze_dircalc(l,n\dir,r)
				n = New maze_node
				n\x = r\x
				n\y = r\y
				n\dir = dir
				n\tries = 0
				n\edir = maze_invdir(dir)
			End If
		End If
	Wend
	
	Delete l
	Delete r
	
	
	;create final codestring & inscribe on maze
	cs$ = ""
	For n = Each maze_node
		maze_setcell(m,n\x,n\y,(maze_getcell(m,n\x,n\y) And 15) Or (2^(n\dir+4)))
		cs$ = cs$ + Str$(n\dir)
	Next

	; clear the workspace at the end
	Delete Each maze_node
  End If
  Return cs$
End Function

Function Maze_Save(m.maze,filename$)
	; Open a file to write to
	fileout = WriteFile(filename$)
	WriteInt fileout,m\width
	WriteInt fileout,m\height
	WriteInt fileout,m\crossing
	WriteBytes m\buffer,fileout,0,m\width*m\height
	CloseFile fileout
End Function

Function Maze_Load.maze(filename$)
	m.maze = New maze
	filein = ReadFile(filename$)
	m\width = ReadInt( filein)
	m\height = ReadInt( filein)
	m\crossing = ReadInt(filein)
	m\buffer = CreateBank(m\width*m\height)
	ReadBytes m\buffer,filein,0,m\width*m\height
	
	Return m

End Function

Schrift = LoadFont ("Arial",27,20100)
SetFont Schrift
Aus=1
	maze_startup(".\Bilder\mazeblocks.png",16,16)

	mwidth = 50;32; 	set a variable for the width 
	mheight = 50;32;	and the height of the maze


	SetBuffer BackBuffer()

	
	
	finished = 0
	x = 0
	y = 0
	LabLA=0
	
	a$="1"
	k = Asc(a$)
.StartL
	a$="1"
	 Looo=0
	While Not finished
		Cls
		
		If a$ = "1" Then
			If m.maze <> Null Then maze_Delete(m)
			m.maze = maze_create(mwidth,mheight,MilliSecs(),0)
			x = 0
			y = 0		
		End If
		
		If a$="2" And x <> mwidth-1 And y <> mheight-1 Then
		LabLA=1
			maze_clearRoute(m)
			maze_solve(m,x,y,mwidth-1,mheight-1)
		End If
		
		If a$="4" Then  maze_save(m,"maze.maz")
		If a$="5" And FileType("maze.maz") = 1 Then
			maze_delete(m)
			m = maze_load("maze.maz")
		End If
		
		If a$ = "3" Then maze_clearroute(m)
		
		
		If k = 28 And maze_NorthOpen(m,x,y) Then
			y=y-1
		End If

		If k = 29 And maze_SouthOpen(m,x,y) Then
			y=y+1
		End If

		If k = 30 And maze_EastOpen(m,x,y) Then
			x=x+1
		End If

		If k = 31 And maze_WestOpen(m,x,y) Then
			x=x-1
		End If

	maze_display(m,1)

	If a$ = "6" Or a$= "7" Then
	If a$ = "6" Then maze_clearroute(m)
	If a$ = "7" Then xx=x yy=y x=0 y=0 : maze_clearRoute(m):maze_solve(m,x,y,mwidth-1,mheight-1) :x=xx y=yy
	maze_display(m,1)
	Bild = CreateImage (800,800)
	SetBuffer ImageBuffer (Bild)
	CopyRect 0,0,800,800,0,0,FrontBuffer(),ImageBuffer(Bild)
	SetBuffer FrontBuffer()
	Repeat
	Cls
	Locate 1,1
	Print "Unterstützte Bildformate: Bmp, Jpg, Png, Pcx, Tga, Iff"
	Print "Pfad und Dateinamen um das Labyrinth zu speichern z.b. C:\Users\Nico\Desktop\newball.jpg:"
	Pfad$=Input()
	SaveImage (Bild,Pfad$)
	If FileType(Pfad$) = 0 Then Print "Ungültiger Pfad!" Delay 1000
	Cls
	Until FileType(Pfad$) = 1
	SetBuffer BackBuffer()
	maze_display(m,1)
	EndIf
	maze_drawincell(x,y,255,255,255)
	Text 810,0, "Bewege dich mit den Pfeiltasten!"
	Text 810,30,"Start: Oben links Ziel: Unten rechts"	
	Text 810,60,"1 = Neues Labyrinth"
	Text 810,90,"2 = Zeig mir die Lösung"
	Text 810,120,"3 = Lösungen nicht mehr anzeigen"
	Text 810,150,"4 = Labyrinth sichern"
	Text 810,180,"5 = Gesichertes Labyrinth laden"
	Text 810,210,"6 = Labyrinth exportieren (ohne Lösung)"
	Text 810,240,"7 = Labyrinth exportieren (mit Lösung)"
	Flip


If x=49 And y=49 Then
If LabLA=1 Then Protokoll$="Labyrinth (Mit Hilfe der Lösung)" Else Protokoll$="Labyrinth"
SpielstandS
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=Aufgaben+1
FlushKeys
FlushMouse
Goto Programmstart
EndIf
		k = WaitKey()
		a$ = Lower$(Chr$(k))
	Wend
		




.Aufgabe6
ClsVB
Versuche=0
SGBS$=0
PauseChannel HGM
FlushKeys
Schrift = LoadFont ("Arial",30,100)
SetFont Schrift
HGrundH1=LoadImage (".\Bilder\SElba.jpg")
DrawImage HGrundH1, 0,0
Restore Woerter

;Einleseschlaufe für 137 Wörter
      Const Max = 136
Dim Wort$(Max)
Print "Errate das Wort indem du einzelne"
Print "Buchstaben vorschlägst."
Print "Die ? geben dir an, wieviele Buchstaben das Wort hat."
Print "Du kannst nur einen Buchstaben auf einmal erraten."
Print "Tipp: Es hat keine Nomen."

.Woerter
Data "ihm", "ihn", "ihr", "ihnen", "riechen", "fernsehen", "bezahlen"
Data "ruhig", "mehr", "mehrere", "wohnen", "während", "stehen", "schief"
Data "sehr", "nehmen", "ehrlich", "fröhlich", "allmählich", "fahren", "tief"
Data "ähnlich", "wahr", "gefährlich", "gehen", "ohne", "wohl", "zuviel"
Data "erzählen", "bleiben", "bleibt", "blieb", "geblieben", "bringen", "bringt"
Data "brachte", "gebracht", "denken", "denkt", "dachte", "gedacht"
Data "erschrecken", "erschrickt", "erschrak", "erschrocken"
Data "essen", "isst", "ass", "gegessen", "fahren", "fährt", "fuhr", "gefahren"
Data "fallen", "fällt", "fiel", "gefallen", "finden", "findet", "fand"
Data "gefunden", "fliegen", "fliegt", "flog", "geflogen", "geben", "gibt"
Data "gefällt", "gefiel", "gehen", "geht", "ging", "gegangen"
Data "geschehen", "geschieht", "geschah", "haben", "hat", "hatte", "gehabt"
Data "halten", "hält", "hielt", "gehalten", "kommen", "kommt", "kam", "gekommen" 
Data "können", "kann", "konnte", "gekonnt", "laden", "lädt", "lud", "geladen"
Data "laufen", "läuft", "lief", "gelaufen", "legen", "legt", "legte", "gelegen"
Data "leiden", "leidet", "litt", "gelitten", "lesen", "liest", "las", "gelesen"
Data "liegen", "liegt", "lag", "gelegen", "messen", "misst", "mass", "gemessen"
Data "nehmen", "nimmt", "nahm", "genommen", "rufen", "ruft", "rief", "gerufen"
Data "schlafen", "schläft", "schlief", "geschlafen", "schreiben", "schreibt"
Data "schrieb", "geschrieben", "sehen"

For i = 0 To Max
  ;
Read Wort$(i)
Next
; Zufallsschlaufe 
    SeedRnd MilliSecs() 
    Zufall$ = Wort$(Rand(0,Max))

Geraten$ = String$("?",Len(Zufall$))

Input()
StartZeit = MilliSecs()
Cls
Locate 1,1
DrawImage HGrundH1, 0,0
Versuche=0
VersucheV=10
GeratenA$=0
Repeat
If GeratenA$=Geraten$ Then Versuche=Versuche+1
VersucheV=10-Versuche
GeratenA$=Geraten$
Repeat
Print Geraten$
If Not SGBS$="" Then Print "Geratene Buchstaben: "+ Mid$(SGBS$,3,Len (SGBS$))
Text 1,950,"Du hast noch "+VersucheV+" Versuche!"
Zeichen$ = Input("Buchstaben: ")
If Len (Zeichen$)>1 Or Len (Zeichen$)=0 Then
Cls
Locate 1,1
DrawImage HGrundH1, 0,0
Print "Du kannst nur einen Buchstaben auf einmal erraten!"
Delay 2000
Cls
Locate 1,1
DrawImage HGrundH1, 0,0
EndIf
Until Len (Zeichen$)=1
If SGBS$="" Then SGBS$=SGBS$+Zeichen$ Else SGBS$=SGBS$+","+Zeichen$
Cls
Locate 1,1
DrawImage HGrundH1, 0,0
  ; Prüfen auch auf Mehrfachvorkommen
  For i = 1 To Len(Zufall$)
    If Zeichen$ = Mid$(Zufall$,i,1) Then
      Stelle = i
      Neu$ = Left$(Geraten$,Stelle-1) + Zeichen$
      Neu$ = Neu$ + Mid$(Geraten$,Stelle+1)
      Geraten$ = Neu$
    EndIf
  Next
Until Geraten$ = Zufall$ Or VersucheV=1




ClsVB
HGrundH1=LoadImage (".\Bilder\SElba.jpg")
DrawImage HGrundH1, 0,0
If Geraten$ = Zufall$ Then
Print "Herzlichen Glückwunsch!"
Print "Du hast das Wort in "+Versuche+" Versuchen herausgefunden!"
Input()
Else
Print "Das Wort wäre "+Zufall$+" gewesen!"
Print ""
Print "Du hast das Wort leider nicht in 10 Versuchen herausgefunden."
Print "Versuche die Aufgabe erneut."
Protokoll$="Wörter erraten" SpielstandS
Protokoll$="Versuche: "+Versuche SpielstandS
Input()
Goto Aufgabe6
EndIf
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=Aufgaben+1
FlushKeys
FlushMouse
Goto Programmstart
End
Return



.Aufgabe7
ClsVB
PauseChannel HGM
FlushKeys
Verben = 0   Verben1 = 0    Verben2 = 0
HGrundH=LoadImage (".\Bilder\Flugzeug.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,0,0
Print"Erkenne das Verb in dem folgenden Satz."
Print"Schreibe das Verb und drücke Enter"
Print
Print "Der Kluge fährt im Zug."

Repeat
Ratwort1$ = Input()
If Ratwort1$ = "fährt" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
Verben = Verben +1
PlayMusic (".\Sounds\Door1.mp3")
EndIf
If Verben=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "fährt" Or Ratwort1$ = "faehrt"
Print
Print "Wie heisst das Verb in der Grundform?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "fahren" Then
  Print "Richtig!" 
  Else Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben1 = Verben1 +1
EndIf
If Verben1=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "fahren"
Print
Print "Und wie heisst das Verb im Präteritum (Vergangenheit)?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "fuhr" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben2 = Verben2 +1
EndIf
If Verben2=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "fuhr" Or Ratwort1$ = "faehrt"
Print



Cls 
Locate 1,1
Verben = 0   Verben1 = 0    Verben2 = 0
HGrundH=LoadImage (".\Bilder\Flugzeug.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,0,0
Print"Erkenne das Verb in dem folgenden Satz."
Print"Schreibe das Verb und drücke Enter"
Print
Print "Zeichne die Linien bitte mit dem Lineal."

Repeat
Ratwort1$ = Input()
If Ratwort1$ = "zeichne" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben = Verben +1
EndIf
If Verben=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "zeichne"
Print
Print "Wie heisst das Verb in der Grundform?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "zeichnen" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben1 = Verben1 +1
EndIf
If Verben1=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "zeichnen"
Print
Print "Und wie heisst das Verb im Präteritum (Vergangenheit)?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "zeichnete" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben2 = Verben2 +1
EndIf
If Verben2=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "zeichnete"
Print



Cls 
Locate 1,1
Verben = 0   Verben1 = 0    Verben2 = 0
HGrundH=LoadImage (".\Bilder\Flugzeug.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,0,0
Print"Erkenne das Verb in dem folgenden Satz."
Print"Schreibe das Verb und drücke Enter"
Print
Print "Kennst du einen guten Witz?"

Repeat
Ratwort1$ = Input()
If Ratwort1$ = "kennst" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben = Verben +1
EndIf
If Verben=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "kennst"
Print
Print "Wie heisst das Verb in der Grundform?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "kennen" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben2 = Verben2 +1
EndIf
If Verben1=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "kennen"
Print
Print "Und wie heisst das Verb im Präteritum (Vergangenheit)?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "kannte" Or Ratwort1$ = "kanntest" Then
  Print "kannte!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben2 = Verben2 +1
EndIf
If Verben3=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "kannte" Or Ratwort1$ = "kanntest"
Print


Cls 
Locate 1,1
Verben = 0   Verben1 = 0    Verben2 = 0
HGrundH=LoadImage (".\Bilder\Flugzeug.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,0,0
Print"Erkenne das Verb in dem folgenden Satz."
Print"Schreibe das Verb und drücke Enter"
Print
Print "Mein Bruder heisst Anton."

Repeat
Ratwort1$ = Input()
If Ratwort1$ = "heisst" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben = Verben +1
EndIf
If Verben=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "heisst"
Print
Print "Wie heisst das Verb in der Grundform?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "heissen" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben1 = Verben1 +1
EndIf
If Verben1=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart

Until Ratwort1$ = "heissen"
Print
Print "Und wie heisst das Verb im Präteritum (Vergangenheit)?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "hiess" Then
  Print "kannte!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben2 = Verben2 +1
EndIf
If Verben2=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "hiess"

Cls 
Locate 1,1
Verben = 0   Verben1 = 0    Verben2 = 0
HGrundH=LoadImage (".\Bilder\Flugzeug.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,0,0
Print"Erkenne das Verb in dem folgenden Satz."
Print"Schreibe das Verb und drücke Enter"
Print
Print "Die Schule fängt um acht Uhr an."

Repeat
Ratwort1$ = Input()
If Ratwort1$ = "fängt" Or Ratwort1$ = "faengt" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben = Verben +1
EndIf
If Verben=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "fängt" Or Ratwort1$ = "faengt"
Print
Print "Wie heisst das Verb in der Grundform?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "fangen" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben1 = Verben1 +1
EndIf
If Verben1=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart

Until Ratwort1$ = "fangen"
Print
Print "Und wie heisst das Verb im Präteritum (Vergangenheit)?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "fieng" Then
  Print "kannte!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben2 = Verben2 +1
EndIf
If Verben2=4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "fieng"

Protokoll$="Verben" SpielstandS
Gosub PZeit
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=Aufgaben+1
Smeili=1
Goto Programmstart
End


.Aufgabe8
ClsVB
PauseChannel HGM
Cls 
Locate 1,1
Color 1,1,1
ClsColor 253,202,13
Cls
Schrift = LoadFont ("Arial",45,201)
SetFont Schrift
Print "Beschrieb"
Schrift = LoadFont ("Arial",24)
SetFont Schrift
Print "Nachdem du Enter drückst hörst du ein Lied."
Print "Nach dem Lied kommst du auf ein Textfeld in das du die genaue Anzahl Sekunden der Lieddauer aufschreiben musst."
Print "Mit einem Druck auf Enter erscheint unter dem Textfeld Richtig! oder gar nichts."
Print "Gar nichts bedeutet Falsch!"
Print "Mit einem weiteren Druck auf Enter hörst du dann wieder ein Lied."
Print "So geht es noch zehn mal weiter bis du dann schliesslich wieder zum Spiel kommst."
Print "Achtung!"
Print "Wenn du mehr als drei von zehn Aufgaben falsch hast, kommst du wieder genau zu diesem Text den du jetzt liest!"
Print "Viel Spass!"
Game= LoadSound (".\Sounds\0001Geame.mp3")
Input()
Cls
RichtigLZ=0
GameP=PlaySound(Game)
Delay 1000
PauseChannel GameP
Cls
Locate 1,1
ClsColor 253,202,13
Cls
Locate 200,1
Print "Sekunden"
Locate 1,1
LiedZ=Input ("Das Lied dauerte ")
If LiedZ=1 Then Print "Richtig!" RichtigLZ=RichtigLZ+1
Input()
ResumeChannel GameP
Delay 3000
PauseChannel GameP
Cls
Locate 1,1
ClsColor 253,202,13
Cls
Locate 200,1
Print "Sekunden"
Locate 1,1
LiedZ=Input ("Das Lied dauerte ")
If LiedZ=3 Then Print "Richtig!" RichtigLZ=RichtigLZ+1
Input()
ResumeChannel GameP
Delay 5000
PauseChannel GameP
Cls
Locate 1,1
ClsColor 253,202,13
Cls
Locate 200,1
Print "Sekunden"
Locate 1,1
LiedZ=Input ("Das Lied dauerte ")
If LiedZ=5 Then Print "Richtig!" RichtigLZ=RichtigLZ+1
Input()
ResumeChannel GameP
Delay 18000
PauseChannel GameP
Cls
Locate 1,1
ClsColor 253,202,13
Cls
Locate 200,1
Print "Sekunden"
Locate 1,1
LiedZ=Input ("Das Lied dauerte ")
If LiedZ=18 Then Print "Richtig!" RichtigLZ=RichtigLZ+1
Input()
ResumeChannel GameP
Delay 8000
PauseChannel GameP
Cls
Locate 1,1
ClsColor 253,202,13
Cls
Locate 200,1
Print "Sekunden"
Locate 1,1
LiedZ=Input ("Das Lied dauerte ")
If LiedZ=8 Then Print "Richtig!" RichtigLZ=RichtigLZ+1
Input()
ResumeChannel GameP
Delay 3000
PauseChannel GameP
Cls
Locate 1,1
ClsColor 253,202,13
Cls
Locate 200,1
Print "Sekunden"
Locate 1,1
LiedZ=Input ("Das Lied dauerte ")
If LiedZ=3 Then Print "Richtig!" RichtigLZ=RichtigLZ+1
Input()
ResumeChannel GameP
Delay 2000
PauseChannel GameP
Cls
Locate 1,1
ClsColor 253,202,13
Cls
Locate 200,1
Print "Sekunden"
Locate 1,1
LiedZ=Input ("Das Lied dauerte ")
If LiedZ=2 Then Print "Richtig!" RichtigLZ=RichtigLZ+1
Input()
ResumeChannel GameP
Delay 11000
PauseChannel GameP
Cls
Locate 1,1
ClsColor 253,202,13
Cls
Locate 200,1
Print "Sekunden"
Locate 1,1
LiedZ=Input ("Das Lied dauerte ")
If LiedZ=11 Then Print "Richtig!" RichtigLZ=RichtigLZ+1
Input()
ResumeChannel GameP
Delay 20000
PauseChannel GameP
Cls
Locate 1,1
ClsColor 253,202,13
Cls
Locate 200,1
Print "Sekunden"
Locate 1,1
LiedZ=Input ("Das Lied dauerte ")
If LiedZ=20 Then Print "Richtig!" RichtigLZ=RichtigLZ+1
Input()
ResumeChannel GameP
Delay 7000
PauseChannel GameP
Cls
Locate 1,1
ClsColor 253,202,13
Cls
Locate 200,1
Print "Sekunden"
Locate 1,1
LiedZ=Input ("Das Lied dauerte ")
If LiedZ=7 Then Print "Richtig!" RichtigLZ=RichtigLZ+1
Input()
Cls
Locate 1,1
ClsColor 253,202,13
Cls
Print "Du hast "+ RichtigLZ+" Aufgaben richtig gelöst!"
Protokoll$="Zeitverständnis" SpielstandS
Protokoll$="Punkte: "+RichtigLZ+"/10" SpielstandS
Input()
ResumeChannel kamelpianoP
If  RichtigLZ=7 Or  RichtigLZ>7 Then
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=Aufgaben+1
Goto Programmstart
EndIf
Goto Aufgabe8
End






.Aufgabe9
PauseChannel HGM
ClsVB
Witze=0
Color 0,255,255 
Schrift = LoadFont ("Arial",45,20100)
SetFont Schrift
FlushKeys
FlushMouse
Color 255,0,0
Print "Witze"
Schrift = LoadFont ("Arial",24,True)
SetFont Schrift
Print "Diese Aufgabe ist zum Entspannen gedacht."
Print "Mit einem Druck auf Enter erscheint ein Witz."
Print "Wenn du dann nochmals auf Enter drückst erscheint ein weiterer Witz."
Print "So geht es immer weiter bis du 10 Witze gelesen hast."
Input()
ClsColor 255,0,0
Cls
Color 0,0,0
Locate 1,10
Schrift = LoadFont ("Arial",30,True)
SetFont Schrift
Aufgabe=0
NZDGW(0)=0
NZDGW(1)=0
NZDGW(2)=0
NZDGW(3)=0
NZDGW(4)=0
NZDGW(5)=0
NZDGW(6)=0
NZDGW(7)=0
NZDGW(8)=0
NZDGW(9)=0
NZDGW(10)=0
SeedRnd MilliSecs()

Repeat
Zufall=Rand(1,30)
VDNZGWK=0
Repeat
VDNZGWK=VDNZGWK+1
If NZDGW(VDNZGWK)=Zufall Then Zufall=Rand(1,30) VDNZGWK=0
Until VDNZGWK=10

ClsColor 255,201,14
Cls


If Zufall=1 Then
Print "  Die Familie macht einen Ausflug mit dem"
Print "  Zug in die Berge. Auf dem Bahnhof in München"
Print "  hat der Zug etwas länger Aufenthalt."
Print "  Auf dem Bahnsteig geht ein Mann"
Print "  mit einem Imbisswagen entlang und ruft laut:"
Print "  "+Chr$(34)+"Heisse Würstchen! Heisse Würstchen!"+Chr$(34)
Print "  Da öffnet Paul das Fenster und ruft hinaus:"
Print "  "+Chr$(34)+"Könnten Sie nicht still sein? Uns"
Print "  interessiert es nicht, wie Sie heissen."+Chr$(34)
EndIf

If Zufall=2 Then
Print "  Ostfriesische Klassenfahrt: Ein ostfriesischer"
Print "  Lehrer wartet mit seinen Schülern der 3. Klasse"
Print "  auf dem Bahnsteig. Einen Zug nach dem anderen"
Print "  lässt er passieren, ohne mit seiner Klasse"
Print "  einzusteigen. Schliesslich platzt ihm der Kragen:"
Print "  "+Chr$(34)+"Den nächsten nehmen wir, Kinder. Auch wenn wieder"
Print "  nur 1. und 2. Klasse draufsteht."+Chr$(34)
EndIf

If Zufall=3 Then
Print "  Abschlussprüfung auf der Polizeiakademie."
Print "  Die Anwärter werden einzeln der Prüfungskommission"
Print "  vorgeführt. Den ersten fragt der Prüfer: "+Chr$(34)+"Was ist schneller,"
Print "  Licht oder Schall?"+Chr$(34)+" "+Chr$(34)+"Schall! Warum denn das,
Print "  fragt der Vorsitzende?"+Chr$(34)
Print "  "+Chr$(34)+"Nun, wenn ich meinen Fernseher anmache, kommt auch "
Print "  erst der Ton, und ...."+Chr$(34)+" "+Chr$(34)+"Durchgefallen! der Nächste"
Print "  bitte. Was ist schneller, Licht oder Schall?"+Chr$(34)+""
Print "  "+Chr$(34)+"Licht!"+Chr$(34)+" "+Chr$(34)+"Und warum?"+Chr$(34)+" "+Chr$(34)+"Wenn ich mein Radio anmache"
Print "  geht auch zuerst das Licht und ..."+Chr$(34)+" "+Chr$(34)+"Durchgefallen,"
Print "  raus. Der Nächste, bitte. "+Chr$(34)+"Was ist schneller Licht"
Print "  oder Schall?"+Chr$(34)+" "+Chr$(34)+"Licht, ist doch klar!"+Chr$(34)+" "+Chr$(34)+"Aha. Und warum?"+Chr$(34)
Print "  "+Chr$(34)+"Nun, die Augen sind doch am Kopf viel weiter"
Print "  vorn als die Ohren..."+Chr$(34)+""
EndIf

If Zufall=4 Then
Print "  Der Lehrer: "+Chr$(34)+"Lukas, warum kommst du schon"
Print "  wieder zu spät?"+Chr$(34)
Print "  "+Chr$(34)+"Ich habe von einem Fussballspiel geträumt."+Chr$(34)
Print "  "+Chr$(34)+"Das ist doch kein Grund, zu spät zukommen!"+Chr$(34)
Print "  "+Chr$(34)+"Doch! Es gab Verlängerung!"+Chr$(34)
EndIf

If Zufall=5 Then
Print "  "+Chr$(34)+"Hören Sie mal zu"+Chr$(34)+", sagt der Polizist zum Golfspieler,"
Print "  "+Chr$(34)+"ihr Ball ist auf die Strasse geflogen und hat"
Print "  dort die Frontscheibe eines Feuerwehrwagens im"
Print "  Einsatz zertrümmert, der deswegen gegen eine "
Print "  Mauer geprallt ist. Das Haus, das gelöscht werden"
Print "  sollte ist bis auf die Grundmauer niedergebrannt"
Print "  Was haben Sie zu diesem Schlamassel zu sagen?"+Chr$(34)
Print "  "+Chr$(34)+"Golfer: Wo ist mein Golfball!"+Chr$(34)
EndIf

If Zufall=6 Then
Print "  Mäxchen sitzt auf dem Brunnenrand und heult."
Print "  Kommt ein Polizist dazu und fragt, was los sei."
Print "  "+Chr$(34)+"Meine Muter ist in den Brunnen gefallen"+Chr$(34)+", schluchst"
Print "  Mäxchen. Der Polizist zieht sich sofort Uniform"
Print "  und Schuhe aus und stürzt sich in den Brunnen."
Print "  Nach einigen Minuten kommt er wieder heraus, hat"
Print "  aber die Mutter nicht gefunden. Sagt das Mäxchen:"
Print "  "+Chr$(34)+"Na toll, dann kann ich ja die blöde Schraube"
Print "  auch wegwerfen!"+Chr$(34)
EndIf

If Zufall=7 Then
Print "  Ein Mann sitzt in der Kneipe und bestellt sich"
Print "  ein Bier. Der Kellner bringt dem bereits ziemlich"
Print "  betrunkenen Mann das Bier und stellt es auf einen"
Print "  Bierdeckel auf den Tisch. Nach 10 Minuten bestellt"
Print "  der Mann wieder ein Bier. Der Kellner bringt es"
Print "  aber der Bierdeckel ist weg, also legt er einen"
Print "  neuen unters Bier. Nach weiteren 10 Minuten bestellt"
Print "  der Mann wieder ein Bier. Wieder ist der Bierdeckel"
Print "  weg. Der Kellner legt wieder einen neuen unter das"
Print "  Bier. Schliesslich bestellt der Mann das 3.Mal ein"
Print "  Bier, aber wieder ist der Bierdeckel weg. Der"
Print "  Kellner hat die Schanauze voll und legt keinen"
Print "  neuen unters Bier. Beschwert sich der Mann:"
Print "  "+Chr$(34)+"Wo bleibt der Keks?"+Chr$(34)
EndIf

If Zufall=8 Then
Print "  Schön, dass du gekommen bist, Tante Ottilie, sagte"
Print "  Florian artig. Gestern erst hat Papa gesagt:"
Print "  "+Chr$(34)+"Tante Ottilie fehlt uns gerade noch!"+Chr$(34)
EndIf

If Zufall=9 Then
Print "  Mama, darf ich ein bisschen mit Opa spielen?"
Print "  Nein der Sarg bleibt heute zu."
EndIf

If Zufall=10 Then
Print "  Polizist: "+Chr$(34)+"Herzlichen Glückwunsch. Sie sind"
Print "  der 100 000ste Autofahrer, der diese neue"
Print "  Autobahn befährt, und Sie bekommen als Preis"
Print "  20 000 Euro! Was möchten Sie mit diesem Geld"
Print "  anfangen?"+Chr$(34)+" Vater: "+Chr$(34)+"Dann mach ich mir mal zuerst"
Print "  den Führerschein."+Chr$(34)+" Mutter: "+Chr$(34)+"Hören Sie nicht auf"
Print "  ihn, er ist total betrunken."+Chr$(34)+" Der schwerhörige"
Print "  Opa: "+Chr$(34)+"Ich habe euch doch gleich gesagt, dass"
Print "  es keine gute Idee war, das Auto zu stehlen."+Chr$(34)+""
Print "  Eine Stimme aus dem Kofferraum: "+Chr$(34)+"Sind wir "
Print "  schon hinter der Grenze?"+Chr$(34)
EndIf

If Zufall=11 Then
Print "  Fragt der Lehrer: "+Chr$(34)+"Wer kann mir Tiere nennen,"
Print "  die bei uns leben?"+Chr$(34)+""
Print "  Mariechen streckt den Finger und zählt auf:"
Print "  "+Chr$(34)+"Eselchen,Pferdchen,Schäfchen..."+Chr$(34)
Print "  Der Lehrer unterbricht: Lass doch bitte das"
Print "  >chen< weg!"
Print "  Mariechen fährt fort: "+Chr$(34)+"Kanin,Eichhorn..."+Chr$(34)+""
EndIf

If Zufall=12 Then
Print "  Fritzchen geht mit seiner Oma in die Stadt."
Print "  Vor dem Supermarkt findet er eine Zehnfrankennote."
Print "  Als er sie aufheben will, sagt die Oma: "+Chr$(34)+"Was auf"
Print "  dem Boden liegt, darf man nicht aufheben!"+Chr$(34)
Print "  Sie gehen weiter. Fritzchen findet eine"
Print "  Zwanzigfrankennote. Die Oma sagt wieder: "+Chr$(34)+"Was auf"
Print "  dem Boden liegt, darf man nicht aufheben!"+Chr$(34)+""
Print "  Auf dem Rückweg fällt die Oma hin. Fritzchen,"
Print "  hilf mir doch aufzustehen! Da sagt dieser: "+Chr$(34)+"Was"
Print "  auf dem Boden liegt, darf man nicht aufheben!"+Chr$(34)+""
EndIf

If Zufall=13 Then
Print "  Ein Amerikaner machte eine Stadtrundfahrt durch"
Print "  Paris und lässt sich die Attraktionen zeigen."
Print "  Am Triumphbogen erzählt ihm der französische"
Print "  Taxifahrer, dass dieser Bogen ein wahres Wunderwerk"
Print "  sei, 20 000t schwer. Der Amerikaner fragt, wie lange"
Print "  der Bau dieses Monuments gedauert habe. Als er"
Print "  erfährt, dass es 15 Jahre gedauert hat, lachte er nur"
Print "  und sagte: "+Chr$(34)+"Ach in Amerika brauchen wir für so etwas"
Print "  höchstens 15 Tage."+Chr$(34)+" Der Franzose ist schon etwas"
Print "  eingeschnappt. Am Louvre angelangt, das gleiche"
Print "  Spiel. Der Franzose nennt die Bauzeit von 20 Jahren."
Print "  Daraufhin behauptet der Amerikaner: "+Chr$(34)+"Ach, in"
Print "  Amerika brauchen wir für sowas höchstens 20 Tage."+Chr$(34)
Print "  Schliesslich kommen sie zum Eiffelturm. Donnerwetter,"
Print "  staunt der Amerikaner, was ist denn das? Der"
Print "  Franzose daraufhin: "+Chr$(34)+"Keine Ahnung, stand gestern"
Print "  noch nicht da!"+Chr$(34)
EndIf

If Zufall=14 Then
Print "  Das Thema des Deutschaufsatzes lautet: "+Chr$(34)+"Mein"
Print "  Lieblingstier."+Chr$(34)+" Simone schreibt: "+Chr$(34)+"Unser Hund ist"
Print "  super. Er ist der beste Hund der Welt. Er sucht"
Print "  Stöckchen, springt sehr hoch und bringt uns jeden"
Print "  Morgen die Zeitung, obwohl wir gar keine"
Print "  abonniert haben."+Chr$(34)+""
EndIf

If Zufall=15 Then
Print "  Moritz sagt beim Abendessen zu seinem Vater:"
Print "  "+Chr$(34)+"Vater, ich muss dir was sagen!"+Chr$(34)+" Der Vater:"
Print "  "+Chr$(34)+"Nein, jetzt nicht, Moritz. Man spricht nicht"
Print "  mit vollem Mund."+Chr$(34)+" "+Chr$(34)+" Aber es ist sehr wichtig,"
Print "  Vater!"+Chr$(34)+", sagte Mortiz drängelnd. "+Chr$(34)+"Das kannst"
Print "  du mir auch später sagen!"+Chr$(34)+", antwortet der "
Print "  Vater wütend. Nach dem Essen. "+Chr$(34)+"So, Moritz,"
Print "  was wolltest du mir sagen?"+Chr$(34)+" "+Chr$(34)+"Ach, jetzt ist"
Print "  es zu spät, du hast den Wurm im Salat schon"
Print "  gegessen."+Chr$(34)
EndIf

If Zufall=16 Then
Print "  Ein Schäfer sitzt mit einem Schaf am Strassenrand."
Print "  Da kommt ein Porsche vorbei, blieb stehen und"
Print "  bietet dem Hirten an mitzufahren. Allerdings"
Print "  nur ohne Schaf. Der Schäfer sagt dem Porschefahrer,"
Print "  dass es kein Problem wäre, das Schaf einfach hinten"
Print "  am Auto anzubinden. Als sie schon 100km/h fahren,"
Print "  sieht der Porschefahrer überrascht, dass das Schaf"
Print "  ganz locker hinter seinem Auto hertrabt.Also"
Print "  beschliesst er, noch etwas schneller zu fahren."
Print "  Bei 150 km/h ist das Schaf schon fast im Galopp."
Print "  Als er weiter auf 200km/h beschleunigt, sieht er,"
Print "  dass das Schaf auf einmal so seltsam mit dem linken"
Print "  Ohr wackelt. Als er den Schäfer darauf aufmerksam"
Print "  macht, sagt dieser nur: "+Chr$(34)+"Keine Sorge, das macht's"
Print "  immer wenn's überholen will!"+Chr$(34)
EndIf

If Zufall=17 Then 
Print "  Friederich und seine Freunde haben Murmeln gekauft."
Print "  Sie kommen an einer Leichenhalle vorbei. Vor dem"
Print "  Eingang verteilen sie zwei Murmeln, die hineinkullern."
Print "  In der Halle zählten sie die Murmeln ab. "+Chr$(34)+"Eine für"
Print "  dich, eine für mich ..."+Chr$(34)+" usw. Der Hausmeister kommt"
Print "  vorbei, hört das und rennt zum Pfarrer: "+Chr$(34)+"Herr"
Print "  Pfarrer, in der Leichenhalle spielt der Teufel"
Print "  mit Gott um die Seele der Verstorbenen!"+Chr$(34)+" Also"
Print "  geht der Pfarrer mit ihm zurück. Dort hören"
Print "  sie eine Stimme: "+Chr$(34)+"Das waren alle! Und die vor"
Print "  der Tür holen wir uns auch noch!"+Chr$(34)+""
EndIf

If Zufall=18 Then
Print "  Reisender zum Schaffner:"
Print "  Wie lange hält der Zug?-"
Print "  Bei guter Pflege 25 Jahre."
EndIf

If Zufall=19 Then
Print "  "+Chr$(34)+"Können Sie mir einen unbekanten,"
Print "  schneesicheren Urlaubsort empfehlen?"+Chr$(34)
Print "  Tut mir leid, die sind alle ausgebucht!"
EndIf

If Zufall=20 Then
Print "  Ein Mann beim Verhör."
Print "  Polizist: "+Chr$(34)+"Sie haben doch gesehen, wie"
Print "  die alte Dame von einem Kerl verprügelt"
Print "  wurde. Wieso haben Sie dann nicht geholfen?"+Chr$(34)
Print "  Mann: "+Chr$(34)+"Ich dachte, der schafft das allein!"+Chr$(34)
EndIf

If Zufall=21 Then
Print "  Ein Landwirt gewinnt 3000 Euro im Lotto und"
Print "  bekommt sie in drei 1000 Euro Scheinen bar"
Print "  bezahlt. Leider fällt ihm das Geld auf den"
Print "  Boden und seine fette Sau frisst das Geld."
Print "  Der Geldbote hatte einen Ratschlag parat:"
Print "  "+Chr$(34)+"Geben Sie der Sau ein Korn zu trinken und"
Print "  treten Sie ihr in den Hintern, dann kotzt"
Print "  sie das Geld wieder aus."+Chr$(34)+" Da der Bauer gerade"
Print "  kein Korn zuhause hat, schleppt er die Sau in"
Print "  die nächste Kneipe, bestellt ein Bier und ein"
Print "  Korn. Er trinkt das Bier auf ex, gibt der Sau"
Print "  den Korn,tritt ihr in den Hintern, und siehe da,"
Print "  sie erbricht einen Tausender. Der Wirt ist "
Print "  begeistern und fragt,ob er das Tier kaufen könne."
Print "  "+Chr$(34)+"Die Sau ist unverkäuflich,"+Chr$(34)+" sagte der Bauer,"
Print "  bestellt noch ein Korn, noch ein Bier, tritt"
Print "  der Sau in den Hintern, und der zweite Tausender"
Print "  kommt zum Vorschein. Der Wirt kann es kaum glauben,"
Print "  und der Bauer wiederholte das Spiel zum dritten Mal."
Print "  Darauf der Wirt: "+Chr$(34)+"Ich gebe Ihnen 10'000 Euro in bar"
Print "  für das Tier."+Chr$(34)+" Der Bauer überlegt nicht lange und"
Print "  willigt zufrieden ein. Er lässt die Sau in der "
Print "  Kneipe und geht mit seinen 10'000 Euro heim. Am"
Print "  nächsten Tag liest der Bauer in der Zeitung die"
Print "  Schlagzeilen: "+Chr$(34)+"Ein betrunkener Gastwirt tritt"
Print "  seine Sau tot!!!"+Chr$(34)
EndIf

If Zufall=22 Then
Print "  "+Chr$(34)+"In diesem Jahr werde ich im Urlaub nichts tun."
Print "  Die erste Woche werde ich mich nur im Schaukelstuhl"
Print "  entspannen."+Chr$(34)+" Ja aber dann?-"+Chr$(34)+"Dann werde ich"
Print "  eventuell ein wenig schaukeln."+Chr$(34)
EndIf

If Zufall=23 Then
Print "  Ein Polizist steht in der Küche und versucht eine"
Print "  Fischbüchse zu öffnen. Erst reisst er die Lasche ab,"
Print "  dann zerbeult er mit dem Büchsenöffner die "
Print "  Seitenwand. Dann verbeult er den Deckel. Schliesslich"
Print "  nimmt der Polizist seinen Gummiknüppel, haut mehrfach"
Print "  auf die Büchse und schreit: "+Chr$(34)+"Aufmachen, Polizei!"+Chr$(34)
EndIf

If Zufall=24 Then
Print "  Wegen zu geringer Bildung sollen Leute mit"
Print "  Fremdsprachenkenntnis als Polizisten angeworben"
Print "  werden. Es melden sich auch welche: Prüfer:"
Print "  "+Chr$(34)+"Do you speak English?"+Chr$(34)+" 1.Bewerber:"+Chr$(34)+"Äh?"+Chr$(34)+" Durchgefallen."
Print "  Prüfer: "+Chr$(34)+"Do you speak English?"+Chr$(34)+" 2.Bewerber:"+Chr$(34)+"Äh?"+Chr$(34)
Print "  "+Chr$(34)+"Durchgefallen."+Chr$(34)+" Prüfer: "+Chr$(34)+"Do you speak English?"+Chr$(34)
Print "  3. Bewerber: "+Chr$(34)+"Oh yes, I do."+Chr$(34)+" Prüfer: "+Chr$(34)+"Äh?"+Chr$(34)
EndIf

If Zufall=25 Then
Print "  Der arbeitslose Maurer muss zur Stellenvermittlung"
Print "  Der Beamte: "+Chr$(34)+"Jetzt habe ich Ihnen schon sieben"
Print "  Baustellen vermittelt, und bei keiner haben Sie"
Print "  angefangen!"+Chr$(34)+" Der Maurer verzweifelt: "+Chr$(34)+"Was soll ich"
Print "  denn machen? Da stand jedesmal auf einem Schild-"
Print "  Baustelle betreten verboten!"+Chr$(34)+""
EndIf

If Zufall=26 Then
Print "  Zwei Polizisten auf Streife kommen an dem Haus vorbei,"
Print "  in dem einer von ihnen wohnt. Da zeigt dieser nach oben"
Print "  und meint: "+Chr$(34)+"Da oben wohne ich. Das auf dem Balkon ist"
Print "  meine Frau und der Mann daneben - das bin ich"+Chr$(34)
EndIf


If Zufall=27 Then
Print "  Schon über eine halbe Stunde verfolgt der Polizist"
Print "  den Dieb. Endlich kann der Dieb nicht mehr und "
Print "  lässt sich auf eine Bank fallen. Schnaufend "
Print "  stoppt der Polizist und setzt sich ebenfalls."
Print "  Nach einer Weile schaut der Dieb zum Polizisten "
Print "  hinüber: "+Chr$(34)+"Na, packen wir es wieder?"+Chr$(34)
EndIf

If Zufall=28 Then
Print "  Schimpft der Polizist mit dem Passanten:"
Print "  "+Chr$(34)+"Sie dürfen doch nicht bei Rot über die Strasse gehen."
Print "  Sind Sie denn von Sinnen?"+Chr$(34)+""
Print "  "+Chr$(34)+"Nein"+Chr$(34)+", Herr Polizist, "+Chr$(34)+"von Zürich!"+Chr$(34)
EndIf

If Zufall=29 Then
Print "  Der Richter vorwurfsvoll zum Angeklagten:"
Print "  Sie haben in dem Hotel Handtücher geklaut."
Print "  Wissen Sie, was darauf steht?"
Print "  Natürlich: "+Chr$(34)+"Hotel zum Bären"+Chr$(34)
EndIf

If Zufall=30 Then
Print "  Der Polizist zum Autofahrer:"
Print "  "+Chr$(34)+"Was fällt Ihnen ein, in der Stadt"
Print "  70 Kilometer in der Stunde zu fahren?"+Chr$(34)
Print "  "+Chr$(34)+"Unmöglich, ich Bin ja erst zehn Minuten unterwegs!"+Chr$(34)
EndIf


Input()
Cls
Locate 1,10
FlushKeys
FlushMouse
Witze=Witze+1
NZDGW(Witze)=Zufall
Until Witze = 10
;Spielstandsicherung
FlushKeys
FlushMouse
Protokoll$="Witze" SpielstandS
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=9
FlushKeys
FlushMouse
Goto Programmstart
End




.Aufgabe10
PauseChannel HGM
ClsVB
Fa=0
Art=0
ARichtig=0
Schrift = LoadFont ("Arial",45,20100)
SetFont Schrift
FlushKeys
FlushMouse
Color 255,0,0
Print "Beschrieb"
Schrift = LoadFont ("Arial",24)
SetFont Schrift
Print "Bei dieser Aufgabe muss man den Artikel anklicken der"
Print "zum oben stehenden Nomen passt."
Print "Bei dieser Aufgabe musst du mindestens 17 von 20 richtig"
Print "haben, sonst kommst du wieder zum Spiel oder zur Übersicht."
Input()
Restore Woerter2A
 ;Einleseschlaufe für 50 Wörter
      Const MaxsA = 49
Dim Wort$(MaxsA)

            

.Woerter2A
Data "Akte (Schriftstück)","Ameise","Angel","Band (Buch)","Bank (Sitzgelegenheit)"
Data "Bank (Geldinstitut)","Beere","Bleistift","Bund (Hosenbund)","Butter"
Data "Ecke","Efeu","Ekel (Abscheu)","Dschungel","Fahne","Ferse","Floh"
Data "Flur (Korridor)","Gefallen (Gefälligkeit)","Giraffe","Griess","Kaffee"
Data "Käfig","Kamin","Kartoffel","Kino","Koffer","Kunde (Käufer)","Lüge"
Data "Socke","Spital","Spitze","Wespe","Zehe"
Data "Mais","Mark (Knochengewebe)","Messer (Schneidgerät)","Moment (Augenblick)"
Data "Reis (Nahrungsmittel)","Sand","Schild (Erkennungszeichen)"
Data "Stift (Bleistift; Lehrling)","Tee","Tor","Tunnel","Lied","Quelle","Glas"
Data "Zug (Eisenbahn)","Schlaf","Katze"


For i = 0 To MaxsA
  ;
Read Wort$(i)
Next

Repeat
Cls
; Zufallsschlaufe 
    SeedRnd MilliSecs() 
    Zufall$ = Wort$(Rand(0,MaxsA))

;EndIf
;Spielstandsicherung


Cls
Locate 1,1
HGrundH= LoadImage (".\Bilder\Gletscher.jpg")
ArtikelK1=LoadImage (".\Bilder\ArtikelK1.jpg")
ArtikelK2=LoadImage (".\Bilder\ArtikelK2.jpg")
ArtikelK3=LoadImage (".\Bilder\ArtikelK3.jpg")
ArtikelK1O=LoadImage (".\Bilder\ArtikelK1O.jpg")
ArtikelK2O=LoadImage (".\Bilder\ArtikelK2O.jpg")
ArtikelK3O=LoadImage (".\Bilder\ArtikelK3O.jpg")
MaskImage ArtikelK1,255,0,0
MaskImage ArtikelK2,255,0,0
MaskImage ArtikelK3,255,0,0
MaskImage ArtikelK1O,255,0,0
MaskImage ArtikelK2O,255,0,0
MaskImage ArtikelK3O,255,0,0
SetBuffer BackBuffer ()


gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 1,1,1


hotX=440
hotY=100
hotW=400
hotH=108

hotX1=440
hotY1=208
hotW1=400
hotH1=108

hotX2=440
hotY2=316
hotW2=400
hotH2=108

Schrift = LoadFont ("Arial",90,20100)
SetFont Schrift



Repeat
ARTMG=0
circleX=MouseX()
circleY=MouseY()
Flip
Cls
DrawImage HGrundH, 1,0
Text 640,1,Zufall$,1
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Then DrawImage ArtikelK1O,440,100 ARTMG=1 ArtikelK=1 Else DrawImage ArtikelK1,440,100
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Then DrawImage ArtikelK2O,440,208 ARTMG=1 ArtikelK=2 Else DrawImage ArtikelK2,440,208
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX2,hotY2,hotW2,hotH2) Then DrawImage ArtikelK3O,440,316 ARTMG=1 ArtikelK=3 Else DrawImage ArtikelK3,440,316
DrawImage gfxCircle,circleX,circleY
Until MouseDown(1) And ARTMG=1

PPE=0
ArtikelVRichtig=0
If Zufall$="Akte (Schriftstück)" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1
If Zufall$="Ameise" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Angel" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Band (Buch)" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Bank (Sitzgelegenheit)" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Bank (Geldinstitut)" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1
If Zufall$="Beere" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Bleistift" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Bund (Hosenbund)" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Butter" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Ecke" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Efeu" And ArtikelK=3 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Ekel (Abscheu)" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Dschungel" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Fahne" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Ferse" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Floh" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Flur (Korridor)" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Gefallen (Gefälligkeit)" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Giraffe" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Griess" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Kaffee" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1
If Zufall$="Käfig" And ArtikelK=3 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Kamin" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Kartoffel" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Kino" And ArtikelK=3 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Koffer" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Kunde (Käufer)" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Lüge" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Socke" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Spital" And ArtikelK=3 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Spitze" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Wespe" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Zehe" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Mais" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Mark (Knochengewebe)" And ArtikelK=3 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Messer (Schneidgerät)" And ArtikelK=3 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Moment (Augenblick)" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Reis (Nahrungsmittel)" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Sand" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Schild Erkennungszeichen" And ArtikelK=3 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Stift (Bleistift; Lehrling)" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Tee" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Tor" And ArtikelK=3 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Tunnel" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Lied" And ArtikelK=3 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Quelle" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Glas" And ArtikelK=3 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Zug (Eisenbahn)" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Schlaf" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Katze" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1

RFT = CreateImage (1280,1024)
SetBuffer ImageBuffer (RFT)
CopyRect 0,0,1280,1024,0,0,FrontBuffer(),ImageBuffer(RFT)
SetBuffer FrontBuffer()
CLSVB
DrawImage RFT,0,0
If ArtikelVRichtig=1 Then AR=1 Text 640,430,"Richtig",1 ARichtig=ARichtig+1 Else AR=0 Text 640,430,"Falsch",1
Delay 1000
Art=Art+1
Until Art=20

Protokoll$="Artikel" SpielstandS
Protokoll$="Punkte: "+ARichtig+"/20" SpielstandS
If Fa=4 Or Fa>4 And UebersichtA=1 Then Goto Uebersicht3
If Fa=4 Or Fa>4 Then Goto Aufgabe10
FlushKeys
FlushMouse
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=10
Smeili=1
FlushKeys
FlushMouse
Goto Programmstart
End







.Aufgabe11
VSJBL=0
Versuche=0
ClsVB
Schrift = LoadFont ("Arial",30,201)
SetFont Schrift
HGrundH=LoadImage (".\Bilder\Zugersee.jpg")
DrawImage HGrundH, 0,0
SeedRnd MilliSecs() 
If Schwierigkeitsstufe=1 Then ZufallZZ = Rand (1,100)
If Schwierigkeitsstufe=2 Then ZufallZZ = Rand (1,1000)
If Schwierigkeitsstufe=4 Then ZufallZZ = Rand (1,10000)
Versuche = 0
If Schwierigkeitsstufe=1 Then Print "Ich denke mir eine Zahl zwischen 1 und 100, errate sie!"
If Schwierigkeitsstufe=1 Then Print "Das Ziel ist, die Zahl in 10 Versuchen herauszufinden."
If Schwierigkeitsstufe=2 Then Print "Ich denke mir eine Zahl zwischen 1 und 100, errate sie!"
If Schwierigkeitsstufe=2 Then Print "Das Ziel ist, die Zahl in 10 Versuchen herauszufinden."
If Schwierigkeitsstufe=3 Then Print "Ich denke mir eine Zahl zwischen 1 und 1000, errate sie!"
If Schwierigkeitsstufe=3 Then Print "Das Ziel ist, die Zahl in 15 Versuchen herauszufinden."
If Schwierigkeitsstufe=4 Then Print "Ich denke mir eine Zahl zwischen 1 und 10000, errate sie!"
If Schwierigkeitsstufe=4 Then Print "Das Ziel ist, die Zahl in 20 Versuchen herauszufinden."
Print ""
Print "Wenn du die Zahl einfach nicht herausfindest,"
Print "dann kommst du mit Enter wieder zum Spiel oder zur Übersicht."
Print ""
Print "Viel Glück!"
Input()
StartZeit = MilliSecs()
Cls
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Repeat
Zahl=0
  Zahl = Input("Rate mal: ")
  Versuche = Versuche + 1
  If Zahl < ZufallZZ Then Print "Zu klein!"
  If Zahl > ZufallZZ Then Print "Zu gross!"
VSJBL=VSJBL+1
If VSJBL=16 Then
VSJBL=0
Delay 500
Cls
Locate 1,1
DrawImage HGrundH, 0,0
EndIf

Until Zahl = ZufallZZ




Cls
Locate 1,1
DrawImage HGrundH, 0,0
Print "Richtig!"
Print "Du hast " + Versuche + " Mal geraten."
Protokoll$="Zahlen erraten" SpielstandS
Protokoll$="Versuche: "+Versuche SpielstandS
Gosub PZeit
If Versuche=10 Or Versuche<10 And Schwierigkeitsstufe=1 Then Print "Herzlichen Glückwunsch, du hast das Ziel erreicht!"
If Versuche>10 And Schwierigkeitsstufe=1 Then Print "Du hast das Ziel nicht erreicht, versuche die Aufgabe später nochmals."
If Versuche>10 And Schwierigkeitsstufe=1 Then Input()
If Versuche=10 Or Versuche<10 And Schwierigkeitsstufe=2 Then Print "Herzlichen Glückwunsch, du hast das Ziel erreicht!"
If Versuche>10 And Schwierigkeitsstufe=1 Then Print "Du hast das Ziel nicht erreicht, versuche die Aufgabe später nochmals."
If Versuche>10 And Schwierigkeitsstufe=1 Then Input()
If Versuche=15 Or Versuche<15 And Schwierigkeitsstufe=3 Then Print "Herzlichen Glückwunsch, du hast das Ziel erreicht!"
If Versuche>15 And Schwierigkeitsstufe=1 Then Print "Du hast das Ziel nicht erreicht, versuche die Aufgabe später nochmals."
If Versuche>15 And Schwierigkeitsstufe=1 Then Input()
If Versuche=20 Or Versuche<20 And Schwierigkeitsstufe=4 Then Print "Herzlichen Glückwunsch, du hast das Ziel erreicht!"
If Versuche>20 And Schwierigkeitsstufe=1 Then Print "Du hast das Ziel nicht erreicht, versuche die Aufgabe später nochmals."
If Versuche>20 And Schwierigkeitsstufe=1 Then Input()
Versuche=0
Zahl=0
Input()
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=11
Smeili=1
FlushKeys
FlushMouse
Goto Programmstart
End
Return







.Aufgabe12
PauseChannel HGM
FehlerD=0
score=0
once=0
bat1=0
bat2=0
ball=0
AAAB=0
TSGESCH=22000
ClsVB
JetztZeit = MilliSecs()
If (JetztZeit-StartZeit > ZeitMaxX) Then Goto Ende
If FileType("Tennis.txt") = 0 Then
fileout = WriteFile("Tennis.txt")
CloseFile fileout
EndIf
Schrift = LoadFont ("Arial",60,True)
SetFont Schrift
FlushKeys
FlushMouse
Color 1,1,1
ClsColor 253,202,13
Cls
Print "Tennis"
Schrift = LoadFont ("Arial",30,True)
SetFont Schrift
Print ""
Print "Mit einem Druck auf Enter erscheint in der Mitte ein Ball und am Rand zwei Balken."
Print "Versuche den Ball immer immwer zwischen diesen zwei Balken hin und her zu spielen."
Print "Bei dieser Aufgabe musst du den Ball mindestens 20 mal mit einem der Balken zurück"
Print "in das Feld spielen."
Print "Wenn du es nicht im ersten Versuch schaffst, ist es auch nicht schlimm, da bei"
Print "jedem Fehlversuch das Spiel von neuem beginnt."
Print ""
Print ""
Print "Viel Spass!"
Input()
Game= LoadSound (".\Sounds\0001Geame.mp3")
LoopSound Game
GameP=PlaySound(Game)
Repeat
Cls
Locate 1,1
Print "Während des Spiels kannst du das Tempo nur mit der Taste +(schneller und -(langsamer) verändern."
Print "Achtung: das Tempo wird erst nach einer gewissen Zeit aktualisiert."
Print ""
TTempo=Input("Tempo (Zahl von 1 (langsam) - 20 (sehr schnell)) ")
Repeat
TTempoFZ=TTempoFZ+1
Until TTempo=TTempoFZ Or TTempoFZ=31
Until Not TTempoFZ=21
ClsVB
SetBuffer BackBuffer()

bat1=LoadImage("Bilder/bat.jpg")
bat2=CopyImage(bat1)
ball=LoadImage("Bilder/ball.jpg")

beep1=LoadSound("Sounds/beep.mp3")
beep2=LoadSound("Sounds/beeplow.mp3")
load=ReadFile("Tennis.txt")
high=ReadLine(load)
font=LoadFont("arial",32)
SetFont font
Color 0,255,0 

; Set initial ball position and movement values
ballx#=width/2
bally#=height/2
ballmovx#=TTempo
ballmovy#=TTempo

; Set initial game values
once=2
score=0

TTempoA=TTempo
; eat following loop until escape key is pressed
Repeat
;#78
;If KeyDown(27)=True Then TTempo=TTempo+1
;If KeyDown(53)=True Then TTempo=TTempo-1
Taste=GetKey ()
If Taste=43 And TTempo<=20 Then TTempo=TTempo+1
If Taste=45 And TTempo>1 Then TTempo=TTempo-1
Cls
Text width/2,0,score,1
Text width/2,height-50,"Rekord gemischt: "+high,1

; Get position of bats
batx1=44
batx2=width-64
baty1=MouseY()
baty2=height-MouseY()-64
Delay 5

; Update ball position values
ballx#=ballx#+ballmovx#
bally#=bally#+ballmovy#
; If ball image collides with either bat image then alter x ball movement value and play beep sound
If once=1 And ImagesCollide(ball,ballx#,bally#,0,bat1,batx1,baty1,0) Then ballmovx#=TTempo : PlaySound beep1 : score=score+1: once=2
If once=2 And ImagesCollide(ball,ballx#,bally#,0,bat2,batx2,baty2,0) Then ballmovx#=TTempo*-1 : PlaySound beep1 : score=score+1: once=1

; If ball touches top or bottom of screen then alter y ball movement value
If bally#>height-16 Then ballmovy#=TTempo*-1 : PlaySound beep2
If bally#<0 Then ballmovy#=TTempo : PlaySound beep2

; If bats touch top or bottom of screen then prevent them from going outside of screen
If baty1<0 Then baty1=0
If baty2<0 Then baty2=0
If baty1>height-64 Then baty1=height-64
If baty2>height-64 Then baty2=height-64

; If ball touches left side of screen then save high score if necessary, reset ball and score values
If ballx#<0
If score>high Then high=score : save=WriteFile("Tennis.txt") : WriteLine save,high : CloseFile save
ballx#=width/2 : bally#=height/2 : ballmovx#=10 : ballmovy#=10 : once=2
If score=>20 And UebersichtA=1 Then
Protokoll$="Tennis"
SpielstandS
Protokoll$="Punkte: "+score
SpielstandS
Protokoll$="Versuche: "+(FehlerD+1)
SpielstandS
Protokoll$="Geschwindigkeit: "+TTempo
SpielstandS
Goto Uebersicht3
EndIf

If score=>20 Then
Protokoll$="Tennis"
SpielstandS
Protokoll$="Punkte: "+score
SpielstandS
Protokoll$="Versuche: "+(FehlerD+1)
SpielstandS
Protokoll$="Geschwindigkeit: "+TTempo
SpielstandS
Aufgaben=Aufgaben+1
Goto Programmstart
EndIf
FehlerD=FehlerD+1
score=0
EndIf

; If ball touches right side of screen then save high score if necessary, reset ball and score values
If ballx#>width-16
If score>high Then high=score : save=WriteFile("Tennis.txt") : WriteLine save,high : CloseFile save
ballx#=width/2 : bally#=height/2 : ballmovx#=TTempo : ballmovy#=TTempo : once=2
If score=>20 And UebersichtA=1 Then
Protokoll$="Tennis"
SpielstandS
Protokoll$="Punkte: "+score
SpielstandS
Protokoll$="Versuche: "+(FehlerD+1)
SpielstandS
Protokoll$="Geschwindigkeit: "+TTempo
SpielstandS
Goto Uebersicht3
EndIf

If score=>20 Then
Protokoll$="Tennis"
SpielstandS
Protokoll$="Punkte: "+score
SpielstandS
Protokoll$="Versuche: "+(FehlerD+1)
SpielstandS
Protokoll$="Geschwindigkeit: "+TTempo
SpielstandS
Aufgaben=Aufgaben+1
Goto Programmstart
EndIf
FehlerD=FehlerD+1
score=0
EndIf

DrawImage bat1,batx1,baty1
DrawImage bat2,batx2,baty2
DrawImage ball,ballx#,bally#

Flip
Forever



.Aufgabe13
PauseChannel HGM

.WSRStart
ClsVB
SYN$=0
i=0
EDVWS=0
WAKY=0
WSR=0
WSF=0
Ziffer=0
ClsColor 253,202,13
Cls
Schrift = LoadFont ("Arial",130,20100)
SetFont Schrift
Color 1,1,1
Locate 200,1
Print "Wortfeld Sagen"
Schrift = LoadFont ("Arial",60,20100)
SetFont Schrift
Color 1,1,1
ClsColor 255,255,255
Print ""
Print "Du hast drei Minuten Zeit, um möglichst viele Wörter"
Print "die mit sagen zu tun haben aufzuschreiben wie"
Print "ZB. antworten."
Print "Diese Übung dient dazu einen Text spannend zu ma-"
Print "chen, indem man nicht immer sagte braucht."
Print ""
Print "Du musst mindestens 15 Wörter schaffen um weiter"
Print "zu kommen!"
Print ""
Print "Viel Glück!"
BildSagen=LoadImage(".\Bilder\Sagen.jpg")
Input()


;Zeit!
StartZeit = MilliSecs()
Const ZeitMax = 180000  ;180 Sekunden


EGWFSY=100
NEGFWFS

Dim WS$(99)
For i=0 To 100
Locate 420,EGWFSY
WS$(i)=Input()
EGWFSY=EGWFSY+55
If EGWFSY>950 Then
NEGFWFS
EGWFSY=100
EndIf
ZeitJetzt = MilliSecs()
If (ZeitJetzt-StartZeit > ZeitMax) Then Goto WortfeldSagenV
Next





Function NEGFWFS()
Cls
TileBlock BildSagen
Schrift = LoadFont ("Arial",70,20100)
SetFont Schrift
Color 1,1,1
Locate 420,1
Print "Wortfeld Sagen"
Schrift = LoadFont ("Arial",50,20100)
SetFont Schrift
End Function


.WortfeldSagenV
ClsVB
HGrundH=LoadImage(".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial",70,201)
SetFont Schrift
Color 1,1,1
Text 640,1,"Wortfeld Sagen",1
Schrift = LoadFont ("Arial",55,201)
SetFont Schrift
Text 640,70,"Liste deiner Wörter",1
Schrift = LoadFont ("Arial",40,201)
SetFont Schrift
Text 640,950,"weiter mit beliebeger Taste",1
Schrift = LoadFont ("Arial",51,201)
SetFont Schrift
WAKX=250
WAKY=150


Repeat

FSWV=0

SYN$=WS$(EDVWS)
If SYN$="flüstern"Or SYN$="zischen"Or SYN$="murmeln"Or SYN$="hauchen"Or SYN$="wispern"Or SYN$="tuscheln"Or SYN$="rufen"Or SYN$="schreien"Or SYN$="brüllen"Or SYN$="kreischen"Or SYN$="krakeelen"Or SYN$="reden"Or SYN$="sagen"Or SYN$="plaudern"Or SYN$="sprechen"Or SYN$="quasseln"Or SYN$="plappern"Or SYN$="schnattern"Or SYN$="bemerken"Or SYN$="andeuten"Or SYN$="meinen"Or SYN$="faseln"Or SYN$="äussern"Or SYN$="schwatzen"Or SYN$="erzählen"Or SYN$="berichten"Or SYN$="erwähnen"Or SYN$="erklären"Or SYN$="beschliessen"Or SYN$="überlegen"Or SYN$="glauben"Or SYN$="schildern"Or SYN$="erläutern"Or SYN$="raten"Or SYN$="reimen"Or SYN$="dichten"Or SYN$="übertreiben"Or SYN$="lügen"Or SYN$="loben"Or SYN$="sich erinnern"Or SYN$="erinnern"Or SYN$="von sich geben"Or SYN$="geben"Or SYN$="prahlen"Or SYN$="wiederholen"Or SYN$="weinen"Or SYN$="schluchzen"Or SYN$="plärren"Or SYN$="seufzen"Or SYN$="stöhnen"Or SYN$="jammern"Or SYN$="klagen"Or SYN$="trösten"Or SYN$="kichern"Or SYN$="fragen"Or SYN$="sich erkundigen"Or SYN$="erkundigen"Or SYN$="antworten"Or SYN$="erwidern"Or SYN$="bejahen"Or SYN$="verneinen"Or SYN$="wiedersprechen"Or SYN$="entgegnen"Or SYN$="behaupten"Or SYN$="zustimmen"Or SYN$="verkünden"Or SYN$="bezeugen"Or SYN$="einwenden"Or SYN$="einwerffen"Or SYN$="unterbrechen"Or SYN$="befehlen"Or SYN$="auffordern"Or SYN$="vorschlagen"Or SYN$="bitten"Or SYN$="betteln"Or SYN$="versichern"Or SYN$="versprechen"Or SYN$="schimpfen"Or SYN$="sich beschweren"Or SYN$="beschweren"Or SYN$="tadeln"Or SYN$="reklamieren"Or SYN$="sich ärgern"Or SYN$="ärgern"Or SYN$="schmollen"Or SYN$="lästern"Or SYN$="drohen"Or SYN$="zurechtweisen"Or SYN$="anschnauzen"Or SYN$="protesteiren"Or SYN$="petzen"Or SYN$="zanken"Or SYN$="fluchen"Or SYN$="stottern"Or SYN$="lallen"Or SYN$="nuscheln"Or SYN$="krächzen"Or SYN$="stammeln"Or SYN$="brummen"Or SYN$="labern"Or SYN$="hervorstossen"Or SYN$="näseln"Then WIEDSML=1 Color 1,255,1 WSR=WSR+1 Else WIEDSML=0 Color 255,1,1FSWV=0

Repeat
If WS$(EDVWS)=WS$(FSWV) And FSWV<>EDVWS And WIEDSML=1 Then WSR=WSR-1 WSG=WES+1 Color 255,155,55
FSWV=FSWV+1
Until FSWV=99
If SYN$="" Then WSG=WES-1 WAKX=WAKX
If WAKY>900 And WAKX=250 Then WAKY=150 WAKX=650
If WAKY>900 And WAKX=650 Then WAKY=150 WAKX=1030
WAKY=WAKY+55
Text WAKX,WAKY,WS$(EDVWS),1
EDVWS=EDVWS+1
Until EDVWS=99

WaitKey()
Cls
HGrundH=LoadImage(".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial",70,101)
SetFont Schrift
Color 1,1,1
Text 640,1,"Wortfeld Sagen",1
Schrift = LoadFont ("Arial",55,101)
SetFont Schrift
Text 640,70,"Liste deiner Wörter",1
Schrift = LoadFont ("Arial",40,101)
SetFont Schrift
Text 640,950,"weiter mit beliebeger Taste",1
Schrift = LoadFont ("Arial",32,101)
SetFont Schrift
Color 0,0,0
WAKX=125
WAKY=150

Restore WoerterLWS

      Const MaxWS = 99
Dim Wort$(MaxWS)

  Delay 500

            

.WoerterLWS


Data "flüstern","zischen","murmeln","hauchen","wispern","tuscheln","rufen","schreien","brüllen","kreischen","krakeelen","reden","sagen","plaudern","sprechen","quasseln","plappern","schnattern","bemerken","andeuten","meinen","faseln","äussern","schwatzen","erzählen","berichten","erwähnen","erklären","beschliessen","überlegen","glauben","schildern","erläutern","raten","reimen","dichten","übertreiben","lügen","loben","sich erinnern","erinnern","von sich geben","geben","prahlen","wiederholen","weinen","schluchzen","plärren","seufzen","stöhnen","jammern","klagen","trösten","kichern","fragen","sich erkundigen","erkundigen","antworten","erwidern","bejahen","verneinen","wiedersprechen","entgegnen","behaupten","zustimmen","verkünden","bezeugen","einwenden","einwerffen","unterbrechen","befehlen","auffordern","vorschlagen","bitten","betteln","versichern","versprechen","schimpfen","sich beschweren","beschweren","tadeln","reklamieren","sich ärgern","ärgern","schmollen","lästern","drohen","zurechtweisen","anschnauzen","protesteiren","petzen","zanken","fluchen","stottern","lallen","nuscheln","krächzen","stammeln","brummen","labern","hervorstossen","näseln"

 

For i = 0 To MaxWS
Read Wort$(i)
Next
Repeat
ZufallO$ = Wort$(Ziffer)
Zufall$=Zufall$+ZufallO$
Ziffer=Ziffer+1
If WAKY>870 And WAKX=125 Then WAKY=150 WAKX=375
If WAKY>870 And WAKX=375 Then WAKY=150 WAKX=625
If WAKY>870 And WAKX=625 Then WAKY=150 WAKX=875
If WAKY>870 And WAKX=875 Then WAKY=150 WAKX=1125
WAKY=WAKY+37
Text WAKX,WAKY,ZufallO$,1
EDVWS=EDVWS+1
Delay 200
Until WAKY>870 And WAKX=1125
WaitKey()

Cls
HGrundH=LoadImage(".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial",70,20100)
SetFont Schrift
Color 1,1,1
Text 640,1,"Wortfeld Sagen",1
Schrift = LoadFont ("Arial",50,20100)
SetFont Schrift
If WSR=0 Or WSR>1 Text 640,80,"Du hast "+WSR+" richtige Wörter zum Wortfeld Sagen",1 Else Text 640,80,"Du hast "+WSR+" richtiges Wort zum Wortfeld Sagen",1
Text 640,130,"in drei Minuten aufgeschrieben!!!",1
If WSR>15 Or WSR=15 Then Text 640,180,"Ziel erreicht!",1
If WSR<15 Then Text 640,180,"Ziel nicht erreicht!",1
If WSR<15 Then Text 640,230,"Versuche die Aufgabe nochmals!",1
Schrift = LoadFont ("Arial",40,201)
SetFont Schrift
Text 640,950,"weiter mit beliebeger Taste",1
Protokoll$="Wortfeld Sagen" SpielstandS
Protokoll$="Punkte: "+WSR SpielstandS
WaitKey()
If WSR<15 Then Goto WSRStart
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=13
Smeili=1
FlushKeys
FlushMouse
Goto Programmstart
End








.Aufgabe14
ClsVB
PauseChannel HGM
Game= LoadSound (".\Sounds\0001Geame.mp3")
LoopSound Game
GameP=PlaySound(Game)
HGrundH=LoadImage (".\Bilder\Zugersee.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,70)
SchriftL = LoadFont ("Arial", 50,70)
SetFont Schrift
Color 0,0,0
Locate 1,1
Richtig = 0
Print "Das Schweizer Lotto"
Print "Spielregeln"
Print "Schreibe 6 Zahlen von 1 bis 42 auf. Keine kommt 2 mal vor.
Print "Schreibe bitte immner nur eine Zahl auf einer Linie (dann Enter + nächste Zahl).
FlushKeys
FlushMouse
Input()
Goto Lotoschein
End
.Lotoschein
ClsColor 0,0,0
SetFont SchriftL
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
Richtig = 0
DrawImage HGrundH, 0,0
Color 0,0,0
Locate 1,1
ZahlE1= Input()
ZahlE2= Input()
ZahlE3= Input()
ZahlE4= Input()
ZahlE5= Input()
ZahlE6= Input()

If ZahlE2=ZahlE1 Then Goto Fehler3
If ZahlE3=ZahlE1 Then Goto Fehler3
If ZahlE3=ZahlE2 Then Goto Fehler3
If ZahlE4=ZahlE1 Then Goto Fehler3
If ZahlE4=ZahlE2 Then Goto Fehler3
If ZahlE4=ZahlE3 Then Goto Fehler3
If ZahlE5=ZahlE1 Then Goto Fehler3
If ZahlE5=ZahlE2 Then Goto Fehler3
If ZahlE5=ZahlE3 Then Goto Fehler3
If ZahlE5=ZahlE4 Then Goto Fehler3
If ZahlE6=ZahlE1 Then Goto Fehler3
If ZahlE6=ZahlE2 Then Goto Fehler3
If ZahlE6=ZahlE3 Then Goto Fehler3
If ZahlE6=ZahlE4 Then Goto Fehler3
If ZahlE6=ZahlE5 Then Goto Fehler3

Goto Start
End
.Start
SeedRnd MilliSecs()
Zahl1= Rand(1,42)
Zahl2= Rand(1,42)
Zahl3= Rand(1,42)
Zahl4= Rand(1,42)
Zahl5= Rand(1,42)
Zahl6= Rand(1,42)
If Zahl1=Zahl2 Then Goto Start
If Zahl1=Zahl3 Then Goto Start
If Zahl1=Zahl4 Then Goto Start
If Zahl1=Zahl5 Then Goto Start
If Zahl1=Zahl6 Then Goto Start
If Zahl2=Zahl1 Then Goto Start
If Zahl2=Zahl3 Then Goto Start
If Zahl2=Zahl4 Then Goto Start
If Zahl2=Zahl5 Then Goto Start
If Zahl2=Zahl6 Then Goto Start
If Zahl3=Zahl1 Then Goto Start
If Zahl3=Zahl2 Then Goto Start
If Zahl3=Zahl4 Then Goto Start
If Zahl3=Zahl5 Then Goto Start
If Zahl3=Zahl6 Then Goto Start
If Zahl4=Zahl1 Then Goto Start
If Zahl4=Zahl2 Then Goto Start
If Zahl4=Zahl3 Then Goto Start
If Zahl4=Zahl5 Then Goto Start
If Zahl4=Zahl6 Then Goto Start
If Zahl5=Zahl1 Then Goto Start
If Zahl5=Zahl2 Then Goto Start
If Zahl5=Zahl3 Then Goto Start
If Zahl5=Zahl4 Then Goto Start
If Zahl5=Zahl6 Then Goto Start
If Zahl6=Zahl1 Then Goto Start
If Zahl6=Zahl2 Then Goto Start
If Zahl6=Zahl3 Then Goto Start
If Zahl6=Zahl4 Then Goto Start
If Zahl6=Zahl5 Then Goto Start
Text 100,1,Zahl1
Text 100,50,Zahl2
Text 100,100,Zahl3
Text 100,150,Zahl4
Text 100,200,Zahl5
Text 100,250,Zahl6
Print ""
If ZahlE1=Zahl1 Then Richtig=Richtig+1
If ZahlE1=Zahl2 Then Richtig=Richtig+1
If ZahlE1=Zahl3 Then Richtig=Richtig+1
If ZahlE1=Zahl4 Then Richtig=Richtig+1
If ZahlE1=Zahl5 Then Richtig=Richtig+1
If ZahlE1=Zahl6 Then Richtig=Richtig+1
If ZahlE2=Zahl1 Then Richtig=Richtig+1
If ZahlE2=Zahl2 Then Richtig=Richtig+1
If ZahlE2=Zahl3 Then Richtig=Richtig+1
If ZahlE2=Zahl4 Then Richtig=Richtig+1
If ZahlE2=Zahl5 Then Richtig=Richtig+1
If ZahlE2=Zahl6 Then Richtig=Richtig+1
If ZahlE3=Zahl1 Then Richtig=Richtig+1
If ZahlE3=Zahl2 Then Richtig=Richtig+1
If ZahlE3=Zahl3 Then Richtig=Richtig+1
If ZahlE3=Zahl4 Then Richtig=Richtig+1
If ZahlE3=Zahl5 Then Richtig=Richtig+1
If ZahlE3=Zahl6 Then Richtig=Richtig+1
If ZahlE4=Zahl1 Then Richtig=Richtig+1
If ZahlE4=Zahl2 Then Richtig=Richtig+1
If ZahlE4=Zahl3 Then Richtig=Richtig+1
If ZahlE4=Zahl4 Then Richtig=Richtig+1
If ZahlE4=Zahl5 Then Richtig=Richtig+1
If ZahlE4=Zahl6 Then Richtig=Richtig+1
If ZahlE5=Zahl1 Then Richtig=Richtig+1
If ZahlE5=Zahl2 Then Richtig=Richtig+1
If ZahlE5=Zahl3 Then Richtig=Richtig+1
If ZahlE5=Zahl4 Then Richtig=Richtig+1
If ZahlE5=Zahl5 Then Richtig=Richtig+1
If ZahlE5=Zahl6 Then Richtig=Richtig+1
If ZahlE6=Zahl1 Then Richtig=Richtig+1
If ZahlE6=Zahl2 Then Richtig=Richtig+1
If ZahlE6=Zahl3 Then Richtig=Richtig+1
If ZahlE6=Zahl4 Then Richtig=Richtig+1
If ZahlE6=Zahl5 Then Richtig=Richtig+1
If ZahlE6=Zahl6 Then Richtig=Richtig+1
Protokoll$="Lotto" SpielstandS
If Richtig=0 Then Print "Du hast 5 Fr. verloren!" Protokoll$="5 Fr. verloren" SpielstandS
If Richtig=1 Then Print "Du hast 0 Fr. gewonnen!" Protokoll$="0 Fr. gewonnen" SpielstandS
If Richtig=2 Then Print "Du hast 10 Fr. gewonnen!" Protokoll$="10 Fr. gewonnen" SpielstandS
If Richtig=3 Then Print "Du hast 50 Fr. gewonnen!" Protokoll$="50 Fr. gewonnen" SpielstandS
If Richtig=4 Then Print "Du hast 5000 Fr. gewonnen!" Protokoll$="500 Fr. gewonnen" SpielstandS
If Richtig=5 Then Print "Du hast 100'000 Fr. gewonnen!" Protokoll$="100'000 Fr. gewonnen" SpielstandS
If Richtig=6 Then Print "Du hast 1'000'000 Fr. gewonnen!" Protokoll$="1'000'000 Fr. gewonnen" SpielstandS
Input()
NNWA=1
WarnungF$="Wilst du nochmals Lotto speilen?"
WarnungA
NNWA=0
If JaO=1 Then Goto Lotoschein
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=14
Smeili=1
FlushKeys
FlushMouse
Goto Programmstart
End

.Fehler3
Print "Schreibe bitte nie 2 gleiche Zahlen auf den Lottoschein !!!"
Delay 1000
FlushKeys
FlushMouse
Goto Lotoschein
End









.Aufgabe15
PauseChannel HGM
WMP#=0
AWM=0
WMAZZWL=0
SeedRnd MilliSecs()
ClsVB
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial",55,101)
SetFont Schrift
Color 0,0,0
Print "Wörter merken"
Print ""
Schrift = LoadFont ("Arial",42,101)
SetFont Schrift
Print "Mit enem Druck auf Enter erscheinen 20 Wörter."
Print "Merke dir so viele wie möglich."
Print "jedes Wort in der richtigen Reihenfolge ergibt 1 Punkt,"
Print "jedes Wort in der falschen Reihenfolge einen halben Punkt"
Print "und jedes falsche Wort 0 Punkte."
Print "Um das Ziel zu erreichen, musst du mindestens 10 von 20 Punkten haben."
Print ""
Print "Viel Glück!"
Input()
StartZeit = MilliSecs()
Restore WoerterWM
 ;Einleseschlaufe für 140 Wörter
      Const MaxWM = 125
Dim Wort$(MaxWM)

Color 255,255,255
            

.WoerterWM

Data "Kerze","Vase","Computer","Batterie","Kaktus","Stein","Kugel","Puzzle","Lautsprecher","Lampe","Sand","Glas","Teller","Kabel","Stecker","Bleistift","Kugelschreiber","Farbstift"
Data "Taschentuch","Lineal","Gummi","Salat","Engel","Hose","Socken","Bett","Poster","Heft","Buch","Schere","CD","Klebeband","Licht","Fenster","Keller","Spiegel"
Data "Schokolade","Leim","Xylophon","Pflanze","Webcam","Lego","Murmel","Stachel","Memorystick","Witz","Uhr","Draht","Harfe","Gitarre","Klavier","Bad","Dusche","Topf"
Data "Strom","Paris","Foto","Heizung","Schere","Geld","Münzen","Holz","Muschel","Telefon","Brille","Film","Kamera","Floss","Arm","Gürtel","Tasche","Kind"
Data "Pizza","Schachtel","Schlauch","Karton","Wäsche","Ton","Zimmer","Haus","Türe","Klingel","Velo","Auto","Kompost","Garten","Rose","Stuhl","Kiste","Auge"
Data "Zahn","Maus","Katze","Hund","Postkarte","Brief","Seil","Knoten","Turm","Pisa","Griff","Abfall","Hand","Taschenrechner","Gehirn","Schule","Löffel","Käfer"
Data "Spinne","Bildschirm","Würfel","Vogel","Eule","Hufeisen","Kopfhörer","Treppe","Wand","See","Meer","Figur","Stab","Name","Planet","Erde","Sofa","Möbel"
For i = 0 To MaxWM
  ;
Read Wort$(i)
Next


DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial",55,101)
SetFont Schrift
Color 0,0,0
WMAZZWL=0
Text 640,10,"Wörter merken",1
Schrift = LoadFont ("Arial",42,101)
SetFont Schrift

Repeat
WMAZZWL=WMAZZWL+1
WMZM$(WMAZZWL)=Wort$(Rand (0,125))
Text 640,WMAZZWL*42+50,WMZM$(WMAZZWL),1
Until WMAZZWL=20
Text 640,950,"Weiter mit beliebiger Taste",1
WaitKey
Cls
Locate 1,1
DrawImage HGrundH, 0,0
AWM=0
Repeat
AWM=AWM+1
QWM$(AWM)=Input()
Until AWM=20
AWM=0
Cls
Locate 1,1
DrawImage HGrundH, 0,0


Schrift = LoadFont ("Arial",55,101)
SetFont Schrift
Text 640,10,"Korrigierte Wörter",1
Schrift = LoadFont ("Arial",30,101)
SetFont Schrift
Text 640,70,"(grün richtig, orange richtig aber an falscher Stelle, rot Falsch)",1
Schrift = LoadFont ("Arial",30,101)
SetFont Schrift
Text 640,970,"Weiter mit beliebiger Taste",1
Schrift = LoadFont ("Arial",42,101)
SetFont Schrift
Repeat
BSCHTWM=0
fgaijk=0
fjkfbuaedkl=0
rvmbfthjbn=0
Color 255,0,0
AWM=AWM+1
rvmbfthjbn=0
Repeat
fgaijk=fgaijk+1
If QWM(AWM)=NBIMWM$(fgaijk) Then BSCHTWM=1
Until fgaijk=20
If QWM$(AWM)=WMZM$(AWM) And BSCHTWM=0 Then
Color 0,255,0
WMEVR=2
Else
Repeat
rvmbfthjbn=rvmbfthjbn+1
If QWM(AWM)=WMZM(rvmbfthjbn) Then fjkfbuaedkl=1
Until rvmbfthjbn=20



If fjkfbuaedkl=1 Then
If BSCHTWM=0 Then Color 255,155,50 WMEVR=1 Else Color 255,0,0 WMEVR=0

Else
Color 255,0,0
WMEVR=0
EndIf
EndIf
NBIMWM$(AWM)=QWM(AWM)
Text 640,AWM*42+70,QWM(AWM),1
If WMEVR=1 Then WMP#=WMP#+0.5
If WMEVR=2 Then WMP#=WMP#+1
Color 255,0,0
Until AWM=20
WaitKey
Cls
Locate 1,1
DrawImage HGrundH, 0,0


Schrift = LoadFont ("Arial",50,101)
SetFont Schrift
Color 0,0,0
Text 640,487,"Du hast "+WMP#+" von 20 Punkten erreicht!",1,1
If WMP#<10 Then Text 640,537,"Ziel nicht erreicht!",1,1
If WMP#>=10 And WMP#<15 Then Text 640,537,"Ziel erreicht!",1,1
If WMP#>=15 And WMP#<18 Then Text 640,537,"Ziel gut erreicht!",1,1
If WMP#>=18 Then Text 640,537,"Ziel sehr gut erreicht!",1,1
Schrift = LoadFont ("Arial",30,101)
SetFont Schrift
Text 640,970,"Weiter mit beliebiger Taste",1
Protokoll$="Wörter merken" SpielstandS
Protokoll$="Punkte: "+WMP#+"/20" SpielstandS
Gosub PZeit
WaitKey
If WMP#=>10 And UebersichtA=1 Then Goto Uebersicht3
If WMP#=>10 Then Aufgaben=Aufgaben+1 Goto Programmstart
Goto Aufgabe15
End








.Aufgabe16
FY=0
FX=0
G=1
SFGG=0
ClsVB
G=8
GZSFG
If hfdujkhbgjgjuvkhuj16=0 Then
PauseChannel HGM
ClsVB

SFRXP(1) = CreateImage (18*SFG#,32*SFG#)
SetBuffer ImageBuffer (SFRXP(1))
DrawImageRect SF(g), 0,0, 0*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
SetBuffer FrontBuffer()
SFRXP(2) = CreateImage (22*SFG#,32*SFG#)
SetBuffer ImageBuffer (SFRXP(2))
DrawImageRect SF(g), 0,0, 19*SFG#,32*SFG#, 22*SFG#, 32*SFG#
SetBuffer FrontBuffer()
SFRXP(3) = CreateImage (22*SFG#,32*SFG#)
SetBuffer ImageBuffer (SFRXP(3))
DrawImageRect SF(g), FX, FY, 41*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
SetBuffer FrontBuffer()
SFRXP(4) = CreateImage (19*SFG#,32*SFG#)
SetBuffer ImageBuffer (SFRXP(4))
DrawImageRect SF(g), 0,0, 60*SFG#, 32*SFG#, 19*SFG#, 32*SFG#
SetBuffer FrontBuffer()


SFRXM(1) = CreateImage (19*SFG#,32*SFG#)
SetBuffer ImageBuffer (SFRXM(1))
DrawImageRect SF(g), 0,0, 0*SFG#, 0*SFG#, 19*SFG#, 32*SFG#
SetBuffer FrontBuffer()
SFRXM(2) = CreateImage (22*SFG#,32*SFG#)
SetBuffer ImageBuffer (SFRXM(2))
DrawImageRect SF(g), FX, FY, 19*SFG#,0*SFG#, 22*SFG#, 32*SFG#
SetBuffer FrontBuffer()
SFRXM(3) = CreateImage (19*SFG#,32*SFG#)
SetBuffer ImageBuffer (SFRXM(3))
DrawImageRect SF(g), 0,0, 41*SFG#, 0*SFG#, 19*SFG#, 32*SFG#
SetBuffer FrontBuffer()
SFRXM(4) = CreateImage (22*SFG#,32*SFG#)
SetBuffer ImageBuffer (SFRXM(4))
DrawImageRect SF(g), 0,0, 60*SFG#, 0*SFG#, 22*SFG#, 32*SFG#
SetBuffer FrontBuffer()


rocket=SFRXP(1)

Schrift = LoadFont ("Arial",90,20100)
SetFont Schrift
Color 0,0,0
ClsColor 253,202,13
Cls
Print "Beschrieb"
Schrift = LoadFont ("Arial",50,20100)
SetFont Schrift
Print ""
Print "Nach einem Klick auf Enter erscheinem viele
Print "hinabfallende Zahlen."
Print "Wenn deine Spielfigur eine der Zahlen
Print "berührt, dann wird sie bei der nächsten"
Print "Ziffer der Rechnung eingetragen."
Print "das Ziel ist, so eine Rechnumg mit dem korrekten"
Print "Resultat zu erstellen."
Print "Achtung! Du hast für eine Rechnung nur solange Zeit bis"
Print "deine Spielfigur am unteren Bildrand ankommt."
Print "Es sind 7 Aufgaben richtig zu lösen."
Print ""
Print "Viel Glück!"
StartZeit = MilliSecs()
Input()
StartZeitP = MilliSecs()
hfdujkhbgjgjuvkhuj16=1
hfdujkhbgjgjuvkhuj161=1
EndIf

If RichtigA16=7 Then
RichtigA16=0
SFSCHNR=1
SteinKoY=0
SteinKoX=0
SteinAnz=0
B1=0
B2=0
B3=0
B4=0
B5=0
B6=0
B7=0
B8=0
B9=0
Fehler16SS(0)=0
Fehler16SS(1)=0
Fehler16SS(2)=0
Fehler16SS(3)=0
Fehler16SS(4)=0
Fehler16SS(5)=0
Fehler16SS(6)=0
Fehler16SS(7)=0
Fehler16SS(8)=0
GetroffenS(0)=0
GetroffenS(1)=0
GetroffenS(2)=0
GetroffenS(3)=0
GetroffenS(4)=0
GetroffenS(5)=0
GetroffenS(6)=0
A14Z(0)=0
A14Z(1)=0
A14Z(2)=0
A14Z(3)=0
A14Z(4)=0
A14Z(5)=0
A14Z(6)=0
HGrundH=0
kgbvhknvgknjmkmh=0
hnjugbjbhujmbg16=0
NulP16=0
hfdujkhbgjgjuvkhuj16=0
Protokoll$="Rechenspiel" SpielstandS
StartZeit=StartZeitP
Gosub PZeit
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=16
Smeili=0
Goto Programmstart
EndIf
SFSCHNR=1
SteinKoY=0
SteinKoX=0
SteinAnz=0
Fehler16SS(0)=0
Fehler16SS(1)=0
Fehler16SS(2)=0
Fehler16SS(3)=0
Fehler16SS(4)=0
Fehler16SS(5)=0
Fehler16SS(6)=0
Fehler16SS(7)=0
Fehler16SS(8)=0
GetroffenS(0)=0
GetroffenS(1)=0
GetroffenS(2)=0
GetroffenS(3)=0
GetroffenS(4)=0
GetroffenS(5)=0
GetroffenS(6)=0
A14Z(0)=0
A14Z(1)=0
A14Z(2)=0
A14Z(3)=0
A14Z(4)=0
A14Z(5)=0
A14Z(6)=0
SteinKoY=100
SteinKoX=400
SteinAnz=0
B1=0
B2=0
B3=0
B4=0
B5=0
B6=0
B7=0
B8=0
B9=0
HGrundH=0
kgbvhknvgknjmkmh=100
hnjugbjbhujmbg16=9
NulP16=0
PauseChannel MXP
Cls
Locate 1,1
ClsVB
Schrift = LoadFont ("Arial",90,20100)
SetFont Schrift
Color 255,255,155
B1= LoadImage (".\Bilder\1.bmp")
B2= LoadImage (".\Bilder\2.bmp")
B3= LoadImage (".\Bilder\3.bmp")
B4= LoadImage (".\Bilder\4.bmp")
B5= LoadImage (".\Bilder\5.bmp")
B6= LoadImage (".\Bilder\6.bmp")
B7= LoadImage (".\Bilder\7.bmp")
B8= LoadImage (".\Bilder\8.bmp")
B9= LoadImage (".\Bilder\9.bmp")

Bild1=LoadImage (".\Bilder\Teil16.jpg")
SetBuffer BackBuffer ()
x = 0
y = 169
ClsColor 1,1,1
HGrundH=Bild1


SteinKoY=100
SteinKoX=400
SteinAnz=0
SteinK(0)=B1
SteinK(1)=B1
SteinK(2)=B1
SteinK(3)=B1
SteinK(4)=B1
SteinK(5)=B1
SteinK(6)=B1
SteinK(7)=B1
SteinK(8)=B1



.Aufgabe16A
hnjugbjbhujmbg16=hnjugbjbhujmbg16-1
If hnjugbjbhujmbg16=0 Then hnjugbjbhujmbg16=10 NulP16=NulP16+1
If NulP16=800 Then
Cls
Locate 1,1
Print "Zu langsam"
Delay 2000
FalschA16=FalschA16+1
Goto Aufgabe16
EndIf
Origin 0,NulP16


For i=0 To 6
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=1 And A14Z(0)=0 And Fehler16SS(0)=0 Then Fehler16SS(0)=1 hgjkhkgkh=1 A14Z(0)=1
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=2 And A14Z(0)=0 And Fehler16SS(0)=0 Then Fehler16SS(0)=1 hgjkhkgkh=1 A14Z(0)=2
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=3 And A14Z(0)=0 And Fehler16SS(0)=0 Then Fehler16SS(0)=1 hgjkhkgkh=1 A14Z(0)=3
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=4 And A14Z(0)=0 And Fehler16SS(0)=0 Then Fehler16SS(0)=1 hgjkhkgkh=1 A14Z(0)=4
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=5 And A14Z(0)=0 And Fehler16SS(0)=0 Then Fehler16SS(0)=1 hgjkhkgkh=1 A14Z(0)=5
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=6 And A14Z(0)=0 And Fehler16SS(0)=0 Then Fehler16SS(0)=1 hgjkhkgkh=1 A14Z(0)=6
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=7 And A14Z(0)=0 And Fehler16SS(0)=0 Then Fehler16SS(0)=1 hgjkhkgkh=1 A14Z(0)=7
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=8 And A14Z(0)=0 And Fehler16SS(0)=0 Then Fehler16SS(0)=1 hgjkhkgkh=1 A14Z(0)=8
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=9 And A14Z(0)=0 And Fehler16SS(0)=0 Then Fehler16SS(0)=1 hgjkhkgkh=1 A14Z(0)=9
Next

q=0
Repeat
For i=0 To 6
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=1 And A14Z(q)>0 And Fehler16SS(q+1)=0 Then Fehler16SS(q+1)=1 hgjkhkgkh=1 A14Z(q+1)=1
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=2 And A14Z(q)>0 And Fehler16SS(q+1)=0 Then Fehler16SS(q+1)=1 hgjkhkgkh=1 A14Z(q+1)=2
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=3 And A14Z(q)>0 And Fehler16SS(q+1)=0 Then Fehler16SS(q+1)=1 hgjkhkgkh=1 A14Z(q+1)=3
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=4 And A14Z(q)>0 And Fehler16SS(q+1)=0 Then Fehler16SS(q+1)=1 hgjkhkgkh=1 A14Z(q+1)=4
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=5 And A14Z(q)>0 And Fehler16SS(q+1)=0 Then Fehler16SS(q+1)=1 hgjkhkgkh=1 A14Z(q+1)=5
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=6 And A14Z(q)>0 And Fehler16SS(q+1)=0 Then Fehler16SS(q+1)=1 hgjkhkgkh=1 A14Z(q+1)=6
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=7 And A14Z(q)>0 And Fehler16SS(q+1)=0 Then Fehler16SS(q+1)=1 hgjkhkgkh=1 A14Z(q+1)=7
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=8 And A14Z(q)>0 And Fehler16SS(q+1)=0 Then Fehler16SS(q+1)=1 hgjkhkgkh=1 A14Z(q+1)=8
If hgjkhkgkh=0 And GetroffenS(i)=1 And DVGHJFHMHJG(i)=9 And A14Z(q)>0 And Fehler16SS(q+1)=0 Then Fehler16SS(q+1)=1 hgjkhkgkh=1 A14Z(q+1)=9
Next
q=q+1
Until q=7

GetroffenS(0)=0
GetroffenS(1)=0
GetroffenS(2)=0
GetroffenS(3)=0
GetroffenS(4)=0
GetroffenS(5)=0
GetroffenS(6)=0

DrawImage HGrundH, 0,0
If Schwierigkeitsstufe=2 Then Text 100,1,A14Z(0)+""+A14Z(1)+"+"+A14Z(2)+"="+A14Z(3)+A14Z(4)+A14Z(5)
If Schwierigkeitsstufe=3 Then Text 100,1,A14Z(0)+""+A14Z(1)+"+"+A14Z(2)+""+A14Z(3)+"="+A14Z(4)+A14Z(5)+A14Z(6)
If Schwierigkeitsstufe=1 Then Text 100,1,A14Z(0)+"*"+A14Z(1)+"="+A14Z(2)+A14Z(3)
If Schwierigkeitsstufe=4 Then Text 100,1,A14Z(0)+""+A14Z(1)+"*"+A14Z(2)+"="+A14Z(3)+A14Z(4)+A14Z(5)

If A14Z(0)>0 And Schwierigkeitsstufe=2 And A14Z(0)*10+A14Z(1)+A14Z(2)=A14Z(3)*100+A14Z(4)*10+A14Z(5) Then
Cls
Locate 1,1
Print "Richtig"
Delay 2000
RichtigA16=RichtigA16+1
Goto Aufgabe16
ElseIf A14Z(0)>0 And Schwierigkeitsstufe=2 And A14Z(0)*10+A14Z(1)+A14Z(2)=A14Z(3)*10+A14Z(4) Then
Cls
Locate 1,1
Print "Richtig"
Delay 2000
RichtigA16=RichtigA16+1
Goto Aufgabe16
ElseIf A14Z(0)>0 And Schwierigkeitsstufe=3 And A14Z(0)*10+A14Z(1)+A14Z(2)*10+A14Z(3)=A14Z(4)*100+A14Z(5)*10+A14Z(6) Then
Cls
Locate 1,1
Print "Richtig"
Delay 2000
RichtigA16=RichtigA16+1
Goto Aufgabe16
ElseIf A14Z(0)>0 And Schwierigkeitsstufe=3 And A14Z(0)*10+A14Z(1)+A14Z(2)*10+A14Z(3)=A14Z(4)*10+A14Z(5) Then
Cls
Locate 1,1
Print "Richtig"
Delay 2000
RichtigA16=RichtigA16+1
Goto Aufgabe16
ElseIf A14Z(2)=1 Or A14Z(2)>1 And Schwierigkeitsstufe=1 And A14Z(0)*A14Z(1)=A14Z(2)*10+A14Z(3) Then
Cls
Locate 1,1
Print "Richtig"
Delay 2000
RichtigA16=RichtigA16+1
Goto Aufgabe16
ElseIf A14Z(2)=1 Or A14Z(2)>1 And Schwierigkeitsstufe=1 And A14Z(0)*A14Z(1)=A14Z(2)+A14Z(3) Then
Cls
Locate 1,1
Print "Richtig"
Delay 2000
RichtigA16=RichtigA16+1
Goto Aufgabe16
ElseIf A14Z(2)=1 Or A14Z(2)>1 And Schwierigkeitsstufe=4 And (A14Z(0)*10+A14Z(1))*A14Z(3)=(A14Z(2)*100)+(A14Z(3)*10)+A14Z(4) Then
Cls
Locate 1,1
Print "Richtig"
Delay 2000
RichtigA16=RichtigA16+1
Goto Aufgabe16
ElseIf A14Z(2)=1 Or A14Z(2)>1 And Schwierigkeitsstufe=4 And (A14Z(0)*10+A14Z(1))*A14Z(2)=(A14Z(3)*10)+A14Z(4) Then
Cls
Locate 1,1
Print "Richtig"
Delay 2000
RichtigA16=RichtigA16+1
Goto Aufgabe16
ElseIf A14Z(2)=1 Or A14Z(2)>1 And Schwierigkeitsstufe=4 And (A14Z(0)*10+A14Z(1))*A14Z(3)=A14Z(2) Then
Cls
Locate 1,1
Print "Richtig"
Delay 2000
RichtigA16=RichtigA16+1
Goto Aufgabe16
ElseIf Schwierigkeitsstufe=2 Or Schwierigkeitsstufe=4 And A14Z(0)>0 And A14Z(1)>0 And A14Z(2)>0 And A14Z(3)>0 And A14Z(4)>0 And A14Z(5)>0 Then
Cls
Locate 1,1
Print "Falsch"
Delay 2000
FalschA16=FalschA16+1
Goto Aufgabe16
ElseIf Schwierigkeitsstufe=1 And A14Z(0)>0 And A14Z(1)>0 And A14Z(2)>0 And A14Z(3)>0 Then
Cls
Locate 1,1
Print "Falsch"
Delay 2000
FalschA16=FalschA16+1
Goto Aufgabe16
ElseIf Schwierigkeitsstufe=3 And A14Z(0)>0 And A14Z(1)>0 And A14Z(2)>0 And A14Z(3)>0 And A14Z(4)>0 And A14Z(5)>0 And A14Z(6)>0 Then
Cls
Locate 1,1
Print "Falsch"
Delay 2000
FalschA16=FalschA16+1
Goto Aufgabe16
EndIf



hgjkhkgkh=0



If x=<40 Then x=40
If x=>1200 Then x=1200
SteinKoY=SteinKoY+1
If SteinKoY=1500 Then SteinKoY=1050


SZGVGVGH=0


kgbvhknvgknjmkmh=kgbvhknvgknjmkmh-1


If kgbvhknvgknjmkmh=0 Then
For i=0 To 8
SeedRnd MilliSecs()
BildZ= Rand(1,9)
If BildZ=1 Then SteinK(i)=B1 DVGHJFHMHJG(i)=1
If BildZ=2 Then SteinK(i)=B2 DVGHJFHMHJG(i)=2
If BildZ=3 Then SteinK(i)=B3 DVGHJFHMHJG(i)=3
If BildZ=4 Then SteinK(i)=B4 DVGHJFHMHJG(i)=4
If BildZ=5 Then SteinK(i)=B5 DVGHJFHMHJG(i)=5
If BildZ=6 Then SteinK(i)=B6 DVGHJFHMHJG(i)=6
If BildZ=7 Then SteinK(i)=B7 DVGHJFHMHJG(i)=7
If BildZ=8 Then SteinK(i)=B8 DVGHJFHMHJG(i)=8
If BildZ=9 Then SteinK(i)=B9 DVGHJFHMHJG(i)=9
Delay Rand (1,9)
Next
kgbvhknvgknjmkmh=1000
EndIf

.A16SteinAn
PSEE161#=PSEE161#+0.005

DrawImage SteinK(0), SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK(0),SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS(0)=1 x=0
  EndIf
SteinKoX=SteinKoX+50
SteinKoY=SteinKoY+PSEE161#
DrawImage SteinK(1), SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK(1),SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS(1)=1 x=0
  EndIf
SteinKoY=SteinKoY-PSEE161#
SteinKoX=SteinKoX-50



SteinKoX=SteinKoX+100
SteinKoY=SteinKoY-PSEE161#
DrawImage SteinK(2), SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK(2),SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS(2)=1 x=0
  EndIf
SteinKoY=SteinKoY+PSEE161#
SteinKoX=SteinKoX-100



SteinKoX=SteinKoX+150
SteinKoY=SteinKoY-150
DrawImage SteinK(3), SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK(3),SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS(3)=1 x=0
  EndIf
SteinKoY=SteinKoY+150
SteinKoX=SteinKoX-150



SteinKoX=SteinKoX+200
SteinKoY=SteinKoY-200
DrawImage SteinK(4), SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK(4),SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS(4)=1 x=0
  EndIf
SteinKoY=SteinKoY+200
SteinKoX=SteinKoX-200



SteinKoX=SteinKoX+250
SteinKoY=SteinKoY-250
DrawImage SteinK(5), SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK(5),SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS(5)=1 x=0
  EndIf
SteinKoY=SteinKoY+250
SteinKoX=SteinKoX-250



SteinKoX=SteinKoX+350
SteinKoY=SteinKoY-250
DrawImage SteinK(6), SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK(6),SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS(6)=1 x=0
  EndIf
SteinKoY=SteinKoY+250
SteinKoX=SteinKoX-350



SteinKoY=SteinKoY-450
SteinAnz=SteinAnz+1


If SteinAnz<15 Then Goto A16SteinAn
SteinKoY=SteinKoY+6750
SteinAnz=0

JetztZeit = MilliSecs()
If (JetztZeit-StartZeit > ZeitMaxRS) Then
If SFSCHNR=4 Then SFSCHNR=0
SFSCHNR=SFSCHNR+1
    If KeyDown (205) = 1 Then x = x + 12:rocket=SFRXP(SFSCHNR)
    If KeyDown (203) = 1 Then x = x - 12:rocket=SFRXM(SFSCHNR)
StartZeit = MilliSecs()
EndIf
    DrawImage rocket, x, y
    Flip
Cls
Goto Aufgabe16A
End









.Aufgabe17
PauseChannel MXP
ClsVB
Schrift = LoadFont ("Arial",40,20100)
SetFont Schrift
Color 1,1,1
ClsColor 1,255,1
Cls
Print "Beschrieb:"
Print "Mit einem Klick auf Enter erscheint eine"
Print "+,-,* oder : Rechnumg."
Print "Du hast 10 Sekunden Zeit um die Rechnung"
Print "zu lösen."
Print ""
Print "Zu musst von 30 Rechnungen mindestens 25"
Print "richtig und in angemesenem Tempo schaffen."
Print "Viel Glück!"
Input()
StartZeitP = MilliSecs()
Cls
Locate 1,1
Aufgabehhhjjhujh=0
Richtig=0
Falsch=0
Zahl1=0
Zahl2=0
Zahl3=0
SROP=0
Const ZeitMaxSR = 10000  ; 10 Sekunden
.SRZU
StartZeit = MilliSecs()
Cls
Locate 1,1
Aufgabehhhjjhujh=Aufgabehhhjjhujh+1
If Aufgabehhhjjhujh=30 Then Goto SRVE
SeedRnd MilliSecs()
SROP=Rand (1,4)
If SROP=1 Then Goto SRPL
If SROP=2 Then Goto SRMI
If SROP=3 Then Goto SRMA
If SROP=4 Then Goto SRDU

.SRPL
Zahl1= Rand(0,100)
Zahl2= Rand(0,100)
Write Zahl1 +"+"+Zahl2 + "=" 
Ergebnis=Input()
JetztZeit = MilliSecs()
If (JetztZeit-StartZeit > ZeitMaxSR) Then Print "Zu spät!"
If (JetztZeit-StartZeit > ZeitMaxSR) Then Print "und"
If Ergebnis=Zahl1+Zahl2 Then Print "Richtig!" Richtig=Richtig+1 
If Ergebnis<>Zahl1+Zahl2 Then Print "Falsch!" Falsch=Falsch+1
Input()
Goto SRZU
End

.SRMI
Zahl1= Rand(0,100)
Zahl2= Rand(0,100)
If Zahl1<Zahl2 Then Zahl3=Zahl1 Zahl1=Zahl2 Zahl2=Zahl3
Write Zahl1 +"-"+Zahl2 + "=" 
Ergebnis=Input()
JetztZeit = MilliSecs()
If (JetztZeit-StartZeit > ZeitMaxSR) Then Print "Zu spät!"
If (JetztZeit-StartZeit > ZeitMaxSR) Then Print "und"       
If Ergebnis=Zahl1-Zahl2 Then Print "Richtig!" Richtig=Richtig+1 
If Ergebnis<>Zahl1-Zahl2 Then Print "Falsch!" Falsch=Falsch+1
Input()
Goto SRZU
End

.SRMA
Zahl1= Rand(0,10)
Zahl2= Rand(0,10)
Write Zahl1 + "*" +Zahl2 + "=" 
Ergebnis=Input()    
JetztZeit = MilliSecs()
If (JetztZeit-StartZeit > ZeitMaxSR) Then Print "Zu spät!"
If (JetztZeit-StartZeit > ZeitMaxSR) Then Print "und"   
If Ergebnis=Zahl1*Zahl2 Then Print "Richtig!" Richtig=Richtig+1 
If Ergebnis<>Zahl1*Zahl2 Then Print "Falsch!" Falsch=Falsch+1
Input()
Goto SRZU
End

.SRDU
Zahl3= Rand(1,10)
Zahl2= Rand(1,10)
Zahl1= Zahl2*Zahl3
Write Zahl1 +":"+Zahl2 + "=" 
Ergebnis=Input()
JetztZeit = MilliSecs()
If (JetztZeit-StartZeit > ZeitMaxSR) Then Print "Zu spät!"
If (JetztZeit-StartZeit > ZeitMaxSR) Then Print "und"     
If Ergebnis=Zahl1/Zahl2 Then Print "Richtig!" Richtig=Richtig+1 
If Ergebnis<>Zahl1/Zahl2 Then Print "Falsch!" Falsch=Falsch+1
Input()
Goto SRZU
End


.SRVE
Cls
Locate 1,1
Print "Du hast "+Richtg+"/30 Aufgaben"
Print "Richtig und in angemesenem Tempo gelöst."
Print ""
If Richtig=>25 Then
Print "Ziel erreicht!"
Protokoll$="Schnellrechnen" SpielstandS
Protokoll$="Richtig: "+Richtg+"/30" SpielstandS
Input()
Aufgabe=0
Richtig=0
Falsch=0
Zahl1=0
Zahl2=0
Zahl3=0
SROP=0
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=17
Smeili=0
Goto Programmstart
Else
Print "Ziel nicht erreicht!"
Print "Versuche die Aufgabe erneut!"
Protokoll$="Schnellrechnen" SpielstandS
Protokoll$="Richtig: "+Richtg+"/30" SpielstandS
StartZeit=StartZeitP
Gosub PZeit
Input()
Aufgabehhhjjhujh=0
Richtig=0
Falsch=0
Zahl1=0
Zahl2=0
Zahl3=0
SROP=0
If UebersichtA=1 Then Goto Uebersicht3
Goto Aufgabe17
End
EndIf




.Aufgabe18
PauseChannel MXP
ClsVB
Adjektiv = 0   Adjektiv1 = 0    Adjektiv2 = 0
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
StartZeit = MilliSecs()
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,0,0
Print"Erkenne das Adjektiv in dem folgenden Satz."
Print"Schreibe das Adjektiv und drücke Enter"
Print
Print "Mein Fahrrad fährt nicht mehr so gut."
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "gut" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv = Adjektiv +1
EndIf
If Adjektiv =4  Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "gut"
Print
Print "Steigere das Adjektiv einmal z.B. (gelber).
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "besser" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv1 = Adjektiv1 +1
EndIf
If Adjektiv1 =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "besser"
Print
Print "Und jetzt steigere das Adjektiv zweimal z.B. (am gelbsten).
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "am besten" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv2 = Adjektiv2 +1
EndIf
If Adjektiv2 =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "am besten"
Print


Cls 
Locate 1,1
Adjektiv = 0   Adjektiv1 = 0    Adjektiv2 = 0
DrawImage HGrundH, 0,0
SetFont Schrift
Color 0,0,0
Print"Erkenne das Adjektiv in dem folgenden Satz."
Print"Schreibe das Adjektiv und drücke Enter"
Print
Print "Ich bin vergnügt."
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "vergnügt" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv = Adjektiv +1
EndIf
If Adjektiv =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "vergnügt"
Print
Print "Steigere das Adjektiv einmal z.B. (gelber).
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "vergnügter" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv1 = Adjektiv1 +1
EndIf
If Adjektiv1 =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "vergnügter"
Print
Print "Und jetzt steigere das Adjektiv zweimal z.B. (am gelbsten).
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "am vergnügtesten" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv2 = Adjektiv2 +1
EndIf
If Adjektiv2 =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "am vergnügtesten"
Print


Cls 
Locate 1,1
Adjektive = 0   Adjektive1 = 0    Adjektive2 = 0
DrawImage HGrundH, 0,0
SetFont Schrift
Color 0,0,0
Print"Erkenne das Adjektiv in dem folgenden Satz."
Print"Schreibe das Adjektiv und drücke Enter"
Print
Print "Dieser Spielplatz ist echt toll."
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "toll" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv = Adjektiv +1
EndIf
If Adjektiv =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "toll"
Print
Print "Steigere das Adjektiv einmal z.B. (gelber).
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "toller" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv1 = Adjektiv1 +1
EndIf
If Adjektiv1 =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "toller"
Print
Print "Und jetzt steigere das Adjektiv zweimal z.B. (am gelbsten).
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "am tollsten" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv2 = Adjektiv2 +1
EndIf
If Adjektiv2 =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "am tollsten"
Print



Cls 
Locate 1,1
Adjektiv = 0   Adjektiv1 = 0    Adjektiv2 = 0
DrawImage HGrundH, 0,0
SetFont Schrift
Color 0,0,0
Print"Erkenne das Adjektiv in dem folgenden Satz."
Print"Schreibe das Adjektiv und drücke Enter"
Print
Print "Ich esse gerne süsse Schokolade."
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "süss" Or Ratwort1$ = "süsse" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv = Adjektiv +1
EndIf
If Adjektiv =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "süss"
Print
Print "Steigere das Adjektiv einmal z.B. (gelber).
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "süsser" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv1 = Adjektiv1 +1
EndIf
If Adjektiv1 =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "süsser"
Print
Print "Und jetzt steigere das Adjektiv zweimal z.B. (am gelbsten).
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "am süssesten" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv2 = Adjektiv2 +1
EndIf
If Adjektiv2 =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "am süssesten"
Protokoll$="Adjektive" SpielstandS
Gosub PZeit
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=18
Smeili=0
Goto Programmstart
End



.Aufgabe19
PauseChannel HGM
ClsVB
Pronomen = 0   Pronomen1 = 0
HGrundH=LoadImage (".\Bilder\Meergn.jpg")
DrawImage HGrundH, 0,0
StartZeit = MilliSecs()
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,0,0
Print"Erkenne das Pronomen in dem folgenden Satz."
Print"Schreibe das Pronomen und drücke Enter"
Print
Print "Mein Fahrrad fährt nicht mehr so gut."
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "mein" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Pronomen = Pronomen +1
EndIf
If Pronomen =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "mein"
Print
Print "Ersetze das Pronomen durch den passenden Artikel.
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "das" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Pronomen1 = Pronomen1 +1
EndIf
If Pronomen1 =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "das"
Print



Cls 
Locate 1,1
Pronomen = 0   Pronomen1 = 0
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,0,0
Print"Erkenne das Pronomen in dem folgenden Satz."
Print"Schreibe das Pronomen und drücke Enter"
Print
Print "Erich hat eine Grippe."
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "eine" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Pronomen = Pronomen +1
EndIf
If Pronomen =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "eine"
Print
Print "Ersetze das Pronomen durch den passenden Artikel.
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "die" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Pronomen1 = Pronomen1 +1
EndIf
If Pronomen1 =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "die"
Print




Cls 
Locate 1,1
Pronomen = 0   Pronomen1 = 0
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,0,0
Print"Erkenne das Pronomen in dem folgenden Satz."
Print"Schreibe das Pronomen und drücke Enter"
Print
Print "Peter geniesst die Ferien."
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "die" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Pronomen = Pronomen +1
EndIf
If Pronomen =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "die"
Print
Print "Ersetze das Pronomen durch den passenden Artikel.
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "die" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Pronomen1 = Pronomen1 +1
EndIf
If Pronomen1 =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "die"
Print




Cls 
Locate 1,1
Pronomen = 0   Pronomen1 = 0
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,0,0
Print"Erkenne das Pronomen in dem folgenden Satz."
Print"Schreibe das Pronomen und drücke Enter"
Print
Print "Alex schaut zehn Filme hintereinander."
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "zehn" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Pronomen = Pronomen +1
EndIf
If Pronomen =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "zehn"
Print
Print "Ersetze das Pronomen durch den passenden Artikel.
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "die" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Pronomen1 = Pronomen1 +1
EndIf
If Pronomen1 =4 Then Print "Du hast zuviele Fehler, versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "die"
Protokoll$="Pronomen"
Gosub PZeit
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=19
Smeili=0
Goto Programmstart
End


.LAufgabe
If Not Aufgaben=100 Then
Schrift = LoadFont ("Arial",60,20100)
SetFont Schrift
ClsVB
ClsColor 1,255,1
Cls
Text 640,10,"Du kannst die lerzte Aufabe erst machen,",1
Text 640,70,"wenn deine Spielfigur wieder in ihrem Haus ist!",1
Schrift = LoadFont ("Arial",30,20100)
SetFont Schrift
Text 640,970,"Weiter mit beliebiger Taste",1
WaitKey
Goto Uebersicht3
EndIf
ClsVB
LAufgabeVer=1
ClsColor 1,255,1
Cls
Schrift = LoadFont ("Arial",40,20100)
SetFont Schrift
Color 0,0,0
Print "Letzte Aufgabe!
Print "Dein Feind, der dich am Amfang vom"
Print "Spiel entführt hat, will dich fangen!"
Print "Leider hat er dich auch noch als kleines Smiley"
Print "verwandelt, damit du, wenn er dich fängt, keine"
Print "Chance hast gegen ihn zu kämpfen"
Print "Noch ein paar Tipps:"
Print "Der Feind wird immer schneller."
Print "Auf dem blauen Feld sind beide schneller und auf dem
Print "grünen beide langsamer."
Print ""
Print "Wenn du es nicht im ersten Versuch schaffst, ist es"
Print "auch nicht schlimm, denn nach jedem Fehlversuch kommst"
Print "du wieder zu diesem Beschrieb."
Print ""
Print "Viel Glück!"
Input()
ClsVB
SetBuffer BackBuffer ()
;rocket = LoadImage (".\Bilder\FEnd.bmp")
rocket = LoadImage (".\Bilder\FEnd.bmp")
MaskImage rocket, 255,255,255
x = 1000
y = 380
;ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Letzte Aufgabe.jpg")
monster= LoadImage (".\Bilder\Monster1.bmp")
MaskImage monster, 255,255,255
x1=500
y1=500

x2#=800
y2#=800


StartZeit = MilliSecs()
Const ZeitMaxX = 60000  ; 60 Sekunden

F2GE#=1.5 ;Startgeschwindikeit des Feindes

yS#=400
xS#=435
TGESCHWINDIKEIT=4
HINTERNISVZ=2000

Schrift = LoadFont ("Arial",130,20100)
SetFont Schrift





.LA1
JetztZeit = MilliSecs()
DrawImage HGrundH, 1,1
RWZUHRFFCFG=JetztZeit/1000-StartZeit/1000
Text 580,1,60-RWZUHRFFCFG
If KeyDown (205) = 1 Then x1 = x1 + TGESCHWINDIKEIT Richt1$="L" ElseIf KeyDown (203) = 1 Then x1 = x1 - TGESCHWINDIKEIT Richt1$="R" ElseIf KeyDown (208) = 1Then y1 = y1 + TGESCHWINDIKEIT Richt1$="O" ElseIf KeyDown (200) = 1Then y1 = y1 - TGESCHWINDIKEIT Richt1$="U"


DrawImage rocket, x1,y1
DrawImage monster, x2#,y2#


If QENTG$="" Then

If x1=x2# Then x1=x1-1
If y1=y2# Then y1=y1-1

If x2#-x1=>y1-y2# And y1-y2#>0 Then x2#=x2#-F2GE# Richt2$="L" SGe=1
If x1-x2#=>y1-y2# And y1-y2#>0 Then x2#=x2#+F2GE# Richt2$="R" SGe=1
If x2#-x1=>y2#-y1 And y2#-y1>0 Then x2#=x2#-F2GE# Richt2$="L" SGe=1
If x1-x2#=>y2#-y1 And y2#-y1>0 Then x2#=x2#+F2GE# Richt2$="R" SGe=1


If SGe=0 And y2#-y1>x1-x2# And x1-x2#>0 Then y2#=y2#-F2GE# Richt2$="O"
If SGe=0 And y1-y2#>x1-x2# And x1-x2#>0 Then y2#=y2#+F2GE# Richt2$="U"
If SGe=0 And y2#-y1>x2#-x1 And x2#-x1>0 Then y2#=y2#-F2GE# Richt2$="O"
If SGe=0 And y1-y2#>x2#-x1 And x2#-x1>0 Then y2#=y2#+F2GE# Richt2$="U"
SGe=0
EndIf

ICrocket=ImagesCollide (rocket, x1,y1,0, monster,x2,y2,0)
If ICrocket Then
LAufgabeVer=LAufgabeVer+1
Goto LAufgabe
End
  EndIf

rgb=ReadPixel(x1-1,y1-1)
r1=(rgb And $FF0000)/$10000
g1=(rgb And $FF00)/$100
b1=rgb And $FF
rgb=ReadPixel(x1+33,y1-1)
r3=(rgb And $FF0000)/$10000
g3=(rgb And $FF00)/$100
b3=rgb And $FF
rgb=ReadPixel(x1+33,y1+31)
r2=(rgb And $FF0000)/$10000
g2=(rgb And $FF00)/$100
b2=rgb And $FF
rgb=ReadPixel(x1-1,y1+31)
r4=(rgb And $FF0000)/$10000
g4=(rgb And $FF00)/$100
b4=rgb And $FF


If r1>200 Or r2>200 Or r3>200 Or r4>200 Then
If Richt1$="R" Then x1=x1+TGESCHWINDIKEIT
If Richt1$="L" Then x1=x1-TGESCHWINDIKEIT
If Richt1$="U" Then y1=y1+TGESCHWINDIKEIT
If Richt1$="O" Then y1=y1-TGESCHWINDIKEIT
EndIf

If b1>200 Or b2>200 Then
TGESCHWINDIKEIT=6
ElseIf g1>200 Or g2>200 Or g3>200 Or g4>200 Then
TGESCHWINDIKEIT=2
Else
TGESCHWINDIKEIT=4
EndIf


rgb=ReadPixel(x2#-1,y2#-1)
r1=(rgb And $FF0000)/$10000
g1=(rgb And $FF00)/$100
b1=rgb And $FF
rgb=ReadPixel(x2#+49,y2#-1)
r2=(rgb And $FF0000)/$10000
g2=(rgb And $FF00)/$100
b2=rgb And $FF
rgb=ReadPixel(x2#+49,y2#+34)
r3=(rgb And $FF0000)/$10000
g3=(rgb And $FF00)/$100
b3=rgb And $FF
rgb=ReadPixel(x2#-1,y2#+34)
r4=(rgb And $FF0000)/$10000
g4=(rgb And $FF00)/$100
b4=rgb And $FF


	If QENTG$="O" Then y2#=y2#-F2GE#
	If QENTG$="U" Then y2#=y2#+F2GE#
	If QENTG$="R" Then x2#=x2#+F2GE#
	If QENTG$="L" Then x2#=x2#-F2GE#

	
If r1<200 And r2<200 And r3<200 And r4<200
QENTG$=""
Else
If QENTG$="" Then
	If Richt2$="O" Or Richt2$="U" Then
	If x1>x2# Then QENTG$="R" Else QENTG$="L"
	ElseIf Richt2$="L" Or Richt2$="R" Then
	If y1>y2# Then QENTG$="U" Else QENTG$="O"
	EndIf
EndIf
EndIf

If b1>200 Or b2>200 Or b3>200 Or b4>200 And F2GEVERS=0 Then F2GE#=F2GE#*2 F2GEVERS=1
If g1>200 Or g2>200 Or g3>200 Or g4>200 And F2GEVERL=0 Then F2GE#=F2GE#/2 F2GEVERL=1

If F2GEVERS=1 And b1=<200 And b2=<200 And b3=<200 And b4=<200 Then
F2GE#=F2GE#/2
F2GEVERS=0
EndIf

If F2GEVERL=1 And g1=<200 And g2=<200 And g3=<200 And g4=<200 Then
F2GE#=F2GE#*2
F2GEVERL=0
EndIf

Flip
Cls
JetztZeit = MilliSecs()
If (JetztZeit-StartZeit > ZeitMaxX) Then Protokoll$="Letzte Aufgabe" SpielstandS : Protokoll$="Versuche: "+LAufgabeVer SpielstandS Goto Ende
F2GE#=F2GE#+0.0003
Goto LA1
End




.Ende
ClsVB
FY=700
FX=570
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\14.jpg")
SYP
If UebersichtA=0 Then
ClsVB
Schrift = LoadFont ("Arial",50,20100)
SetFont Schrift
Color 0,0,0
ClsColor 253,202,13
Cls
Text 640,410,"Herzlichen Glückwunsch:",1,1
Text 640,460,"du bist am Ende meines Lernprogramms angelangt!",1,1
Text 640,510,"Natürlich kannst du auch weiterhin alle",1,1
Text 640,560,"Aufgaben unter der Übersicht lösen.",1,1
Text 640,610,"Auch weiterhin Viel Spass!",1,1
Schrift = LoadFont ("Arial",30,20100)
SetFont Schrift
Text 640,970,"Weiter mit beliebiger Taste.",1,1
WaitKey
EndIf
ClsVB
DrawImage HGrundSF,0,0
SeedRnd MilliSecs()

img=LoadImage(".\Bilder\14.jpg")


Dim matrix(xdiv,ydiv)
For ii = 1 To frames
	For I = 1 To choice
		Repeat
			x=Rnd(0,xdiv)
			y=Rnd(0,ydiv)
		Until matrix(x,y)=0
		matrix(x,y)=ii
	Next
Next
dly=CreateTimer(fps)
For frm=0 To frames
	WaitTimer(dly)
	For x=0 To xdiv
		For y=0 To ydiv
			If matrix(x,y)=frm
				DrawImageRect img,x*xsize,y*ysize,x*xsize,y*ysize,xsize,ysize
			End If
		Next
	Next
Next
Delay 2000
Color 0,0,0
For frm=0 To frames
	WaitTimer(dly)
	For x=0 To xdiv
		For y=0 To ydiv
			If matrix(x,y)=frm
				Rect x*xsize,y*ysize,xsize,ysize
			End If
		Next
	Next
Next
EZWTSAW=0
AAAER=0
ETNFMB=0
ClsVB
Schrift = LoadFont ("Arial",50,20100)
SchriftSW = LoadFont ("Arial",100,20100)
Color 0,0,0
SetBuffer BackBuffer()
backdrop=LoadImage(".\Bilder\Titelbild.jpg")
scroll_y=0
AAAER=1045
While Not EZWTSAW=3600
	TileBlock backdrop,0,scroll_y
	scroll_y=scroll_y-1
	If scroll_y=ImageHeight(backdrop) Then scroll_y=0
EZWTSAW=EZWTSAW+1
ETNFMB=0
SetFont SchriftSW
Text 640,AAAER,"Schlusswort",1
AAAER=AAAER+100
SetFont Schrift
Text 640,AAAER,"",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Nico (98%):",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"programmiert",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"designt",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"dokumentiert",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"fotografiert",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Fotos bearbeitet",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"geplant",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Installer",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Programmierfehler gesucht",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Programmierfehler verbessert",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Programmidee",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Daniel (1%):",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"fotografiert",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"geplant",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Christina (0.75%):",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Programmierfehler gesucht",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Rechtschreibefehler gesucht",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Rechtschreibefehler verbessert",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Aurelia (0.25%)",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Programmierfehler gesucht",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Programmierfehler verbessert",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Musik (Harfe):",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Herr Raphael Bussinger, mein Harfelehrer",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Programmiert mit Blitzbasic 2D",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Homepage: http://www.nicobosshard.ch/",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"E-Mail: nico@bosshome.ch",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
Text 640,AAAER,"Ich hoffe, dass dir mein Programm gefallen hat.",1
AAAER=AAAER+65 ETNFMB=ETNFMB+1
AAAER=AAAER-((ETNFMB*65)+100)
	VWait
	Flip
	Cls
AAAER=AAAER-1
Wend
ClsVB
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial",200)
SetFont Schrift
Print
Print
Print "        Ende"
Delay 3000
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=100
Goto Programmstart
End




.Vorfilm
ChannelPitch HGM, 18000
ClsVB
FY=900
FX=70
SFG#=3
Feind=LoadImage (".\Bilder\Monster1.bmp")
HGrundSF=LoadImage (".\Bilder\14.jpg")
HGrundSFBN=LoadImage (".\Bilder\Höle1.jpg")
g=1
VFSWA=22000
Repeat
SXP
SXP
VVSFLZ=VVSFLZ+1
Until VVSFLZ=5
SYP
SYP
SYP
Bild = CreateImage (1280,1024)
SetBuffer ImageBuffer (Bild)
CopyRect 0,0,1280,1024,0,0,FrontBuffer(),ImageBuffer(Bild)
SetBuffer FrontBuffer()
ClsVB

VFFBSF=0
MaskImage Feind,255,255,255

Repeat
VFFBSF=VFFBSF+1
DrawImage Bild, 1,1
DrawImage Feind, 560,VFFBSF
Delay 3
Flip
Cls
Until VFFBSF=730
VVSFLZ=0
Repeat
DrawImage HGrundSF, 1,1
DrawImage Feind, 560,VFFBSF
DrawImageRect SF(g),550,VFFBSF+20, 0*SFG#, 64*SFG#, 22*SFG#, 32*SFG#
Delay 3
Flip
Cls
VFMWIEBA=VFMWIEBA+1
VFFBSF=VFFBSF-1
Until VFFBSF=-150
VFMWIEBA=0
SeedRnd MilliSecs()
ClsVB
img = CreateImage (1280,1024)
SetBuffer ImageBuffer (img)
TB=HGrundSF
DrawImage TB,0,0
VWait
SetBuffer FrontBuffer()
DrawImage TB,0,0
Dim matrix(xdiv,ydiv)
For ii = 1 To frames
	For I = 1 To choice
		Repeat
			x=Rnd(0,xdiv)
			y=Rnd(0,ydiv)
		Until matrix(x,y)=0
		matrix(x,y)=ii
	Next
Next
dly=CreateTimer(fps)
Color 0,0,0
For frm=0 To frames
	WaitTimer(dly)
	For x=0 To xdiv
		For y=0 To ydiv
			If matrix(x,y)=frm
				Rect x*xsize,y*ysize,xsize,ysize
			End If
		Next
	Next
Next
SeedRnd MilliSecs()
HGML#=1
ClsVB
Delay 1000
img = CreateImage (1280,1024)
SetBuffer ImageBuffer (img)
TB=HGrundSFBN
DrawImage TB,0,0
SetBuffer FrontBuffer()
Dim matrix(xdiv,ydiv)
For ii = 1 To frames
	For I = 1 To choice
		Repeat
			x=Rnd(0,xdiv)
			y=Rnd(0,ydiv)
			Until matrix(x,y)=0
		matrix(x,y)=ii
	Next
Next
dly=CreateTimer(fps)
For frm=0 To frames
	WaitTimer(dly)
	For x=0 To xdiv
		For y=0 To ydiv
			If matrix(x,y)=frm
				DrawImageRect img,x*xsize,y*ysize,x*xsize,y*ysize,xsize,ysize
			End If
		Next
	Next
Next
Delay 1000

Cls
Repeat
DrawImage HGrundSFBN, 1,1
DrawImage Feind, 560,VFFBSF
DrawImageRect SF(g),550,VFFBSF+20, 0*SFG#, 64*SFG#, 22*SFG#, 32*SFG#
Delay 3
Flip
Cls
VFMWIEBA=VFMWIEBA+1
VFFBSF=VFFBSF+1
Until VFFBSF=650

ClsVB
ClsColor 1,255,1
Cls
Schrift = LoadFont ("Arial",30,20100)
SetFont Schrift
Color 1,1,1
Print "Dein Feind hat dich entführt,"
Print "und weit weg von deinem Zuhause in sein Nest gelegt!"
Print ""
Print "Löse alle 20 Aufgaben um wieder"
Print "zu deinem Haus zu gelangen."
Print "Viel Glück!"
ChannelPitch HGM, 22000
Input()
Goto Teil1
End





Function GZSFG()
If G=1 Then SFG#=3
If G=2 Then SFG#=2.8
If G=3 Then SFG#=2.6
If G=4 Then SFG#=2.4
If G=5 Then SFG#=2.2
If G=6 Then SFG#=2
If G=7 Then SFG#=1.8
If G=8 Then SFG#=1.6
If G=9 Then SFG#=1.4
If G=10 Then SFG#=1.2
If G=11 Then SFG#=1
End Function




Function SXM()
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 0*SFG#, 0*SFG#, 19*SFG#, 32*SFG#
Delay 175
FX=FX-4*SFG#
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 19*SFG#,0*SFG#, 22*SFG#, 32*SFG#
Delay 175
FX=FX-4*SFG#
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 41*SFG#, 0*SFG#, 19*SFG#, 32*SFG#
Delay 175
FX=FX-4*SFG#
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 60*SFG#, 0*SFG#, 22*SFG#, 32*SFG#
Delay 175
FX=FX-4*SFG#
End Function






Function SXP()
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 0*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+4*SFG#
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 19*SFG#,32*SFG#, 22*SFG#, 32*SFG#
Delay 200
FX=FX+4*SFG#
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 41*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+4*SFG#
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 60*SFG#, 32*SFG#, 19*SFG#, 32*SFG#
Delay 200
FX=FX+4*SFG#
End Function




Function SXPB()
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 0*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY-11
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 19*SFG#,32*SFG#, 22*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY-11
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 41*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY-11
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 60*SFG#, 32*SFG#, 19*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY-11
End Function



Function SXPB1()
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 0*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY-10
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 19*SFG#,32*SFG#, 22*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY-10
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 41*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY-10
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 60*SFG#, 32*SFG#, 19*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY-10
End Function


Function SXPB2()
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 0*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY+5
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 19*SFG#,32*SFG#, 22*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY+5
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 41*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY+5
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 60*SFG#, 32*SFG#, 19*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY+5
End Function





Function SXPB3()
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 0*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY+11
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 19*SFG#,32*SFG#, 22*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY+11
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 41*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY+11
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 60*SFG#, 32*SFG#, 19*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY+11
End Function





Function SYP()
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 0*SFG#, 64*SFG#, 22*SFG#, 32*SFG#
Delay 175
FY=FY-4*SFG#
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 22*SFG#,64*SFG#, 19*SFG#, 32*SFG#
Delay 175
FY=FY-4*SFG#
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 41*SFG#,64*SFG#, 22*SFG#, 32*SFG#
Delay 175
FY=FY-4*SFG#
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 63*SFG#,64*SFG#, 22*SFG#, 32*SFG#
Delay 175
FY=FY-4*SFG#
End Function


.PZeit
JetztZeit = MilliSecs()
If (JetztZeit-StartZeit)/60000<>1 And ((JetztZeit-StartZeit)/1000)-((JetztZeit-StartZeit)/60000)*60<>1 Then Protokoll$="Zeit: "+(JetztZeit-StartZeit)/60000+" Minuten "+(((JetztZeit-StartZeit)/1000)-((JetztZeit-StartZeit)/60000)*60)+" Sekunden"
If (JetztZeit-StartZeit)/60000=1 And ((JetztZeit-StartZeit)/1000)-((JetztZeit-StartZeit)/60000)*60<>1 Then Protokoll$="Zeit: "+(JetztZeit-StartZeit)/60000+" Minute "+(((JetztZeit-StartZeit)/1000)-((JetztZeit-StartZeit)/60000)*60)+" Sekunden"
If (JetztZeit-StartZeit)/60000<>1 And ((JetztZeit-StartZeit)/1000)-((JetztZeit-StartZeit)/60000)*60=1 Then Protokoll$="Zeit: "+(JetztZeit-StartZeit)/60000+" Minuten "+(((JetztZeit-StartZeit)/1000)-((JetztZeit-StartZeit)/60000)*60)+" Sekunde"
If (JetztZeit-StartZeit)/60000=1 And ((JetztZeit-StartZeit)/1000)-((JetztZeit-StartZeit)/60000)*60=1 Then Protokoll$="Zeit: "+(JetztZeit-StartZeit)/60000+" Minute "+(((JetztZeit-StartZeit)/1000)-((JetztZeit-StartZeit)/60000)*60)+" Sekunde"
SpielstandS
Return


Function SpielstandS()
If Aufgaben>100 Then Aufgaben=100
filein = ReadFile(Name$+".txt")
ReadLine$(filein)
ReadLine$(filein)
ReadLine$(filein)
ReadLine$(filein)
For i=1 To 1499
RST$(i)=ReadLine$(filein)
Next
CloseFile filein



fileout = WriteFile(Name$+".txt")
WriteLine fileout, "Aufgaben="+Aufgaben
WriteLine fileout, "Schwierigkeitsstufe="+Schwierigkeitsstufe
WriteLine fileout, "Spielfigur="+Spielfigur$
WriteLine fileout, "Protokoll="
Repeat
zwfzdpi=zwfzdpi+1
If RST$(zwfzdpi)="" Then Exit
WriteLine fileout, RST$(zwfzdpi)
Forever
If Not Protokoll$="" Then WriteLine fileout, Protokoll$
CloseFile fileout



filein = ReadFile(Name$+".txt")
Aufgabenst$=ReadLine$(filein)
Aufgabenst$=Right$(Aufgabenst$,Len(Aufgabenst$)-Instr(Aufgabenst$,"="))
Aufgaben=Aufgabenst$
SchwierigkeitsstufeRL$=ReadLine$(filein)
SchwierigkeitsstufeRL$=Right$(SchwierigkeitsstufeRL$,Len(SchwierigkeitsstufeRL$)-Instr(SchwierigkeitsstufeRL$,"="))
Schwierigkeitsstufe=SchwierigkeitsstufeRL$
Spielfigur$=ReadLine$(filein)
Spielfigur$=Right$(Spielfigur$,Len(Spielfigur$)-Instr(Spielfigur$,"="))
CloseFile filein
End Function





Function WarnungA()
ClsVB
If NNWA=0 Then
Schrift = LoadFont ("Arial",35,True)
Else
Schrift = LoadFont ("Arial",55,True)
EndIf
SetFont Schrift

K1=LoadImage (".\Bilder\Ja.jpg")
K1O=LoadImage (".\Bilder\JaO.jpg")
K2=LoadImage (".\Bilder\Nein.jpg")
K2O=LoadImage (".\Bilder\NeinO.jpg")
K1B=K1
K2B=K2

ClsColor 255,201,14
Cls
SetBuffer BackBuffer()
Repeat
JaO=0
NeinO=0
circleX=MouseX()
circleY=MouseY()
Cls
Color 0,0,0
If NNWA=0 Then
Text 640,1,"Warnung:",1
Text 640,35,WarnungF$,1
Else
Text 640,20,WarnungF$,1
EndIf
DrawImage K1B, 300,362
DrawImage K2B, 300,512
DrawImage gfxCircle,circleX,circleY
Flip
If  ImageRectOverlap (gfxCircle,circleX,circleY,300,362,600,150) Then K1B=K1O JaO=1 Else K1B=K1
If  ImageRectOverlap (gfxCircle,circleX,circleY,300,511,600,150) And JaO=0 Then K2B=K2O NeinO=1 Else K2B=K2
Delay 50

If MouseDown(1) And JaO=1 Then Exit
If MouseDown(1) And NeinO=1 Then Exit
Forever
End Function


Function ClsVB()
Locate 1,1
Color 0,0,0
ClsColor 0,0,0
SetBuffer BackBuffer()
Cls
SetBuffer FrontBuffer()
Cls
FlushKeys
FlushMouse
End Function