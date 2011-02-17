AppTitle "Lernen mit Smiley"
Const width=1280,height=1024
Dim RST$(999)
Dim DVGHJFHMHJG(8)
Dim SteinK(8)
Dim GetroffenS(6)
Dim A14Z(6)
Dim Fehler16SS(8)
Dim sf(11)

Const xsize=16
Const ysize=16
Const xdiv=width/xsize
Const ydiv=height/ysize
Const total=xdiv*ydiv
Const frames=25
Const choice=total/frames
Const fps=25


HidePointer

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
Global Uebersicht
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
Cls
Locate 1,1
If Modus=0 Then Print "Dieser Bildschirm unterst�tzt"
If Modus=0 Then Print "die Grafik 1280,1024 nicht!"
If Modus=0 Then Print "Programm muss darum sofort beendet werden!"


filename$=".\Optionen.txt"
If FileType(filename$)=0 Then ESPS=1


fileout = WriteFile(".\Optionen.txt")
WriteLine fileout,"Grafik: 1280,1024,0,2"
CloseFile fileout



filein = ReadFile(".\Optionen.txt")
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
Delay 100

ZPFN$=zielpfad$
zielpfad$=zielpfad$+".\"

Color 0,0,0
Dateiname$="UptateO.txt"
rocket = LoadWebImage ("http://www.nicobosshard.ch/cgi-bin/UptateO.txt")
CopyFile "UptateO.txt","Uptate.txt"
DeleteFile "UptateO.txt"

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
            If tReadWebFile Mod 1000 = 0 Then BytesReceived (readWebFile, bytesToRead)

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
    Text 20, 20, "Dateien werden Hinuntergeladen bitte warten..."
    Text 20, 60,DATTEX$
    Text 20, 100, posByte + "/" + totalBytes + " Bytes wurden Hinuntergeladen (" + Percent (posByte, totalBytes) + "%)"
    Flip
  EndIf
End Function

Function Percent (part#, total#)
    Return Int (100 * (part / total))
End Function

If ERINV=1 Then  Goto KINVB2
filein = ReadFile(".\Uptate.txt")
ReadLine$(filein)
NV$ = ReadLine$(filein)
CloseFile filein
filein = ReadFile(".\Aktuelle Version.txt")
ReadLine$(filein)
AV$ = ReadLine$(filein)
CloseFile filein
AAAB=0
E=0
filename$=".\Nicht_an_Version_erinnern.dat"
If FileType(filename$)=1 Then AAAB=1
If FileType(filename$)=0 Then AAAB=2
If AAAB=1 Then
filein = ReadFile(".\Nicht_an_Version_erinnern.dat")
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
Print "Soll sie jetzt hinuntergeladen und installiert werden?"
Print "Der Vorgang kann einige Minuten in Anspruch nehmen."
Print ""
Print "Ja: Dr�cke 1"
Print "Nein: Dr�cke 2"
Print "An diese Version nicht mehr erinnern: Dr�cke 3"
Taste=WaitKey()
Cls
Locate 1,1
If Taste=49 Then
ZPFN$=zielpfad$
zielpfad$=zielpfad$+".\"
Color 255,255,255
KTIBWG=1
Dateiname$="Update.html"
rocket = LoadWebImage ("http://www.nicobosshard.ch/cgi-bin/Update.html")
CreateDir ".\Update"
CopyFile ".\Update.html",".\Update\Update.html"
DeleteFile ".\Update.html"
Datei$=".\Update\Update.html"
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
fileout = WriteFile("Nicht_an_Version_erinnern.dat")
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
Auswahl2a=LoadImage (".\Bilder\�bersicht.jpg")
Auswahl2b=LoadImage (".\Bilder\�bersichtO.jpg")
Auswahl3a=LoadImage (".\Bilder\Protokoll.jpg")
Auswahl3b=LoadImage (".\Bilder\ProtokollO.jpg")
Auswahl4a=LoadImage (".\Bilder\Spielfigur w�hlen.jpg")
Auswahl4b=LoadImage (".\Bilder\Spielfigur w�hlenO.jpg")
Auswahl5a=LoadImage (".\Bilder\Schwierigkeitsstufe w�hlen.jpg")
Auswahl5b=LoadImage (".\Bilder\Schwierigkeitsstufe w�hlenO.jpg")
Auswahl6a=LoadImage (".\Bilder\Spielstandoptionen.jpg")
Auswahl6b=LoadImage (".\Bilder\SpielstandoptionenO.jpg")
Auswahl7a=LoadImage (".\Bilder\Help.jpg")
Auswahl7b=LoadImage (".\Bilder\HelpO.jpg")
Auswahl8a=LoadImage (".\Bilder\Programm beenden.jpg")
Auswahl8b=LoadImage (".\Bilder\Programm beendenO.jpg")
SchwiriegkeitsstuffeW0=LoadImage (".\Bilder\Schwierigkeitsstufe.jpg")
SchwiriegkeitsstuffeW1=LoadImage (".\Bilder\SchwierigkeitsstufeK1.jpg")
SchwiriegkeitsstuffeW2=LoadImage (".\Bilder\SchwierigkeitsstufeK2.jpg")
SchwiriegkeitsstuffeW3=LoadImage (".\Bilder\SchwierigkeitsstufeK3.jpg")
SchwiriegkeitsstuffeW4=LoadImage (".\Bilder\SchwierigkeitsstufeK4.jpg")
SchwiriegkeitsstuffeW5=LoadImage (".\Bilder\SchwierigkeitsstufeK5.jpg")
Uebersicht=LoadImage (".\Bilder\Gletscher.jpg")
Uebersicht1a=LoadImage (".\Bilder\�bersicht1a.jpg")
Uebersicht2a=LoadImage (".\Bilder\�bersicht2a.jpg")
Uebersicht3a=LoadImage (".\Bilder\�bersicht3a.jpg")
Uebersicht4a=LoadImage (".\Bilder\�bersicht4a.jpg")
Uebersicht5a=LoadImage (".\Bilder\�bersicht5a.jpg")
Uebersicht6a=LoadImage (".\Bilder\�bersicht6a.jpg")
Uebersicht7a=LoadImage (".\Bilder\�bersicht7a.jpg")
Uebersicht8a=LoadImage (".\Bilder\�bersicht8a.jpg")
Uebersicht9a=LoadImage (".\Bilder\�bersicht9a.jpg")
Uebersicht10a=LoadImage (".\Bilder\�bersicht10a.jpg")
Uebersicht11a=LoadImage (".\Bilder\�bersicht11a.jpg")
Uebersicht12a=LoadImage (".\Bilder\�bersicht12a.jpg")
Uebersicht13a=LoadImage (".\Bilder\�bersicht13a.jpg")
Uebersicht14a=LoadImage (".\Bilder\�bersicht14a.jpg")
Uebersicht15a=LoadImage (".\Bilder\�bersicht15a.jpg")
Uebersicht16a=LoadImage (".\Bilder\�bersicht16a.jpg")
Uebersicht17a=LoadImage (".\Bilder\�bersicht17a.jpg")
Uebersicht18a=LoadImage (".\Bilder\�bersicht18a.jpg")
Uebersicht19a=LoadImage (".\Bilder\�bersicht19a.jpg")
Uebersicht20a=LoadImage (".\Bilder\�bersicht20a.jpg")
Uebersicht21a=LoadImage (".\Bilder\�bersicht21a.jpg")
Uebersicht1b=LoadImage (".\Bilder\�bersicht1b.jpg")
Uebersicht2b=LoadImage (".\Bilder\�bersicht2b.jpg")
Uebersicht3b=LoadImage (".\Bilder\�bersicht3b.jpg")
Uebersicht4b=LoadImage (".\Bilder\�bersicht4b.jpg")
Uebersicht5b=LoadImage (".\Bilder\�bersicht5b.jpg")
Uebersicht6b=LoadImage (".\Bilder\�bersicht6b.jpg")
Uebersicht7b=LoadImage (".\Bilder\�bersicht7b.jpg")
Uebersicht8b=LoadImage (".\Bilder\�bersicht8b.jpg")
Uebersicht9b=LoadImage (".\Bilder\�bersicht9b.jpg")
Uebersicht10b=LoadImage (".\Bilder\�bersicht10b.jpg")
Uebersicht11b=LoadImage (".\Bilder\�bersicht11b.jpg")
Uebersicht12b=LoadImage (".\Bilder\�bersicht12b.jpg")
Uebersicht13b=LoadImage (".\Bilder\�bersicht13b.jpg")
Uebersicht14b=LoadImage (".\Bilder\�bersicht14b.jpg")
Uebersicht15b=LoadImage (".\Bilder\�bersicht15b.jpg")
Uebersicht16b=LoadImage (".\Bilder\�bersicht16b.jpg")
Uebersicht17b=LoadImage (".\Bilder\�bersicht17b.jpg")
Uebersicht18b=LoadImage (".\Bilder\�bersicht18b.jpg")
Uebersicht19b=LoadImage (".\Bilder\�bersicht19b.jpg")
Uebersicht20b=LoadImage (".\Bilder\�bersicht20b.jpg")
Uebersicht21b=LoadImage (".\Bilder\�bersicht21b.jpg")
SPK=LoadImage (".\Bilder\Spielstand Kopieren.jpg")
SPK1=LoadImage (".\Bilder\Spielstand KopierenK1.jpg")
SPK2=LoadImage (".\Bilder\Spielstand KopierenK2.jpg")
SPK3=LoadImage (".\Bilder\Spielstand KopierenK3.jpg")
SPK4=LoadImage (".\Bilder\Spielstand KopierenK4.jpg")
SPK5=LoadImage (".\Bilder\Spielstand KopierenK5.jpg")


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
Schrift = LoadFont ("Arial",30,20100)
SetFont Schrift


DrawImage Anfang, 0,0
Print "Ich bedanke mich herzlich, dass Sie mein Lernprogramm installiert haben!"
Print ""
Print "Bei Problemen, schreiben Sie mir einfach unter nico@bosshard.ch ein E-Mail."
Print "Viel Spass beim lernen mit meinem Lernprogramm!"
Input()
Goto AnfangN
End







.AnfangN
ClsVB
Locate 1,1
Flip
Schrift = LoadFont ("Arial",55,20100)
SetFont Schrift
Color 0,255,0
Locate 1,1 
HGrundH=LoadImage (".\Bilder\Zugersee.jpg")
DrawImage HGrundH, 0,0
HGrundH=LoadImage (".\Bilder\Lava.jpg")
TileBlock HGrundH
Print "Gib deinen Namen ein und dr�cke auf Enter"
FlushMouse
FlushKeys
;Name$ = Input()
Name$="Nico"
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

HM=LoadSound(".\Sounds\"+Sound$+".mp3")
LoopSound HM
HGM=PlaySound (HM)




Goto F2

.Fehler1
Cls
Locate 1,1
Print "Der Name muss mindestens aus drei Stellen bestehen!"
Delay 3000
FlushKeys
Goto AnfangN
End

Function b()
End Function

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
Fig4=LoadImage (".\Bilder\Figur1.bmp")
ResizeImage Fig1,ImageWidth(Fig1)*3,ImageHeight(Fig1)*3
ResizeImage Fig2,ImageWidth(Fig2)*3,ImageHeight(Fig2)*3
ResizeImage Fig3,ImageWidth(Fig3)*3,ImageHeight(Fig3)*3
ResizeImage Fig4,ImageWidth(Fig4)*3,ImageHeight(Fig4)*3
DrawImage Fig1, 5,120
DrawImage Fig2, 330,120
DrawImage Fig3, 660,120
DrawImage Fig4, 985,120
Text 612,20,"Welche Spielfigur willst du haben?",1,1
Text 612,70,"Gieb die Nummer der Spielfigur ein.",1,1
Text 115,420,"1"
Text 458,420,"2"
Text 785,420,"3"
Text 1100,420,"4"
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
SpielstandS
EndIf
Forever
EndIf
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
ClsVB
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

Repeat
circleX=MouseX()
circleY=MouseY()
NNEZKAW=0
Cls
Locate 1,1
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

If ImageRectOverlap (gfxCircle,circleX,circleY,340,110,600,100) And NNEZKAW=0 Then
If MouseDown(1) Then Goto Programmstart
Auswahl1=Auswahl1b
NNEZKAW=1
Else
Auswahl1=Auswahl1a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,210,600,100) And NNEZKAW=0 Then
If MouseDown(1) Then Goto Uebersicht
Auswahl2=Auswahl2b
NNEZKAW=1
Else
Auswahl2=Auswahl2a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,310,600,100) And NNEZKAW=0 Then
;If MouseDown(1) Then Goto Programmstart
Auswahl3=Auswahl3b
NNEZKAW=1
Else
Auswahl3=Auswahl3a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,410,600,100) And NNEZKAW=0 Then
If MouseDown(1) Then Goto SpielfigurW
Auswahl4=Auswahl4b
NNEZKAW=1
Else
Auswahl4=Auswahl4a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,510,600,100) And NNEZKAW=0 Then
If MouseDown(1) Then Goto SchwierikeitsstufeW
Auswahl5=Auswahl5b
NNEZKAW=1
Else
Auswahl5=Auswahl5a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,610,600,100) And NNEZKAW=0 Then
;If MouseDown(1) Then Goto SchwierikeitsstufeW
Auswahl6=Auswahl6b
NNEZKAW=1
Else
Auswahl6=Auswahl6a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,710,600,100) And NNEZKAW=0 Then
If MouseDown(1) Then Goto Help
Auswahl7=Auswahl7b
NNEZKAW=1
Else
Auswahl7=Auswahl7a
EndIf
If ImageRectOverlap (gfxCircle,circleX,circleY,340,810,600,100) And NNEZKAW=0 Then
If MouseDown(1) Then Goto EPro
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
Delay 3000
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
Cls
Locate 1,1
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
Delay 50
Forever

.Uebersicht3
ResumeChannel HGM
jhhfgfsSFGjsgjmsgmsztzsh=1
Goto Auswahl
End







.SpielfigurW
ClsVB
TFormFilter 0
Schrift = LoadFont ("Arial",50,20100)
SetFont Schrift
HGrundH=LoadImage (".\Bilder\Gletscher.jpg")
DrawImage HGrundH, 0,0
Fig1=LoadImage (".\Bilder\Figur1.bmp")
Fig2=LoadImage (".\Bilder\Figur2.bmp")
Fig3=LoadImage (".\Bilder\Figur3.bmp")
Fig4=LoadImage (".\Bilder\Figur1.bmp")
ResizeImage Fig1,ImageWidth(Fig1)*3,ImageHeight(Fig1)*3
ResizeImage Fig2,ImageWidth(Fig2)*3,ImageHeight(Fig2)*3
ResizeImage Fig3,ImageWidth(Fig3)*3,ImageHeight(Fig3)*3
ResizeImage Fig4,ImageWidth(Fig4)*3,ImageHeight(Fig4)*3
DrawImage Fig1, 5,120
DrawImage Fig2, 330,120
DrawImage Fig3, 660,120
DrawImage Fig4, 985,120
Text 612,20,"Welche Spielfigur willst du haben?",1,1
Text 612,70,"Gieb die Nummer der Spielfigur ein.",1,1
Text 115,420,"1"
Text 458,420,"2"
Text 785,420,"3"
Text 1100,420,"4"
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
SpielstandS
EndIf
Forever

;Wichtig!
;Wichtig!
;Wichtig!
ASDREFGHHGHUJK=1
Goto Auswahl
End





.SchwierikeitsstufeW
ClsVB
Schrift = LoadFont ("Arial",45,20100)
SetFont Schrift
Color 1,1,1
SchwierikeitsstufeA=0
SchwierikeitsstufeA=1
gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255
HGrundH=LoadImage (".\Bilder\Schwierigkeitsstufe.jpg")
hotX= 380
hotY=300
hotW=520
hotH=100

hotX1= 380
hotY1=400
hotW1=520
hotH1=100

hotX2= 380
hotY2=500
hotW2=520
hotH2=100

hotX3= 380
hotY3=600
hotW3=520
hotH3=100

hotX4= 380
hotY4=700
hotW4=520
hotH4=100


.SW21
circleX=MouseX()
circleY=MouseY()
Cls
Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
Rect hotX2,hotY2,hotW2,hotH2,0
Rect hotX3,hotY3,hotW3,hotH3,0
Rect hotX4,hotY4,hotW4,hotH4,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto SW1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto SW2
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX2,hotY2,hotW2,hotH2) Goto SW3
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX3,hotY3,hotW3,hotH3) Goto SW4
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX4,hotY4,hotW4,hotH4) Goto SW5
HGrundH=SchwiriegkeitsstuffeW0
Delay 50
Goto SW21
.SW1
HGrundH=SchwiriegkeitsstuffeW1
If MouseDown(1) Then SchwierikeitsstufeE$="1" Goto SchwierikeitsstufeW2
Delay 50
Goto SW21
.SW2
HGrundH=SchwiriegkeitsstuffeW2
If MouseDown(1) Then SchwierikeitsstufeE$="2" Goto SchwierikeitsstufeW2
Delay 50
Goto SW21
.SW3
HGrundH=SchwiriegkeitsstuffeW3
If MouseDown(1) Then SchwierikeitsstufeE$="3" Goto SchwierikeitsstufeW2
Delay 50
Goto SW21
.SW4
HGrundH=SchwiriegkeitsstuffeW4
If MouseDown(1) Then SchwierikeitsstufeE$="4" Goto SchwierikeitsstufeW2
Delay 50
Goto SW21
.SW5
HGrundH=SchwiriegkeitsstuffeW5
If MouseDown(1) And SWZH=0 Then Goto SchwierikeitsstufeW2
Delay 50
Goto SW21


.SchwierikeitsstufeW2
If SchwierikeitsstufeE$="1" Then Schwierigkeitsstufe=1 SpielstandS
If SchwierikeitsstufeE$="2" Then Schwierigkeitsstufe=2 SpielstandS
If SchwierikeitsstufeE$="3" Then Schwierigkeitsstufe=3 SpielstandS
If SchwierikeitsstufeE$="4" Then Schwierigkeitsstufe=4 SpielstandS

SchwierikeitsstufeA=0
If HERHZ=1 Then HERHZ=0 ;Goto Teil1SSG
Goto Auswahl
End




.SpielstandKopieren
ClsVB
Schrift = LoadFont ("Arial",45,20100)
SetFont Schrift
Color 1,1,1
gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255
HGrundH=LoadImage (".\Bilder\Spielstand Kopieren.jpg")
hotX= 380
hotY=300
hotW=520
hotH=100

hotX1= 380
hotY1=400
hotW1=520
hotH1=100

hotX2= 380
hotY2=500
hotW2=520
hotH2=100

hotX3= 380
hotY3=600
hotW3=520
hotH3=100

hotX4= 380
hotY4=700
hotW4=520
hotH4=100


.SK21
circleX=MouseX()
circleY=MouseY()
Cls
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto SK1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto SK2
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX2,hotY2,hotW2,hotH2) Goto SK3
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX3,hotY3,hotW3,hotH3) Goto SK4
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX4,hotY4,hotW4,hotH4) Goto SK5
HGrundH=SPK
Delay 50
Goto SK21
.SK1
HGrundH=SPK1
If MouseDown(1) Then Goto SpielstandKopierenI1
Delay 50
Goto SK21
.SK2
HGrundH=SPK2
If MouseDown(1) Then Goto SpielstandKopierenI2
Delay 50
Goto SK21
.SK3
HGrundH=SPK3
If MouseDown(1) Then Goto SpielstandKopierenI3
Delay 50
Goto SK21
.SK4
HGrundH=SPK4
If MouseDown(1) Then Goto SpielstandUn
Delay 50
Goto SK21
.SK5
HGrundH=SPK5
If MouseDown(1) Then Goto Auswahl
Delay 50
Goto SK21
End

.SpielstandKopierenI1

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
End



.SpielstandKopierenI2
WarnungF$="Willst du wirklich deinen Spielstand mit der letzten Sicherungsdateien �berschreiben?"
WarnungA
If JaO=1 Then
Cls
If FileType(Name$+"BAK.txt") = 1 Then

DeleteFile ".\"+Name$+".txt"

quellpfad$ = ".\"+Name$+"BAK.txt"
zielpfad$ = ".\"+Name$+".txt"
CopyFile quellpfad$, zielpfad$
Print "Speilstand erfolgreich mit der Letzten Sicherungsdatei �berschrieben!"
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
End




.SpielstandKopierenI3
ClsVB
HGrundH=LoadImage (".\Bilder\Zugersee.jpg")
DrawImage HGrundH, 0,0
HGrundH=LoadImage (".\Bilder\Lava.jpg")
TileBlock HGrundH
FlushKeys
Schrift = LoadFont ("Arial",35,20100)
SetFont Schrift
Print "Gib bitte den Namen ein dessen Spielstand du auf deinen Spielstand kopieren willst."
NameS$ = Input()
filename$=NameS$
If FileType(filename$)=1 Then Goto SpielstandKopierenI3G
If FileType(filename$)=0 Then Goto Fehler
SpielstandKopierenA=0
Goto Auswahl
End


.Fehler
ClsVB
Schrift = LoadFont ("Arial",45,20100)
SetFont Schrift
ClsColor 253,202,13
Cls
Color 1,1,1
Print "Spielstand existiert nicht!"
Delay 3000
SpielstandKopierenA=0
Goto Auswahl
End


.SpielstandKopierenI3G
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
End






.Help
Graphics 1280,1024,0,2

ClsColor 255,201,14
Repeat
Cls
Locate 1,1

Schrift = LoadFont ("Arial",45,20100)
SetFont Schrift
Color 1,1,1

Datei$=".\Help.txt"
DateiID = ReadFile(Datei$)
While Not Eof(DateiID)
Print ReadLine$(DateiID)
Wend
ClsColor 255,255,255
HelpK$=Input()
If HelpK$="11" Then Goto Auswahl
ClsColor 255,201,14
Cls
Locate 1,1
Datei$=".\Help"+HelpK$+".txt"
DateiID = ReadFile(Datei$)
While Not Eof(DateiID)
Print ReadLine$(DateiID)
Wend
Input()
Forever
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
WarnungF$="Willst du wirklich deinen Spielstand mit allen Sicherungsdateien l�schen?"
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


.Karte
ClsVB
HGrundH=LoadImage (".\Bilder\Karte.jpg")
DrawImage HGrundH, 0,0
WaitKey ()
Goto Programmstart
End



;Programmstart
.Programmstart
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
Goto Vorfilm
End


.Teil1
ClsVB
FY=720
FX=500
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\H�le1.jpg")
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
HGrundSF=LoadImage (".\Bilder\H�le2&4.jpg")
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
HGrundSF=LoadImage (".\Bilder\H�le3.jpg")
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
HGrundSF=LoadImage (".\Bilder\H�le2&4.jpg")
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
HGrundSF=LoadImage (".\Bilder\H�le5.jpg")
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
FY=950
FX=520
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\H�le6.jpg")
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


ClsVB
FY=375
FX=20
G=1
SFGG=0
GZSFG
HGrundSFOS=LoadImage (".\Bilder\Br�cke.jpg")
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
HGrundSFOS=LoadImage (".\Bilder\Br�cke.jpg")
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
HGrundSFOS=LoadImage (".\Bilder\Br�cke.jpg")
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
Until SFGG=3
Goto Aufgabe6
End



.Teil7
ClsVB
FY=200
FX=874
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\Br�cke.jpg")
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
FX=580
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
Goto Aufgabe8
End

.Teil13
ClsVB
FY=950
FX=675
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\07.jpg")
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
Goto Aufgabe8
End

.Teil14
ClsVB
FY=950
FX=675
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\08.jpg")
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
Goto Aufgabe8
End

.Teil15
ClsVB
FY=950
FX=675
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
Until SFGG=4
Goto Aufgabe8
End

.Teil16
ClsVB
FY=950
FX=675
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\10jpg")
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
Goto Aufgabe8
End

.Teil17
ClsVB
FY=950
FX=675
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
Until SFGG=4
Goto Aufgabe8
End

.Teil18
ClsVB
FY=950
FX=675
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\12.jpg")
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
Goto Aufgabe8
End

.Teil19
ClsVB
FY=950
FX=675
G=1
SFGG=0
GZSFG
HGrundSF=LoadImage (".\Bilder\13.jpg")
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
Goto Aufgabe8
End

.Teil20
End


.Aufgabe1
ClsVB
ClsColor 253,202,13
Cls
Schrift = LoadFont ("Arial",130,201)
SetFont Schrift
Print "Plusrechnen"
Schrift = LoadFont ("Arial",40,201)
SetFont Schrift
Print ""
Print "Rechne die volgenden Rechnungen aus.
Print "Du musst mindestens 17 vun zwanzig Rechnungen richtig l�sen,"
Print "damit du wieter zur n�chsten Aufgabe kommst."
Print ""
Print "Viel Gl�ck!"
Input()
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
Schrift = LoadFont ("Arial",30,20100)
SetFont Schrift
Color 255,255,255
Cls
Locate 1,1
SeedRnd MilliSecs()
Falsch=0
Richtig=0
Aufgabe=0
;Hier wird dei Spielfigur f�r Teil1a oder Teil1S gelagden!
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
Delay 2000
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
Until Aufgabe > 20


.Aufgabe1b
Cls
Locate 1,1
FlushKeys
FlushMouse
Print "Du hast "+ Richtig+ " Aufgaben richtig gel�st!"
If Richtig<17 Then Print "Du hast zu viele Fehler, versuche die Aufgabe nochmals!" Delay 4000 Goto Aufgabe1
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
Schrift = LoadFont ("Arial",130,201)
SetFont Schrift
Print "W�rterdiktat"
Schrift = LoadFont ("Arial",40,201)
SetFont Schrift
Print ""
Print "Zuerst wird ein Wort je nach Schwierikeitsstufe
Print "0.75 bis 3 Sekunden lang gezeigt, dann wird es gel�scht."
Print "Du musst es dann fehlerfrei schreiben (und Enter dr�cken)."
Print ""
Print "Viel Gl�ck!"
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
ClsVB
ClsColor 255,0,0
Cls
Color 255,255,255 
DrawImage HGrundH, 0,0
Locate 1,1
Schrift = LoadFont ("Arial",24)
SetFont Schrift
Falsch=0 : Richtig=0 : Aufgabe=0
Restore Woerter2
 ;Einleseschlaufe f�r 140 W�rter
      Const Maxs = 139
Dim Wort$(Maxs)

  Delay 1000
ClsColor 0,0,0
Cls
            

.Woerter2


DrawImage HGrundH, 200,0

Data "ihm", "ihn", "ihr", "ihnen", "riechen", "fernsehen", "bezahlen"
Data "ruhig", "mehr", "mehrere", "wohnen", "w�hrend", "stehen", "schief"
Data "sehr", "nehmen", "ehrlich", "fr�hlich", "allm�hlich", "fahren", "tief"
Data "�hnlich", "wahr", "gef�hrlich", "gehen", "ohne", "wohl", "zuviel"
Data "erz�hlen", "bleiben", "bleibt", "blieb", "geblieben", "bringen", "bringt"
Data "brachte", "gebracht", "denken", "denkt", "dachte", "gedacht"
Data "erschrecken", "erschrickt", "erschrak", "erschrocken"
Data "essen", "isst", "ass", "gegessen", "fahren", "f�hrt", "fuhr", "gefahren"
Data "fallen", "f�llt", "fiel", "gefallen", "finden", "findet", "fand"
Data "gefunden", "fliegen", "fliegt", "flog", "geflogen", "geben", "gibt"
Data "gef�llt", "gefiel", "gehen", "geht", "ging", "gegangen"
Data "geschehen", "geschieht", "geschah", "haben", "hat", "hatte", "gehabt"
Data "halten", "h�lt", "hielt", "gehalten", "kommen", "kommt", "kam", "gekommen" 
Data "k�nnen", "kann", "konnte", "gekonnt", "laden", "l�dt", "lud", "geladen"
Data "laufen", "l�uft", "lief", "gelaufen", "legen", "legt", "legte", "gelegen"
Data "leiden", "leidet", "litt", "gelitten", "lesen", "liest", "las", "gelesen"
Data "liegen", "liegt", "lag", "gelegen", "messen", "misst", "mass", "gemessen"
Data "nehmen", "nimmt", "nahm", "genommen", "rufen", "ruft", "rief", "gerufen"
Data "schlafen", "schl�ft", "schlief", "geschlafen", "schreiben", "schreibt"
Data "schrieb", "geschrieben", "sehen" ,"h�ren" , "bemalen" , "arbeiten"

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
;DrawImage HGrundH1, 400,0
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
Until WortRichtig=1
WortRichtig=0
FlushKeys
FlushMouse
Until Worteraten = 20
;Spielstandsicherung
FlushKeys
FlushMouse
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
Schrift = LoadFont ("Arial", 70,2000)
SetFont Schrift
Print "Der Standhafte Zinnsoldat"
Schrift = LoadFont ("Arial", 23,40)
SetFont Schrift
Textverstentnis=0
Print "  Es waren einmal f�nfundzwanzig Zinnsoldaten, die waren alle Br�der, denn sie waren aus"
Print "  einem alten zinnernen L�ffel gemacht worden. Das Gewehr hielten sie"
Print "  im Arm und das Gesicht geradeaus; rot und blau, �beraus herrlich war die Uniform; das"
Print "  allererste, was sie in dieser Welt h�rten, als der Deckel von der"
Print "  Schachtel genommen wurde, in der sie lagen, war das Wort Zinnsoldaten. Das rief ein"
Print "  kleiner Knabe und klatschte in die H�nde; er hatte sie erhalten, denn es" 
Print "  war sein Geburtstag, und er stellte sie nun auf dem Tische auf. Der eine Soldat"
Print "  glich dem andern leibhaft, nur ein einziger war etwas anders; er hatte nur ein Bein,"
Print "  denn er war zuletzt gegossen worden, und da war nicht mehr Zinn genug da; doch stand"
Print "  er ebenso fest auf seinem einen Bein wie die andern auf ihren zweien, und"
Print "  gerade er war es, der sich bemerkbar machte. "
Print
Print
Print
Schrift = LoadFont ("Arial", 12,100)
SetFont Schrift
Print "Seite 1 von 7"
Schrift = LoadFont ("Arial", 23,40)
SetFont Schrift
WaitKey ()
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Print "  Auf dem Tisch, auf dem sie aufgestellt wurden, stand vieles andere Spielzeug; aber"
Print "  das, was am meisten in die Augen fiel, war ein niedliches Schloss von Papier;"
Print "  durch die kleinen Fenster konnte man gerade in die S�le hineinsehen. Drau�en vor ihm"
Print "  standen kleine B�ume rings um einen kleinen Spiegel, der wie ein kleiner"
Print "  See aussehen sollte. Schw�ne von Wachs schwammen darauf und spiegelten sich. Das war"
Print "  alles niedlich, aber das niedlichste war doch ein kleines M�dchen, das"
Print "  mitten in der offenen Schlosst�r stand; sie war auch aus Papier ausgeschnitten, aber"
Print "  sie hatte ein sch�nes Kleid und ein kleines, schmales, blaues Band �ber den"
Print "  Schultern, gerade wie ein Sch�rpe; mitten in diesem sa� ein gl�nzender Stern, gerade"
Print "  so gro� wir ihr Gesicht."
Print "  Das kleine M�dchen streckte seine beiden Arme aus, denn es war eine T�nzerin, und dann"
Print "  hob es das eine Bein so hoch empor, dass der Zinnsoldat es durchaus"
Print "  nicht finden konnte und glaubte, dass es gerade wie er nur ein Bein habe." 
Print " ,Das w�re eine Frau f�r mich', dachte er, aber sie ist etwas vornehm, sie wohnt in"
Print "  einem Schlosse, ich habe nur eine Schachtel, und da sind wir f�nfundzwanzig"
Print "  darin, das ist kein Ort f�r sie, doch ich muss suchen, Bekanntschaft mit ihr anzukn�pfen!'"
Print
Print
Print
Schrift = LoadFont ("Arial", 12,100)
SetFont Schrift
Print "Seite 2 von 7"
Schrift = LoadFont ("Arial", 23,40)
SetFont Schrift
WaitKey ()
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Print "  Und dann legte er sich, so lang er war, hinter eine Schnupftabaksdose,"
Print "  die auf dem Tische stand. Da konnte er recht die kleine, feine Dame betrachten, die fortfuhr"
Print "  auf einem Bein zu stehen, ohne umzufallen." 
Print "  Als es Abend wurde, kamen alle die andern Zinnsoldaten in ihre Schachtel, und die Leute im"
Print "  Hause gingen zu Bette. Nun fing das Spielzeug an zu spielen,"
Print "  sowohl ,Es kommt Besuch!' als auch ,Krieg f�hren' und ,Ball geben'; die Zinnsoldaten"
Print "  rasselten in der Schachtel, denn sie wollten mit dabei sein, aber sie"
Print "  konnten den Deckel nicht aufheben. Der Nussknacker schoss Purzelb�ume, und der Griffel"
Print "  belustigte sich auf der Tafel; es war ein L�rm, dass der Kanarienvogel"
Print "  davon erwachte und anfing mitzusprechen, und zwar in Versen. Die beiden einzigen, die"
Print "  sich nicht von der Stelle bewegten, waren der Zinnsoldat und die T�nzerin;"
Print "  sie hielt sich gerade auf der Zehenspitze und beide Arme ausgestreckt; er war ebenso"
Print "  standhaft auf seinem einen Bein; seine Augen wandte er keinen Augenblick"
Print "  von ihr weg."
Print "  Nun schlug die Uhr zw�lf, und klatsch, da sprang der Deckel von der Schnupftabaksdose"
Print "  auf, aber da war kein Tabak darin, nein, sondern ein kleiner, schwarzer"
Print "  Kobold." 
Print "  Das war ein Kunstst�ck!" 
Print "  Zinnsoldat sagte der Kobold, halte deine Augen im Zaum! Aber der Zinnsoldat"
Print
Print
Print
Schrift = LoadFont ("Arial", 12,100)
SetFont Schrift
Print "Seite 3 von 7"
Schrift = LoadFont ("Arial", 23,40)
SetFont Schrift
WaitKey ()
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Print "  tat, als ob er es nicht h�rte." 
Print "  Ja, warte nur bis morgen! sagte der Kobold." 
Print "  Als es nun Morgen wurde und die Kinder aufstanden, wurde der Zinnsoldat in das"
Print "  Fenster gestellt, und war es nun der Kobold oder der Zugwind, auf einmal flog"
Print "  das Fenster zu, und der Soldat st�rzte drei Stockwerke tief hinunter." 
Print "  Das war eine erschreckliche Fahrt. Er streckte das Bein gerade in die H�he und"
Print "  blieb auf der Helmspitze mit dem Bajonett abw�rts zwischen den Pflastersteinen"
Print "  stecken."
Print "  Das Dienstm�dchen und der kleine Knabe kamen sogleich hinunter, um zu suchen; aber"
Print "  obgleich sie nahe daran waren, auf ihn zu treten, so konnten sie ihn doch"
Print "  nicht erblicken. H�tte der Zinnsoldat gerufen: Hier Bin ich!, so h�tten sie ihn wohl"
Print "  gefunden, aber er fand es nicht passend, laut zu schreien, weil er in Uniform"
Print "  war." 
Print "  Nun fing es an zu regnen; die Tropfen fielen immer dichter, es ward ein ordentlicher"
Print "  Platzregen; als der zu Ende war, kamen zwei Stra�enjungen vorbei."
Print "  Sieh du! sagte der eine, da liegt ein Zinnsoldat! Der soll hinaus und segeln!" 
Print "  Sie machten ein Boot aus einer Zeitung, setzten den Soldaten mitten hinein, und nun"
Print "  segelte er den Rinnstein hinunter; beide Knaben liefen nebenher und"
Print "  klatschten in die H�nde. Was schlugen da f�r Wellen in dem Rinnstein, und welcher Strom"
Print
Print
Print
Schrift = LoadFont ("Arial", 12,100)
SetFont Schrift
Print "Seite 4 von 7"
Schrift = LoadFont ("Arial", 23,40)
SetFont Schrift
WaitKey ()
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Print "  war da! Ja, der Regen hatte aber auch gestr�mt. Das Papierboot"
Print "  schaukelte auf und nieder, mitunter drehte es sich so geschwind, dass der"
Print "  Zinnsoldat bebte; aber er blieb standhaft, verzog keine Miene, sah geradeaus und hielt"
Print "  das Gewehr im Arm." 
Print "  Mit einem Male trieb das Boot unter eine lange Rinnsteinbr�cke; da wurde es"
Print "  gerade so dunkel, als w�re er in seiner Schachtel." 
Print "  ,Wohin mag ich nun kommen?' dachte er. Ja, Ja, das ist des Kobolds Schuld! Ach, s��e"
Print "  doch das kleine M�dchen hier im Boote, da k�nnte es meinetwegen noch"
Print "  einmal so dunkel sein!' "
Print "  Da kam pl�tzlich eine gro�e Wasserratte, die unter der Rinnsteinbr�cke wohnte. "
Print "  Hast du einen Pass? fragte die Ratte. Her mit dem Passe!" 
Print "  Aber der Zinnsoldat schwieg still und hielt das Gewehr noch fester."
Print "  Das Boot fuhr davon und die Ratte hinterher. Hu, wie fletschte sie die Z�hne und"
Print "  rief den Holzsp�nen und dem Stroh zu: Halt auf! Halt auf! Er hat keinen Zoll"
Print "  bezahlt; er hat den Pass nicht gezeigt!" 
Print "  Aber die Str�mung wurde st�rker und st�rker! Der Zinnsoldat konnte schon da, wo"
Print "  das Brett aufh�rte, den hellen Tag erblicken, aber er h�rte auch einen"
Print "  brausenden Ton, der wohl einen tapfern Mann erschrecken konnte." 
Print "  Denkt nur, der Rinnstein st�rzte, wo die Br�cke endete, geradehinaus in einen"
Print "  gro�en Kanal; das w�rde f�r den armen Zinnsoldaten ebenso gef�hrlich gewesen"
Print "  Nun war er schon so nahe dabei, dass er nicht mehr anhalten konnte. Das Boot fuhr"
Print
Print
Print
Schrift = LoadFont ("Arial", 12,100)
SetFont Schrift
Print "Seite 5 von 7"
Schrift = LoadFont ("Arial", 23,40)
SetFont Schrift
WaitKey ()
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Print "  hinaus, der Zinnsoldat hielt sich so steif, wie er konnte; niemand sollte ihm"
Print "  nachsagen, dass er mit den Augen blinke. Das Boot schnurrte drei-, viermal herum und"
Print "  war bis zum Rande mit Wasser gef�llt, es musste sinken. Der Zinnsoldat"
Print "  stand bis zum Halse im Wasser, und tiefer und tiefer sank das Boot, mehr und mehr l�ste"
Print "  das Papier sich auf; nun ging das Wasser �ber des Soldaten Kopf. Da"
Print "  dachte er an die kleine, niedliche T�nzerin, die er nie mehr zu Gesicht bekommen"
Print "  sollte, und es klang vor des Zinnsoldaten Ohren das Lied:" 
Print "  ,Fahre, fahre Kriegsmann!"
Print "  Den Tod musst du erleiden!'"
Print "  Nun ging das Papier entzwei, und der Zinnsoldat st�rzte hindurch, wurde aber"
Print "  augenblicklich von einem gro�en Fisch verschlungen." 
Print "  Wie war es dunkel da drinnen!"
Print "  Da war es noch schlimmer als unter der Rinnsteinbr�cke, und dann war es so sehr"
Print "  eng; aber der Zinnsoldat war standhaft und lag, so lang er war, mit dem"
Print "  Gewehr im Arm."
Print "  Der Fisch fuhr umher, er machte die allerschrecklichsten Bewegungen; endlich"
Print "  wurde er ganz still, es fuhr wie ein Blitzstrahl durch ihn hin. Das Licht schien ganz"
Print "  klar, und jemand rief laut: Der Zinnsoldat! Der Fisch war gefangen worden, auf den"
Print "  Markt gebracht, verkauft und in die K�che hinaufgekommen, wo die"
Print "  K�chin ihn mit einem gro�en Messer aufschnitt. Sie nahm mit zwei Fingern den Soldaten"
Print
Print
Print
Schrift = LoadFont ("Arial", 12,100)
SetFont Schrift
Print "Seite 6 von 7"
Schrift = LoadFont ("Arial", 23,40)
SetFont Schrift
WaitKey ()
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Print "  mitten um den Leib und trug ihn in die Stube hinein, wo alle den"
Print "  merkw�rdigen Mann sehen wollten, der im Magen eines Fisches herumgereist war; aber der"
Print "  Zinnsoldat war gar nicht stolz. Sie stellten ihn auf den Tisch und"
Print "  da - wie sonderbar kann es doch in der Welt zugehen! Der Zinnsoldat war in derselben"
Print "  Stube, in der er fr�her gewesen war, er sah dieselben Kinder, und das"
Print "  gleiche Spielzeug stand auf dem Tische, das herrliche Schloss mit der"
Print "  niedlichen, kleinen T�nzerin. Die hielt sich noch auf dem einen Bein und hatte das andere"
Print "  hoch in der Luft, sie war auch standhaft. Das r�hrte den Zinnsoldaten, er war nahe"
Print "  daran, Zinn zu weinen, aber es schickte sich nicht. Er sah sie an, aber sie"
Print "  sagten gar nichts." 
Print "  da nahm der eine der kleinen Knaben den Soldaten und warf ihn gerade in den Ofen,"
Print "  obwohl er gar keinen Grund daf�r hatte; es war sicher der Kobold in der"
Print "  Dose, der schuld daran war." 
Print "  Der Zinnsoldat stand ganz beleuchtet da und f�hlte eine Hitze, die erschrecklich"
Print "  war; aber ob sie von dem wirklichen Feuer oder von der Liebe herr�hrte, das"
Print "  wusste er nicht. Die Farben waren ganz von ihm abgegangen - ob das auf der Reise"
Print "  geschehen oder ob der Kummer daran schuld war, konnte niemand sagen."
Print "  Er sah das kleine M�dchen an, sie blickte ihn an, und er f�hlte, dass er schmelze,"
Print "  aber noch stand er standhaft mit dem Gewehre im Arm. Da ging eine T�r auf,"
Print "  der Wind ergriff die T�nzerin, und sie flog, einer Sylphide gleich, gerade in den"
Print "  Ofen zum Zinnsoldaten, loderte in Flammen auf und war verschwunden."
Print "  Da schmolz der Zinnsoldat zu einem Klumpen, und als das M�dchen am folgenden Tage"
Print "  die Asche herausnahm, fand sie ihn als ein kleines Zinnherz; von der"
Print "  T�nzerin hingegen war nur der Stern noch da, und der war kohlschwarz gebrannt." 
Print
Print
Print
Schrift = LoadFont ("Arial", 12,100)
SetFont Schrift
Print "Seite 7 von 7"
Schrift = LoadFont ("Arial", 23,40)
SetFont Schrift
WaitKey ()
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Print "In wen war der Zinnsoldat mit nur einem Bein verliebt?"
Zinnsoldat1$ = Input()
If Zinnsoldat1$ = "In die T�nzerin"Then Print "Richtig 2P" Textverstentnis=2 Goto ZinnB
If Zinnsoldat1$ = "In die Tenzerin"Then Print "Richtig aber die Rechschreibung nicht! 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto ZinnB
If Zinnsoldat1$ = "T�ntzerin"Then Print "Richtig aber die Rechschreibung nicht! 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto ZinnB
If Zinnsoldat1$ = "In die T�ntzerin"Then Print "Richtig aber die Rechschreibung nicht! 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto ZinnB
If Zinnsoldat1$ = "Tenzerin"Then Print "Richtig aber die Rechschreibung nicht! 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto ZinnB
If Zinnsoldat1$ = "T�nzerin"Then Print "Richtig 2P" Delay 3000 Textverstentnis =2 Goto ZinnB
If Zinnsoldat1$ = "In die Ballerina"Then Print "Richtig 2P" Delay 3000 Textverstentnis =2 Goto ZinnB
If Zinnsoldat1$ = "Ballerina"Then Print "Richtig 2P" Delay 3000 Textverstentnis =2 Goto ZinnB
Print "Falsch!"
Delay 3000
Goto ZinnB 
End
.ZinnB
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Print "Wie viele Zinnsoldaten hatte der Junge in seinem Zinner?"
Zinnsoldat2$ = Input()
If Zinnsoldat2$ = "50" Then Print "Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto ZinnC
If Zinnsoldat2$ = "F�nfzig" Then Print "Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto ZinnC
If Zinnsoldat2$ = "f�nfzig" Then Print "Richtig 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto ZinnC
Print "Falsch"
Goto ZinnC
End
.ZinnC
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Print "Was dachte der Zinnsoldaten als das Boot untergieng?"
Zinnsoldat3$ = Input()
If Zinnsoldat3$ = "Er dachte, dass er die T�ntzerin nie wieder sehen w�rde" Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto Zinnvergleich1
If Zinnsoldat3$ = "Er dachte an die T�nzerin" Then Print " Fast Richtig aber die Rechtschriebung nicht 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto Zinnvergleich1
If Zinnsoldat3$ = "Er dachte dass er die Tentzerin nie wieder sehen w�rde" Then Print"Richtig aber die Rechtschriebung nicht 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto Zinnvergleich1
If Zinnsoldat3$ = "dass er die T�ntzerin nie wieder sehen w�rde" Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto Zinnvergleich1
If Zinnsoldat3$ = "An die T�nzerin"Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto Zinnvergleich1
If Zinnsoldat3$ = "T�nzerin"Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto Zinnvergleich1
Print "Falsch!"
Goto Zinnvergleich1 
End
.Zinnvergleich1
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
If Textverstentnis = 0 Then Print "Lese bitte die Geschichte Bitte Sp�ter noch einmahl etwas genauer!" Delay 3000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
If Textverstentnis = 1 Then Print "Lese bitte die Geschichte Bitte Sp�ter noch einmahl etwas genauer!" Delay 3000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
If Textverstentnis = 2 Then Goto ZinnD
If Textverstentnis = 3 Then Goto ZinnD
If Textverstentnis = 4 Then Goto ZinnD
If Textverstentnis = 5 Then Goto ZinnD
If Textverstentnis = 6 Then Print "Du hast die Geschichte sehr gut gelesen!" Delay 3000 Goto PunkteZinn
End
.ZinnD
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
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
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
If Textverstentnis = 2 Then Print "Lese bitte die Geschichte Bitte Sp�ter noch einmahl etwas genauer!" Delay 3000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
If Textverstentnis = 3 Then Print "Lese bitte die Geschichte Bitte Sp�ter noch einmahl etwas genauer!" Delay 3000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
If Textverstentnis = 4 Then Goto ZinnE
If Textverstentnis = 5 Then Goto ZinnE
If Textverstentnis = 6 Then Print "Du hast die Geschichte gut gelesen!" Delay 3000 Goto PunkteZinn
If Textverstentnis = 7 Then Print "Du hast die Geschichte sehr gut gelesen!" Delay 3000 Goto PunkteZinn
End
.ZinnE
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
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
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
If Textverstentnis = 4 Then Print "Lese bitte die Geschichte Bitte sp�ter noch einmal etwas genauer!" Delay 3000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
If Textverstentnis = 5 Then Print "Lese bitte die Geschichte Bitte sp�ter noch einmal etwas genauer!" Delay 3000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
If Textverstentnis = 6 Then Print "Du hast die Geschichte gut gelesen!" Delay 3000 Goto PunkteZinn
If Textverstentnis = 7 Then Print "Du hast die Geschichte sehr gut gelesen!" Delay 3000 Goto PunkteZinn
Goto Programmstart
End

.PunkteZinn
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=Aufgaben+1
Smeili=1
Goto Programmstart
End


.Aufgabe4
Goto Nomen
End

.Nomen
ClsVB
PauseChannel HGM
FlushKeys
Nomen = 0   Nomen1 = 0    Nomen2 = 0 
HGrundH=LoadImage (".\Bilder\SElba.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,0,0

Print"Erkenne das Nomen in dem folgenden Satz."
Print"Schreibe das Nomen und dr�cke Enter"
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
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "Satz"

Print "Welcher Artikel hat das Nomen?"
Print"Schreibe der, die oder das und dr�cke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "der" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
Nomen1 = Nomen1 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "der"

Print
Print "Schreibe die Mehrzahl von (Satz) und dr�cke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "S�tze" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
Nomen2 = Nomen2 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "S�tze"
Print

;Brief
Cls 
Locate 1,1
HGrundH=LoadImage (".\Bilder\SElba.jpg")
DrawImage HGrundH, 0,0
Nomen = 0   Nomen1 = 0    Nomen2 = 0   
Print"Erkenne das Nomen in dem folgenden Satz."
Print"Schreibe das Nomen und dr�cke Enter"
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
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "Brief"

Print
Print "Welcher Artikel hat das Nomen?"
Print"Schreibe der, die oder das und dr�cke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "der" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"Nomen1 = Nomen1 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "der"

Print
Print "Schreibe die Mehrzahl von (Brief) und dr�cke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "Briefe" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"Nomen2 = Nomen2 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "Briefe"
Print

;Tagebuch
Cls 
Locate 1,1
HGrundH=LoadImage (".\Bilder\SElba.jpg")
DrawImage HGrundH, 0,0
Nomen = 0   Nomen1 = 0    Nomen2 = 0 
Print"Erkenne das Nomen in dem folgenden Satz."
Print"Schreibe das Nomen und dr�cke Enter"
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
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "Tagebuch"

Print
Print "Welcher Artikel hat das Nomen?"
Print"Schreibe der, die oder das und dr�cke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "das" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"Nomen1 = Nomen1 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "das"

Print
Print "Schreibe die Mehrzahl von (Tagebuch) und dr�cke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "Tageb�cher" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"Nomen2 = Nomen2 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "Tageb�cher"
Print

;Dorf
Cls 
Locate 1,1
HGrundH=LoadImage (".\Bilder\SElba.jpg")
DrawImage HGrundH, 0,0
Nomen = 0   Nomen1 = 0    Nomen2 = 0 
Print"Erkenne das Nomen in dem folgenden Satz."
Print"Schreibe das Nomen und dr�cke Enter"
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
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "Dorf"

Print
Print "Welcher Artikel hat das Nomen?"
Print"Schreibe der, die oder das und dr�cke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "das" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"Nomen1 = Nomen1 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "das"

Print
Print "Schreibe die Mehrzahl von (Dorf) und dr�cke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "D�rfer" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"Nomen2 = Nomen2 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "D�rfer"
Print
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=Aufgaben+1
Smeili=2
Goto Programmstart
End







.Aufgabe5
ClsVB
; (c) Graham Kennedy
AppTitle "Laborint"
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
	mc\img = LoadAnimImage("mazeblocks.png",32,32,0,16)
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
	maze_startup("mazeblocks.png",16,16)

	mwidth = 32; 	set a variable for the width 
	mheight = 32;	and the height of the maze


	SetBuffer BackBuffer()

	
	
	finished = 0
	x = 0
	y = 0
	
	
	a$="n"
	k = Asc(a$)
.StartL
	a$="n"
	 Looo=0
	While Not finished
		Cls
		
		If a$ = "n" Then
			If m.maze <> Null Then maze_Delete(m)
			m.maze = maze_create(mwidth,mheight,MilliSecs(),0)
			x = 0
			y = 0		
		End If
		
		If a$="r" And x <> mwidth-1 And y <> mheight-1 Then
			maze_clearRoute(m)
			maze_solve(m,x,y,mwidth-1,mheight-1)
		End If
		
		If a$="s" Then  maze_save(m,"maze.maz")
		If a$="l" Then
			maze_delete(m)
			m = maze_load("maze.maz")
		End If
		
		If a$ = "c" Then maze_clearroute(m)
		
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
		maze_drawincell(x,y,255,255,255)
						Text 520,0, "Bewege dich mit den Pfeiltasten!"
		Text 520,30,"X = Zum Spiel"
		Text 520,60,"N = Neues Labyrinth"
		Text 520,90,"R = Zeig mir die L�sung"
		Text 520,120,"C = L�sungen nicht mehr anzeigen"
		Text 520,150,"S = Labyrinth sichern"
		Text 520,180,"L = Gesichertes Labyrinth laden"
		Flip

		If k = 13 Then
			SaveBuffer(FrontBuffer(),"maze.bmp") 
		End If

		k = WaitKey()
		a$ = Lower$(Chr$(k))
		If a$ = "x" Then Goto Teil6
If x=31 And y=31 Then
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=Aufgaben+1
Goto Teil6
EndIf
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

;Einleseschlaufe f�r 137 W�rter
      Const Max = 136
Dim Wort$(Max)
Print "Errate das Wort indem du einzelne"
Print "Buchstaben vorschl�gst."
Print "Die ? geben dier an, wieviele Buchstaben das Wort hat."
Print "Du kannst nur einen Buchstaben auf einmahl erraten."
Print "Tipp: alle W�rter sind Verben."

.Woerter
Data "ihm", "ihn", "ihr", "ihnen", "riechen", "fernsehen", "bezahlen"
Data "ruhig", "mehr", "mehrere", "wohnen", "w�hrend", "stehen", "schief"
Data "sehr", "nehmen", "ehrlich", "fr�hlich", "allm�hlich", "fahren", "tief"
Data "�hnlich", "wahr", "gef�hrlich", "gehen", "ohne", "wohl", "zuviel"
Data "erz�hlen", "bleiben", "bleibt", "blieb", "geblieben", "bringen", "bringt"
Data "brachte", "gebracht", "denken", "denkt", "dachte", "gedacht"
Data "erschrecken", "erschrickt", "erschrak", "erschrocken"
Data "essen", "isst", "ass", "gegessen", "fahren", "f�hrt", "fuhr", "gefahren"
Data "fallen", "f�llt", "fiel", "gefallen", "finden", "findet", "fand"
Data "gefunden", "fliegen", "fliegt", "flog", "geflogen", "geben", "gibt"
Data "gef�llt", "gefiel", "gehen", "geht", "ging", "gegangen"
Data "geschehen", "geschieht", "geschah", "haben", "hat", "hatte", "gehabt"
Data "halten", "h�lt", "hielt", "gehalten", "kommen", "kommt", "kam", "gekommen" 
Data "k�nnen", "kann", "konnte", "gekonnt", "laden", "l�dt", "lud", "geladen"
Data "laufen", "l�uft", "lief", "gelaufen", "legen", "legt", "legte", "gelegen"
Data "leiden", "leidet", "litt", "gelitten", "lesen", "liest", "las", "gelesen"
Data "liegen", "liegt", "lag", "gelegen", "messen", "misst", "mass", "gemessen"
Data "nehmen", "nimmt", "nahm", "genommen", "rufen", "ruft", "rief", "gerufen"
Data "schlafen", "schl�ft", "schlief", "geschlafen", "schreiben", "schreibt"
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
Print "Du kannst nur einen Buchstaben auf einmahl erraten!"
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
  ; Pr�fen auch auf Mehrfachvorkommen
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
Print "H�zlichen Gl�ckwunsch!"
Print "Du hast das Wort in "+Versuche+" Versuche herausefunden!"
Input()
Else
Print "Das Wort w�hre "+Zufall$+" gewesen!"
Print ""
Print "Du hast das Wort leider nicht in 10 Versuche herausgevunden."
Print "Versuche die Aufgabe erneut."
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
Goto Verben
End


.Verben
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
Print"Schreibe das Verb und dr�cke Enter"
Print
Print "Der Kluge f�hrt im Zug."

Repeat
Ratwort1$ = Input()
If Ratwort1$ = "f�hrt" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
Verben = Verben +1
PlayMusic (".\Sounds\Door1.mp3")
EndIf
If Verben=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "f�hrt"
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
If Verben1=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "fahren"
Print
Print "Und wie heisst das Verb in Pr�teritum?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "fuhr" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben2 = Verben2 +1
EndIf
If Verben2=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "fuhr"
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
Print"Schreibe das Verb und dr�cke Enter"
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
If Verben=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
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
If Verben1=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "zeichnen"
Print
Print "Und wie heisst das Verb in Pr�teritum?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "zeichnete" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben2 = Verben2 +1
EndIf
If Verben2=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
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
Print"Schreibe das Verb und dr�cke Enter"
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
If Verben=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
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
If Verben1=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "kennen"
Print
Print "Und wie heisst das Verb in Pr�teritum?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "kannte" Then
  Print "kannte!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben2 = Verben2 +1
EndIf
If Verben3=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "kannte"
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
Print"Schreibe das Verb und dr�cke Enter"
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
If Verben=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
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
If Verben1=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart

Until Ratwort1$ = "heissen"
Print
Print "Und wie heisst das Verb in Pr�teritum?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "hiess" Then
  Print "kannte!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben2 = Verben2 +1
EndIf
If Verben2=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "hiess"
Print
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
Schrift = LoadFont ("Arial",45,20100)
SetFont Schrift
Print "Beschrieb"
Schrift = LoadFont ("Arial",24)
SetFont Schrift
Print "Nachdem du Enter dr�ckst h�rst du ein Lied."
Print "Nach dem Lied kommst du auf ein Textfeld in das du die genaue Anzahl Sekunden der Lieddauer aufschreiben musst."
Print "Mit einem Druck auf Enter erscheint unter dem Textfeld Richtig! oder gar nichts.
Print "Gar nichts bedeutet Falsch!"
Print "Mit einem weiteren Druck auf Enter h�rst du dann wieder ein Lied."
Print "So geht es noch zehn mal weiter bis du dann schliesslich wieder zum Spiel kommst.
Print "Achtung!
Print "Wenn du mehr als drei von zehn Aufgaben falsch hast kommst du wieder genau zu diesem Text den du jetzt liest!
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
Print "Du hast "+ RichtigLZ+" Aufgaben gel�st!"
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
Cls
Locate 1,1
Witze=0
Color 0,255,255 
Schrift = LoadFont ("Arial",45,20100)
SetFont Schrift
FlushKeys
FlushMouse
Color 255,0,0
Print "Beschrieb"
Schrift = LoadFont ("Arial",24)
SetFont Schrift
Print "Diese Aufgabe ist zum Entspannen gedacht."
Print "Mit einem Druck auf Enter erscheint ein Witz."
Print "Wenn du dann nochmals auf Enter dr�ckst erscheint ein weiterer Witz."
Print "So geht es immer weiter bis du 10 Witze gelesen hast."
WaitKey ()
ClsColor 255,0,0
Cls
Color 255,255,255 
Locate 1,1
Schrift = LoadFont ("Arial",24)
SetFont Schrift
Aufgabe=0
Restore Woerter2W
 ;Einleseschlaufe f�r 30 W�rter
      Const MaxsW = 29
Dim Wort$(MaxsW)
ClsColor 1,1,1

            

.Woerter2W


Data 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30


For i = 0 To MaxsW
  ;
Read Wort$(i)
Next

Repeat
Repeat
; Zufallsschlaufe 
    SeedRnd MilliSecs() 
    Zufall$ = Wort$(Rand(0,MaxsW))
Until ZufallVer<>Zufall
ZufallVer=Zufall


ClsColor 255,201,14
Cls


If Zufall=1 Then Print "Die Familie macht einen Ausflug mit dem"
If Zufall=1 Then Print "Zug in die Berge. Auf dem Bahnhof in M�nchen"
If Zufall=1 Then Print "hat der Zug etwas l�nger Aufenthalt."
If Zufall=1 Then Print "Auf dem Bahnsteig geht ein Mann"
If Zufall=1 Then Print "mit einem Imbisswagen entlang und ruft laut:"
If Zufall=1 Then Print "Heisse W�rstchen! Heisse W�rstchen!"
If Zufall=1 Then Print "Da �ffnet Paul das Fenster und ruft hinaus:"
If Zufall=1 Then Print "K�nnten Sie nicht still sein? Uns"
If Zufall=1 Then Print "interessiert es nicht, wie Sie heissen."

If Zufall=2 Then Print "Ostfriesische Klassenfahrt: Ein ostfriesischer"
If Zufall=2 Then Print "Lehrer wartet mit seinen Sch�lern der 3. Klasse"
If Zufall=2 Then Print "auf dem Bahnsteig. Einen Zug nach dem anderen"
If Zufall=2 Then Print "l�sst er passieren, ohne mit seiner Klasse"
If Zufall=2 Then Print "einzusteigen. Schliesslich platzt ihm der Kragen:"
If Zufall=2 Then Print "Den n�chsten nehmen wir, Kinder. Auch wenn wieder"
If Zufall=2 Then Print "nur 1. und 2. Klasse draufsteht."

If Zufall=3 Then Print "Abschlusspr�fung auf der Polizeiakademie."
If Zufall=3 Then Print "Die Anw�rter werden einzeln der Pr�fungskommission"
If Zufall=3 Then Print "vorgef�hrt. Den ersten fragt der Pr�fer: Licht oder"
If Zufall=3 Then Print "Schall? Schall! Warum denn das,fragt der Vorsitzende?"
If Zufall=3 Then Print "Nun, wenn ich meinen Fernseher anmache, kommt auch "
If Zufall=3 Then Print "erst der Ton, und .... Durchgefallen! der N�chste"
If Zufall=3 Then Print "bitte. Was ist schneller, Licht oder Schall?"
If Zufall=3 Then Print "Licht! Und warum? Wenn ich mein Radio anmache"
If Zufall=3 Then Print "geht auch zuerst das Licht und ...Durchgefallen, "
If Zufall=3 Then Print "raus. Der N�chste, bitte. Was ist schneller Licht"
If Zufall=3 Then Print "oder Schall? Licht, ist doch klar! Aha.Und warum?"
If Zufall=3 Then Print "Nun, die Augen sind doch am Kopf viel weiter"
If Zufall=3 Then Print "vorn als die Ohren..."

If Zufall=4 Then Print "Der Lehrer: Lukas, warum kommst du schon "
If Zufall=4 Then Print "wieder zu sp�t? "
If Zufall=4 Then Print "Ich habe von einem Fussballspiel getr�umt. "
If Zufall=4 Then Print "Das ist doch kein Grund, zu sp�t zukommen!"
If Zufall=4 Then Print "Doch! Es gab Verl�ngerung!"

If Zufall=5 Then Print "H�ren Sie mal zu, sagt der Polizist zum Golfspieler,"
If Zufall=5 Then Print "ihr Ball ist auf die Strasse geflogen und hat"
If Zufall=5 Then Print "dort die Frontscheibe eines Feuerwehrwagens im"
If Zufall=5 Then Print "Einsatz zertr�mmert, der deswegen gegen eine "
If Zufall=5 Then Print "Mauer geprallt ist. Das Haus, das gel�scht werden "
If Zufall=5 Then Print "sollte ist bis auf die Grundmauer niedergebrannt"
If Zufall=5 Then Print "Was haben Sie zu diesem Schlamassel zu sagen?"
If Zufall=5 Then Print "Golfer: Wo ist mein Golfball!"

If Zufall=6 Then Print "M�xchen sitzt auf dem Brunnenrand und heult."
If Zufall=6 Then Print "Kommt ein Polizist dazu und fragt, was los sei."
If Zufall=6 Then Print "Meine Muter ist in den Brunnen gefallen, schluchst"
If Zufall=6 Then Print "M�xchen. Der Polizist zieht sich sofort Uniform"
If Zufall=6 Then Print "und Schuhe aus und st�rzt sich in den Brunnen."
If Zufall=6 Then Print "Nach einigen Minuten kommt er wieder heraus, hat"
If Zufall=6 Then Print "aber die Mutter nicht gefunden. Sagt das M�xchen:"
If Zufall=6 Then Print "Na toll, dann kann ich ja die bl�de Schraube"
If Zufall=6 Then Print "auch wegwerfen!"

If Zufall=7 Then Print "Ein Mann sitzt in der Kneipe und bestellt sich"
If Zufall=7 Then Print "ein Bier.Der Kellner bringt dem bereits ziemlich"
If Zufall=7 Then Print "betrunkenen Mann das Bier und stellt es auf einen"
If Zufall=7 Then Print "Bierdeckel auf den Tisch.Nach 10 Minuten bestellt"
If Zufall=7 Then Print "der Mann wieder ein Bier. Der Kellner bringt es"
If Zufall=7 Then Print "aber der Bierdeckel ist weg, also legt er einen"
If Zufall=7 Then Print "neuen unters Bier. Nach weiteren 10 Minuten bestellt"
If Zufall=7 Then Print "der Mann wieder ein Bier. Wieder ist der Bierdeckel"
If Zufall=7 Then Print "weg. Der Kellner legt wieder einen neuen unter das"
If Zufall=7 Then Print "Bier. Schliesslich bestellt der Mann das 3.Mal ein"
If Zufall=7 Then Print "Bier, aber wieder ist der Bierdeckel weg. Der"
If Zufall=7 Then Print "Kellner hat die Schanauze voll und legt keinen"
If Zufall=7 Then Print "neuen unters Bier. Beschwert sich der Mann:"
If Zufall=7 Then Print "Wo bleibt der Keks?"

If Zufall=8 Then Print "Sch�n, dass du gekommen bist, Tante Ottilie, sagte"
If Zufall=8 Then Print "Florian artig. Gestern erst hat Papa gesagt:"
If Zufall=8 Then Print "Tante Ottilie fehlt uns gerade noch!"

If Zufall=9 Then Print "Mama, darf ich ein bisschen mit Opa spielen?"
If Zufall=9 Then Print "Nein der Sarg bleibt heute zu."

If Zufall=10 Then Print "Polizist: Herzlichen Gl�ckwunsch. Sie sind"
If Zufall=10 Then Print "der 100 000ste Autofahrer, der diese neue"
If Zufall=10 Then Print "Autobahn bef�hrt, und Sie bekommen als Preis"
If Zufall=10 Then Print "20 000 Euro! Was m�chten Sie mit diesem Geld"
If Zufall=10 Then Print "anfangen? Vater: Dann mach ich mir mal zuerst"
If Zufall=10 Then Print "den F�hrerschein. Mutter: H�ren Sie nicht auf"
If Zufall=10 Then Print "ihn, er ist total betrunken. Der schwerh�rige"
If Zufall=10 Then Print "Opa: Ich habe euch doch gleich gesagt, dass"
If Zufall=10 Then Print "es keine gute Idee war, das Auto zu stehlen."
If Zufall=10 Then Print "Eine Stimme aus dem Kofferraum: Sind wir "
If Zufall=10 Then Print "schon hinter der Grenze?"

If Zufall=11 Then Print "Fragt der Lehrer: Wer kann mir Tiere nennen,"
If Zufall=11 Then Print "die bei uns leben?"
If Zufall=11 Then Print "Mariechen streckt den Finger und z�hlt auf:"
If Zufall=11 Then Print "Eselchen,Pferdchen,Sch�fchen..."
If Zufall=11 Then Print "Der Lehrer unterbricht: Lass doch bitte das"
If Zufall=11 Then Print ">chen< weg!"
If Zufall=11 Then Print "Mariechen f�hrt fort: Kanin,Eichhorn..."

If Zufall=12 Then Print "Fritzchen geht mit seiner Oma in die Stadt."
If Zufall=12 Then Print "Vor dem Supermarkt findet er eine Zehnfrankennote."
If Zufall=12 Then Print "Als er sie aufheben will, sagt die Oma: Was auf"
If Zufall=12 Then Print "dem Boden liegt, darf man nicht aufheben!"
If Zufall=12 Then Print "Sie gehen weiter. Fritzchen findet eine"
If Zufall=12 Then Print "Zwanzigfrankennote. Die Oma sagt wieder: Was auf"
If Zufall=12 Then Print "dem Boden liegt, darf man nicht aufheben!"
If Zufall=12 Then Print "Auf dem R�ckweg f�llt die Oma hin. Fritzchen,"
If Zufall=12 Then Print "hilf mir doch aufzustehen! Da sagt dieser: Was"
If Zufall=12 Then Print "auf dem Boden liegt, darf man nicht aufheben!"

If Zufall=13 Then Print "Ein Amerikaner machte eine Stadtrundfahrt durch"
If Zufall=13 Then Print "Paris und l�sst sich die Attraktionen zeigen."
If Zufall=13 Then Print "Am Triumphbogen erz�hlt ihm der franz�sische"
If Zufall=13 Then Print "Taxifahrer, dass dieser Bogen ein wahres Wunderwerk"
If Zufall=13 Then Print "sei, 20 000t schwer. Der Amerikaner fragt, wie lange"
If Zufall=13 Then Print "der Bau dieses Monuments gedauert habe. Als er"
If Zufall=13 Then Print "erf�hrt, dass es 15 Jahre gedauert hat, lachte er nur"
If Zufall=13 Then Print "und sagte: Ach in Amerika brauchen wir f�r so etwas"
If Zufall=13 Then Print "h�chstens 15 Tage. Der Franzose ist schon etwas"
If Zufall=13 Then Print "eingeschnappt. Am Louvre angelangt, das gleiche"
If Zufall=13 Then Print "Spiel. Der Franzose nennt die Bauzeit von 20 Jahren."
If Zufall=13 Then Print "Daraufhin behauptet der Amerikaner: Ach, in"
If Zufall=13 Then Print "Amerika brauchen wir f�r sowas h�chstens 20 Tage."
If Zufall=13 Then Print "Schliesslich kommen sie zum Eiffelturm. Donnerwetter,"
If Zufall=13 Then Print "staunt der Amerikaner, was ist denn das? Der"
If Zufall=13 Then Print "Franzose daraufhin:Keine Ahnung, stand gestern"
If Zufall=13 Then Print "noch nicht da!"

If Zufall=14 Then Print "Das Thema des Deutschaufsatzes lautet: Mein"
If Zufall=14 Then Print "Lieblingstier. Simone schreibt: Unser Hund ist"
If Zufall=14 Then Print "super. Er ist der beste Hund der Welt. Er sucht"
If Zufall=14 Then Print "St�ckchen, springt sehr hoch und bringt uns jeden"
If Zufall=14 Then Print "Morgen die Zeitung, obwohl wir gar keine"
If Zufall=14 Then Print "abonniert haben."

If Zufall=15 Then Print "Moritz sagt beim Abendessen zu seinem Vater:"
If Zufall=15 Then Print "Vater, ich muss dir was sagen! Der Vater:"
If Zufall=15 Then Print "Nein, jetzt nicht, Moritz. Man spricht nicht"
If Zufall=15 Then Print "mit vollem Mund. Aber es ist sehr wichtig, "
If Zufall=15 Then Print "Vater!, sagte Mortiz dr�ngelnd. Das kannst"
If Zufall=15 Then Print "du mir auch sp�ter sagen!, antwortet der "
If Zufall=15 Then Print "Vater w�tend. Nach dem Essen. So, Moritz,"
If Zufall=15 Then Print "was wolltest du mir sagen? Ach, jetzt ist"
If Zufall=15 Then Print "es zu sp�t, du hast den Wurm im Salat schon"
If Zufall=15 Then Print "gegessen."

If Zufall=16 Then Print "Ein Sch�fer sitzt mit einem Schaf am Strassenrand."
If Zufall=16 Then Print "Da kommt ein Porsche vorbei, blieb stehen und"
If Zufall=16 Then Print "bietet dem Hirten an mitzufahren. Allerdings"
If Zufall=16 Then Print "nur ohne Schaf.Der Sch�fer sagt dem Porschefahrer,"
If Zufall=16 Then Print "dass es kein Problem w�re, das Schaf einfach hinten"
If Zufall=16 Then Print "am Auto anzubinden.Als sie schon 100km/h fahren,"
If Zufall=16 Then Print "sieht der Porschefahrer �berrascht, dass das Schaf"
If Zufall=16 Then Print "ganz locker hinter seinem Auto hertrabt.Also"
If Zufall=16 Then Print "beschliesst er, noch etwas schneller zu fahren."
If Zufall=16 Then Print "Bei 150 km/h ist das Schaf schon fast im Galopp."
If Zufall=16 Then Print "Als er weiter auf 200km/h beschleunigt, sieht er,"
If Zufall=16 Then Print "dass das Schaf auf einmal so seltsam mit dem linken"
If Zufall=16 Then Print "Ohr wackelt. Als er den Sch�fer darauf aufmerksam"
If Zufall=16 Then Print "macht, sagt dieser nur: Keine Sorge, das macht's"
If Zufall=16 Then Print "immer wenn's �berholen will!"

If Zufall=17 Then Print "Friederich und seine Freunde haben Murmeln gekauft."
If Zufall=17 Then Print "Sie kommen an einer Leichenhalle vorbei.Vor dem"
If Zufall=17 Then Print "Eingang verteilen sie zwei Murmeln, die hineinkullern."
If Zufall=17 Then Print "In der Halle z�hlten sie die Murmeln ab. Eine f�r"
If Zufall=17 Then Print "dich, eine f�r mich ... usw. Der Hausmeister kommt"
If Zufall=17 Then Print "vorbei, h�rt das und rennt zum Pfarrer: Herr"
If Zufall=17 Then Print "Pfarrer, in der Leichenhalle spielt der Teufel"
If Zufall=17 Then Print "mit Gott um die Seele der Verstorbenen! Also"
If Zufall=17 Then Print "geht der Pfarrer mit ihm zur�ck. Dort h�ren"
If Zufall=17 Then Print "sie eine Stimme: Das waren alle! Und die vor"
If Zufall=17 Then Print "der T�r holen wir uns auch noch!"

If Zufall=18 Then Print "Reisender zum Schaffner:"
If Zufall=18 Then Print "Wie lange h�lt der Zug?-"
If Zufall=18 Then Print "Bei guter Pflege 25 Jahre."

If Zufall=19 Then Print "K�nnen Sie mir einen unbekanten,"
If Zufall=19 Then Print "schneesicheren Urlaubsort empfehlen?"
If Zufall=19 Then Print "Tut mir leid, die sind alle ausgebucht!"

If Zufall=20 Then Print "Ein Mann beim Verh�r."
If Zufall=20 Then Print "Polizist: Sie haben doch gesehen, wie"
If Zufall=20 Then Print "die alte Dame von einem Kerl verpr�gelt"
If Zufall=20 Then Print "wurde. Wieso haben Sie dann nicht geholfen?"
If Zufall=20 Then Print "Mann: Ich dachte , der schafft das allein!"

If Zufall=21 Then Print "Ein Landwirt gewinnt 3000 Euro im Lotto und"
If Zufall=21 Then Print "bekommt sie in drei 1000 Euro Scheinen bar"
If Zufall=21 Then Print "bezahlt. Leider f�llt ihm das Geld auf den"
If Zufall=21 Then Print "Boden und seine fette Sau frisst das Geld."
If Zufall=21 Then Print "Der Geldbote hatte einen Ratschlag parat:"
If Zufall=21 Then Print "Geben Sie der Sau ein Korn zu trinken und"
If Zufall=21 Then Print "treten Sie ihr in den Hintern, dann kotzt"
If Zufall=21 Then Print "sie das Geld wieder aus. Da der Bauer gerade"
If Zufall=21 Then Print "kein Korn zuhause hat,schleppt er die Sau in"
If Zufall=21 Then Print "die n�chste Kneipe, bestellt ein Bier und ein"
If Zufall=21 Then Print "Korn. Er trinkt das Bier auf ex, gibt der Sau"
If Zufall=21 Then Print "den Korn,tritt ihr in den Hintern, und siehe da,"
If Zufall=21 Then Print "sie erbricht einen Tausender. Der Wirt ist "
If Zufall=21 Then Print "begeistern und fragt,ob er das Tier kaufen k�nne."
If Zufall=21 Then Print "Die Sau ist unverk�uflich, sagte der Bauer,"
If Zufall=21 Then Print "bestellt noch ein Korn, noch ein Bier, tritt"
If Zufall=21 Then Print "der Sau in den Hintern, und der zweite Tausender"
If Zufall=21 Then Print "kommt zum Vorschein.Der Wirt kann es kaum glauben,"
If Zufall=21 Then Print "und der Bauer wiederholte das Spiel zum dritten Mal."
If Zufall=21 Then Print "Darauf der Wirt: Ich gebe Ihnen 10'000 Euro in bar"
If Zufall=21 Then Print "f�r das Tier. Der Bauer �berlegt nicht lange und"
If Zufall=21 Then Print "willigt zufrieden ein. Er l�sst die Sau in der "
If Zufall=21 Then Print "Kneipe und geht mit seinen 10'000 Euro heim. Am"
If Zufall=21 Then Print "n�chsten Tag liest der Bauer in der Zeitung die"
If Zufall=21 Then Print "Schlagzeilen: Ein betrunkener Gastwirt tritt"
If Zufall=21 Then Print "seine Sau tot!!!"

If Zufall=22 Then Print "In diesem Jahr werde ich im Urlaub nichts tun."
If Zufall=22 Then Print "Die erste Woche werde ich mich nur im Schaukelstuhl"
If Zufall=22 Then Print "entspannen. Ja aber dann?-Dann werde ich"
If Zufall=22 Then Print "eventuell ein wenig schaukeln."

If Zufall=23 Then Print "Ein Polizist steht in der K�che und versucht eine"
If Zufall=23 Then Print "Fischb�chse zu �ffnen. Erst reisst er die Lasche ab,"
If Zufall=23 Then Print "dann zerbeult er mit dem B�chsen�ffner die "
If Zufall=23 Then Print "Seitenwand. Dann verbeult er den Deckel.Schliesslich"
If Zufall=23 Then Print "nimmt der Polizist seinen Gummikn�ppel, haut mehrfach"
If Zufall=23 Then Print "auf die B�chse und schreit: Aufmachen, Polizei!"

If Zufall=24 Then Print "Wegen zu geringer Bildung sollen Leute mit"
If Zufall=24 Then Print "Fremdsprachenkenntnis als Polizisten angeworben"
If Zufall=24 Then Print "werden. Es melden sich auch welche: Pr�fer:"
If Zufall=24 Then Print "Do you speak English? 1.Bewerber: �h? Durchgefallen."
If Zufall=24 Then Print "Pr�fer: Do you speak English? 2.Bewerber:�h?"
If Zufall=24 Then Print "Durchgefallen. Pr�fer: Do you speak English?"
If Zufall=24 Then Print "3. Bewerber: Oh yes, I do. Pr�fer: �h?"

If Zufall=25 Then Print "Der arbeitslose Maurer muss zur Stellenvermittlung"
If Zufall=25 Then Print "Der Beamte: Jetzt habe ich Ihnen schon sieben"
If Zufall=25 Then Print "Baustellen vermittelt, und bei keiner haben Sie"
If Zufall=25 Then Print "angefangen! Der Maurer verzweifelt: Was soll ich"
If Zufall=25 Then Print "denn machen? Da stand jedesmal auf einem Schild-"
If Zufall=25 Then Print "Baustelle betreten verboten!"

If Zufall=26 Then Print "Zwei Polizisten auf Streife kommen an dem Haus vorbei,"
If Zufall=26 Then Print "in dem einer von ihnen wohnt. Da zeigt dieser nach oben"
If Zufall=26 Then Print "und meint: Da oben wohne ich. Das auf dem Balkon ist"
If Zufall=26 Then Print "meine Frau und der Mann daneben - das bin ich"


If Zufall=27 Then Print "Schon �ber eine halbe Stunde verfolgt der Polizist"
If Zufall=27 Then Print "den Dieb. Endlich kann der Dieb nicht mehr und "
If Zufall=27 Then Print "l�sst sich auf eine Bank fallen. Schnaufend "
If Zufall=27 Then Print "stoppt der Polizist und setzt sich ebenfalls."
If Zufall=27 Then Print "Nach einer Weile schaut der Dieb zum Polizisten "
If Zufall=27 Then Print "hin�ber: Na, packen wir es wieder?"

If Zufall=28 Then Print "Schimpft der Polizist mit dem Passanten:"
If Zufall=28 Then Print "Sie d�rfen doch nicht bei Rot �ber die Strasse gehen."
If Zufall=28 Then Print "Sind Sie denn von Sinnen?"
If Zufall=28 Then Print "Nein, Herr Polizist, von Z�rich!"

If Zufall=29 Then Print "Der Richter vorwurfsvoll zum Angeklagten:"
If Zufall=29 Then Print "Sie haben in dem Hotel Handt�cher geklaut."
If Zufall=29 Then Print "Wissen Sie, was darauf steht?"
If Zufall=29 Then Print "Nat�rlich: �Hotel zum B�ren�"

If Zufall=30 Then Print "Der Polizist zum Autofahrer:"
If Zufall=30 Then Print "Was f�llt Ihnen ein, in der Stadt"
If Zufall=30 Then Print "70 Kilometer in der Stunde zu fahren?"
If Zufall=30 Then Print "Unm�glich, ich bin ja erst zehn Minuten unterwegs!"

Input()
Cls
Locate 1,1
FlushKeys
FlushMouse
Witze=Witze+1
Until Witze = 10
;Spielstandsicherung
FlushKeys
FlushMouse
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=9
Smeili=1
FlushKeys
FlushMouse
Goto Programmstart
End




.Aufgabe10
PauseChannel HGM
ClsVB
Fa=0
Art=0
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
Print "haben, sonst kommst du wieder zum Spiel oder zur �bersicht."
Print "Noch ein Tipp, wenn du keinen Curser mehr siehst dann erscheint"
Print "der Text entweder nur eine gewisse Zeit oder du kannst eine"
Print "beliebige Taste dr�cken wie es hier der Fall ist!"
WaitKey ()
Restore Woerter2W
 ;Einleseschlaufe f�r 50 W�rter
      Const MaxsA = 49
Dim Wort$(MaxsA)

            

.Woerter2A
Data "Akte (Schriftst�ck)","Ameise","Angel","Band (Buch)","Bank (Sitzgelegenheit)"
Data "Bank (Geldinstitut)","Beere","Bleistift","Bund (Hosenbund)","Butter"
Data "Ecke","Efeu","Ekel (Abscheu)","Dschungel","Fahne","Ferse","Floh"
Data "Flur (Korridor)","Gefallen (Gef�lligkeit)","Giraffe","Griess","Kaffee"
Data "K�fig","Kamin","Kartoffel","Kino","Koffer","Kunde (K�ufer)","L�ge"
Data "Socke","Spital","Spitze","Wespe","Zehe"
Data "Mais","Mark (Knochengewebe)","Messer (Schneidger�t)","Moment (Augenblick)"
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

If Zufall$=1 Then Goto ArFehler
If Zufall$=2 Then Goto ArFehler
If Zufall$=3 Then Goto ArFehler
If Zufall$=4 Then Goto ArFehler
If Zufall$=5 Then Goto ArFehler
If Zufall$=6 Then Goto ArFehler
If Zufall$=7 Then Goto ArFehler
If Zufall$=8 Then Goto ArFehler
If Zufall$=9 Then Goto ArFehler
If Zufall$=10 Then Goto ArFehler
If Zufall$=11 Then Goto ArFehler
If Zufall$=12 Then Goto ArFehler
If Zufall$=13 Then Goto ArFehler
If Zufall$=14 Then Goto ArFehler
If Zufall$=15 Then Goto ArFehler
If Zufall$=16 Then Goto ArFehler
If Zufall$=17 Then Goto ArFehler
If Zufall$=18 Then Goto ArFehler
If Zufall$=19 Then Goto ArFehler
If Zufall$=20 Then Goto ArFehler
If Zufall$=21 Then Goto ArFehler
If Zufall$=22 Then Goto ArFehler
If Zufall$=23 Then Goto ArFehler
If Zufall$=24 Then Goto ArFehler
If Zufall$=25 Then Goto ArFehler
If Zufall$=26 Then Goto ArFehler
If Zufall$=27 Then Goto ArFehler
If Zufall$=28 Then Goto ArFehler
If Zufall$=29 Then Goto ArFehler
If Zufall$=30 Then Goto ArFehler



Cls
Locate 1,1
Bild1= LoadImage (".\Bilder\Artikel.jpg")
Bild2=LoadImage (".\Bilder\ArtikelK1.jpg")
Bild3=LoadImage (".\Bilder\ArtikelK2.jpg")
Bild4=LoadImage (".\Bilder\ArtikelK3.jpg")
SetBuffer BackBuffer ()


gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 1,1,1


hotX=0
hotY=100
hotW=400
hotH=100

hotX1=0
hotY1=200
hotW1=400
hotH1=100

hotX2=0
hotY2=300
hotW2=400
hotH2=100

HGrundH=Bild1
Schrift = LoadFont ("Arial",90,20100)
SetFont Schrift



.ArtikelMaus
circleX=MouseX()
circleY=MouseY()

Cls
Locate 1,1

DrawImage HGrundH, 1,0
DrawImage gfxCircle,circleX,circleY
Text 1,1,Zufall$
Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto ArtikelMaus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto ArtikelMaus2
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX2,hotY2,hotW2,hotH2) Goto ArtikelMaus3
Cls
HGrundH=Bild1
Goto ArtikelMaus
End

.ArtikelMaus1
;Der
HGrundH=Bild2
If MouseDown(1) Then ArtikelK=1 Goto ArtikelEntscheid
Goto ArtikelMaus
End


.ArtikelMaus2
;Die
HGrundH=Bild3
If MouseDown(1) Then ArtikelK=2 Goto ArtikelEntscheid
Goto ArtikelMaus
End


.ArtikelMaus3
;Das
HGrundH=Bild4
If MouseDown(1) Then ArtikelK=3 Goto ArtikelEntscheid
Goto ArtikelMaus
End


.ArtikelEntscheid
PPE=0
ArtikelVRichtig=0
If Zufall$="Akte (Schriftst�ck)" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1
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
If Zufall$="Gefallen (Gef�lligkeit)" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Giraffe" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Griess" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Kaffee" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1
If Zufall$="K�fig" And ArtikelK=3 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Kamin" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Kartoffel" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Kino" And ArtikelK=3 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Koffer" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Kunde (K�ufer)" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="L�ge" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Socke" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Spital" And ArtikelK=3 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Spitze" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Wespe" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Zehe" And ArtikelK=2 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Mais" And ArtikelK=1 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Mark (Knochengewebe)" And ArtikelK=3 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
If Zufall$="Messer (Schneidger�t)" And ArtikelK=3 Then ArRichtig=ArRichtig+1 ArtikelVRichtig=1 
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
If ArtikelVRichtig=1 Then AR=1 Text 1,410,"Richtig" Else AR=0 Text 1,410,"Falsch"
Delay 1000
Art=Art+1
.ArFehler
Until Art=20
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
ClsVB
Cls
Locate 1,1
Schrift = LoadFont ("Arial",50,20100)
SetFont Schrift
HGrundH=LoadImage (".\Bilder\Zugersee.jpg")
DrawImage HGrundH, 0,0
SeedRnd MilliSecs() 
If Schwierigkeitsstufe=1 Then Zufall = Rand (1,100)
If Schwierigkeitsstufe=2 Then Zufall = Rand (1,100)
If Schwierigkeitsstufe=3 Then Zufall = Rand (1,1000)
If Schwierigkeitsstufe=4 Then Zufall = Rand (1,10000)
Versuche = 0
If Schwierigkeitsstufe=1 Then Print "Ich denke mir eine Zahl zwischen 1 und 100 errate sie!"
If Schwierigkeitsstufe=1 Then Print "Das Ziel ist, die Zahl in 10 Versuchen herauszufinden."
If Schwierigkeitsstufe=2 Then Print "Ich denke mir eine Zahl zwischen 1 und 100 errate sie!"
If Schwierigkeitsstufe=2 Then Print "Das Ziel ist, die Zahl in 10 Versuchen herauszufinden."
If Schwierigkeitsstufe=3 Then Print "Ich denke mir eine Zahl zwischen 1 und 1000 errate sie!"
If Schwierigkeitsstufe=3 Then Print "Das Ziel ist, die Zahl in 15 Versuchen herauszufinden."
If Schwierigkeitsstufe=4 Then Print "Ich denke mir eine Zahl zwischen 1 und 10000 errate sie!"
If Schwierigkeitsstufe=4 Then Print "Das Ziel ist, die Zahl in 20 Versuchen herauszufinden."
Print "Wenn du die Zahl einfach nicht herausfindest oder einen Fehler im Programm ist"
Print "dann kommst du mit Enter wieder zum Spiel oder zur �bersicht."
Print "Wenn du 0 und Enter dr�ckst kommst du auch zum Spiel."
Print "Viel Gl�ck!"
Input()
Repeat
  Zahl = Input("Rate mal: ")
If Zahl=0 And UebersichtA=1 Then Goto Uebersicht3
;If Zahl=0 Then Goto Teil9
  Versuche = Versuche + 1
  If Zahl < Zufall Then Print "Zu klein!"
  If Zahl > Zufall Then Print "Zu gro�!"
If Versuche=24 Then Cls
If Versuche=24 Then Locate 1,1 DrawImage HGrundH, 0,0
If Versuche=48 Then Cls
If Versuche=48 Then Locate 1,1 DrawImage HGrundH, 0,0
If Versuche=72 Then Cls
If Versuche=72 Then Locate 1,1 DrawImage HGrundH, 0,0
If Versuche=96 Then Cls
If Versuche=96 Then Locate 1,1 DrawImage HGrundH, 0,0
If Versuche=120 Then Cls
If Versuche=120 Then Locate 1,1 DrawImage HGrundH, 0,0
If Versuche=144 Then Cls
If Versuche=144 Then Locate 1,1 DrawImage HGrundH, 0,0
If Versuche=168 Then Cls
If Versuche=168 Then Locate 1,1 DrawImage HGrundH, 0,0
If Versuche=192 Then Cls
If Versuche=192 Then Locate 1,1 DrawImage HGrundH, 0,0
If Versuche=216 Then Cls
If Versuche=216 Then Locate 1,1 DrawImage HGrundH, 0,0
If Versuche=240 Then Cls
If Versuche=240 Then Locate 1,1 DrawImage HGrundH, 0,0
If Versuche=264 Then Cls
If Versuche=264 Then Locate 1,1 DrawImage HGrundH, 0,0
If Versuche=288 Then Cls
If Versuche=288 Then Locate 1,1 DrawImage HGrundH, 0,0

If Versuche=288 Then Print "Die Zahl w�re "+Zufall+" gewesen."
If Versuche=288 Then Print "Du hast viel zu viel Versuche gebraucht."
If Versuche=288 And Schwierigkeitsstufe=1 Then Print "Das Ziel w�re es eigentlich"
If Versuche=288 And Schwierigkeitsstufe=1 Then Print "die Zahl in 10 Versuchen zu erraten."
If Versuche=288 And Schwierigkeitsstufe=2 Then Print "Das Ziel w�re es eigentlich"
If Versuche=288 And Schwierigkeitsstufe=2 Then Print "die Zahl in 10 Versuchen zu erraten."
If Versuche=288 And Schwierigkeitsstufe=3 Then Print "Das Ziel w�re es eigentlich"
If Versuche=288 And Schwierigkeitsstufe=3 Then Print "die Zahl in 15 Versuchen zu erraten."
If Versuche=288 And Schwierigkeitsstufe=4 Then Print "Das Ziel w�re es eigentlich"
If Versuche=288 And Schwierigkeitsstufe=4 Then Print "die Zahl in 20 Versuchen zu erraten."
If Versuche=288 Then Print "Versuche die Aufgabe sp�ter noch einmal."
If Versuche=288 Then Input()
If Versuche=288 And UebersichtA=1 Then Goto Uebersicht3
;If Versuche=288 Then Goto Teil9
Until Zahl = Zufall
Cls
Locate 1,1
DrawImage HGrundH, 0,0
Print "Richtig!"
Print "Du hast " + Versuche + " Mal geraten."
If Versuche=10 Or Versuche<10 And Schwierigkeitsstufe=1 Then Print "Herzlichen Gl�ckwunsch du hast das Ziel erreicht!"
If Versuche>10 And Schwierigkeitsstufe=1 Then Print "Du hast das Ziel nicht erreicht, versuche die Aufgabe sp�ter nochmals."
If Versuche>10 And Schwierigkeitsstufe=1 Then Input()
;If Versuche>10 And Schwierigkeitsstufe=1 Then Versuche=0 Zahl=0 Goto Teil9
If Versuche=10 Or Versuche<10 And Schwierigkeitsstufe=2 Then Print "Herzlichen Gl�ckwunsch du hast das Ziel erreicht!"
If Versuche>10 And Schwierigkeitsstufe=1 Then Print "Du hast das Ziel nicht erreicht, versuche die Aufgabe sp�ter nochmals."
If Versuche>10 And Schwierigkeitsstufe=1 Then Input()
;If Versuche>10 And Schwierigkeitsstufe=1 Then Versuche=0 Zahl=0 Goto Teil9
If Versuche=15 Or Versuche<15 And Schwierigkeitsstufe=3 Then Print "Herzlichen Gl�ckwunsch du hast das Ziel erreicht!"
If Versuche>15 And Schwierigkeitsstufe=1 Then Print "Du hast das Ziel nicht erreicht, versuche die Aufgabe sp�ter nochmals."
If Versuche>15 And Schwierigkeitsstufe=1 Then Input()
;If Versuche>15 And Schwierigkeitsstufe=1 Then Versuche=0 Zahl=0 Goto Teil9
If Versuche=20 Or Versuche<20 And Schwierigkeitsstufe=4 Then Print "Herzlichen Gl�ckwunsch du hast das Ziel erreicht!"
If Versuche>20 And Schwierigkeitsstufe=1 Then Print "Du hast das Ziel nicht erreicht, versuche die Aufgabe sp�ter nochmals."
If Versuche>20 And Schwierigkeitsstufe=1 Then Input()
;If Versuche>20 And Schwierigkeitsstufe=1 Then Versuche=0 Zahl=0 Goto Teil9
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
FehlerD=0
score=0
once=0
bat1=0
bat2=0
ball=0
AAAB=0
ClsVB

SetBuffer BackBuffer()

bat1=LoadImage("Bilder/bat.jpg")
bat2=CopyImage(bat1)
ball=LoadImage("Bilder/ball.jpg")

beep1=LoadSound("Sounds/beep.mp3")
beep2=LoadSound("Sounds/beeplow.mp3")
load=ReadFile("sthighscore")
high=ReadLine(load)
font=LoadFont("arial",32)
SetFont font
; Set text colour to green
Color 0,255,0 

; Set initial ball position and movement values
ballx#=width/2
bally#=height/2
ballmovx#=2
ballmovy#=2

; Set initial game values
once=2
score=0

; Repeat following loop until escape key is pressed
Repeat

; Clear screen
Cls

; Print current score to screen
Text width/2,0,score,1

; Print high score to screen
Text width/2,height-92,"Rekord gemischt: "+high,1
Text width/2,height-62,"Das Ziel ist, 20 Schwierigkeitsstufe zu erreichen!",1
Text width/2,height-32,"Du darfst aber nicht mehr als 3 mal den Ball durchlassen sonst kommst du wieder zum Spiel!",1
If  FehlerD=4 And UebersichtA=1 Then Goto Uebersicht3
If  score=20 And UebersichtA=1 Then Goto Uebersicht3
If score=20 Then Delay 1000 Aufgaben=12 Smeili=1 Goto Programmstart
If FehlerD=4 Then Delay 1000 Goto Programmstart


; Get position of bats
batx1=0
batx2=width-64
baty1=MouseY()
baty2=height-MouseY()-64

; Update ball position values
ballx#=ballx#+ballmovx#
bally#=bally#+ballmovy#
; If ball image collides with either bat image then alter x ball movement value and play beep sound
If once=1 And ImagesCollide(ball,ballx#,bally#,0,bat1,batx1,baty1,0) Then ballmovx#=Rnd(1,16) : PlaySound beep1 : score=score+1: once=2  
If once=2 And ImagesCollide(ball,ballx#,bally#,0,bat2,batx2,baty2,0) Then ballmovx#=Rnd(1,16)*-1 : PlaySound beep1 : score=score+1: once=1

; If ball touches top or bottom of screen then alter y ball movement value
If bally#>height-16 Then ballmovy#=Rnd(1,16)*-1 : PlaySound beep2
If bally#<0 Then ballmovy#=Rnd(1,16) : PlaySound beep2

; If bats touch top or bottom of screen then prevent them from going outside of screen
If baty1<0 Then baty1=0
If baty2<0 Then baty2=0
If baty1>height-64 Then baty1=height-64
If baty2>height-64 Then baty2=height-64

; If ball touches left side of screen then save high score if necessary, reset ball and score values
If ballx#<0
If score>high Then high=score : save=WriteFile("sthighscore") : WriteLine save,high : CloseFile save
ballx#=width/2 : bally#=height/2 : ballmovx#=1 : ballmovy#=1 : once=2 : score=0 FehlerD=FehlerD+1
EndIf

; If ball touches right side of screen then save high score if necessary, reset ball and score values
If ballx#>width-16
If score>high Then high=score : save=WriteFile("sthighscore") : WriteLine save,high : CloseFile save
ballx#=width/2 : bally#=height/2 : ballmovx#=1 : ballmovy#=1 : once=2 : score=0 FehlerD=FehlerD+1
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
Print "Du hast drei Minuten Zeit, um m�glichst viele W�rter"
Print "die mit sagen zu tun haben aufzuschreiben wie"
Print "ZB. antworten."
Print "Diese �bung dient dazu einen Text spannend zu ma-"
Print "chen indem man nicht immer sagte braucht."
Print ""
Print "Du musst mindestens 15 W�rter schaffen um weiter"
Print "zu kommen!"
Print ""
Print "Viel Gl�ck!"
BildSagen=LoadImage(".\Bilder\Sagen.jpg")
Input()


;Zeit!
StartZeit = MilliSecs()
Const ZeitMax = 1800  ;180 Sekunden


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
Text 640,70,"Liste deiner W�rter",1
Schrift = LoadFont ("Arial",40,201)
SetFont Schrift
Text 640,950,"weiter mit beliebeger Taste",1
Schrift = LoadFont ("Arial",51,201)
SetFont Schrift
WAKX=250
WAKY=150


Repeat


SYN$=WS$(EDVWS)
If SYN$="fl�stern"Or SYN$="zischen"Or SYN$="murmeln"Or SYN$="hauchen"Or SYN$="wispern"Or SYN$="tuscheln"Or SYN$="rufen"Or SYN$="schreien"Or SYN$="br�llen"Or SYN$="kreischen"Or SYN$="krakeelen"Or SYN$="reden"Or SYN$="sagen"Or SYN$="plaudern"Or SYN$="sprechen"Or SYN$="quasseln"Or SYN$="plappern"Or SYN$="schnattern"Or SYN$="bemerken"Or SYN$="andeuten"Or SYN$="meinen"Or SYN$="faseln"Or SYN$="�ussern"Or SYN$="schwatzen"Or SYN$="erz�hlen"Or SYN$="berichten"Or SYN$="erw�hnen"Or SYN$="erkl�ren"Or SYN$="beschliessen"Or SYN$="�berlegen"Or SYN$="glauben"Or SYN$="schildern"Or SYN$="erleutern"Or SYN$="raten"Or SYN$="reimen"Or SYN$="dichten"Or SYN$="�bertreiben"Or SYN$="l�gen"Or SYN$="loben"Or SYN$="sich erinnern"Or SYN$="erinnern"Or SYN$="von sich geben"Or SYN$="geben"Or SYN$="prahlen"Or SYN$="wiederholen"Or SYN$="weinen"Or SYN$="schluchzen"Or SYN$="pl�rren"Or SYN$="seufzen"Or SYN$="st�hnen"Or SYN$="jammern"Or SYN$="klagen"Or SYN$="tr�sten"Or SYN$="kichern"Or SYN$="fragen"Or SYN$="sich erkundigen"Or SYN$="erkundigen"Or SYN$="antworten"Or SYN$="erwiedern"Or SYN$="bejahen"Or SYN$="verneinen"Or SYN$="wiedersprechen"Or SYN$="entgegnen"Or SYN$="behaupten"Or SYN$="zustimmen"Or SYN$="verk�nden"Or SYN$="bezeugen"Or SYN$="einwenden"Or SYN$="einwerffen"Or SYN$="unterbrechen"Or SYN$="befehlen"Or SYN$="auffordern"Or SYN$="vorschlagen"Or SYN$="bitten"Or SYN$="betteln"Or SYN$="versichern"Or SYN$="versprechen"Or SYN$="schimpfen"Or SYN$="sich beschweren"Or SYN$="beschweren"Or SYN$="tadeln"Or SYN$="reklamieren"Or SYN$="sich �rgern"Or SYN$="�rgern"Or SYN$="schmollen"Or SYN$="l�stern"Or SYN$="drohen"Or SYN$="zurechtweisen"Or SYN$="anschnauzen"Or SYN$="protesteiren"Or SYN$="petzen"Or SYN$="zanken"Or SYN$="fluchen"Or SYN$="stottern"Or SYN$="lallen"Or SYN$="nuscheln"Or SYN$="kr�chzen"Or SYN$="stammeln"Or SYN$="brummen"Or SYN$="labern"Or SYN$="hervorstossen"Or SYN$="n�seln"Then WIEDSML=1 Color 1,255,1 WSR=WSR+1 Else WIEDSML=0 Color 255,1,1

FSWV=0

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
Text 640,70,"Liste deiner W�rter",1
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


Data "fl�stern","zischen","murmeln","hauchen","wispern","tuscheln","rufen","schreien","br�llen","kreischen","krakeelen","reden","sagen","plaudern","sprechen","quasseln","plappern","schnattern","bemerken","andeuten","meinen","faseln","�ussern","schwatzen","erz�hlen","berichten","erw�hnen","erkl�ren","beschliessen","�berlegen","glauben","schildern","erleutern","raten","reimen","dichten","�bertreiben","l�gen","loben","sich erinnern","erinnern","von sich geben","geben","prahlen","wiederholen","weinen","schluchzen","pl�rren","seufzen","st�hnen","jammern","klagen","tr�sten","kichern","fragen","sich erkundigen","erkundigen","antworten","erwiedern","bejahen","verneinen","wiedersprechen","entgegnen","behaupten","zustimmen","verk�nden","bezeugen","einwenden","einwerffen","unterbrechen","befehlen","auffordern","vorschlagen","bitten","betteln","versichern","versprechen","schimpfen","sich beschweren","beschweren","tadeln","reklamieren","sich �rgern","�rgern","schmollen","l�stern","drohen","zurechtweisen","anschnauzen","protesteiren","petzen","zanken","fluchen","stottern","lallen","nuscheln","kr�chzen","stammeln","brummen","labern","hervorstossen","n�seln"

 

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
If WSR=0 Or WSR>1 Text 640,80,"Du hast "+WSR+" richtige Worter zum Wortfeld Sagen",1 Else Text 640,80,"Du hast "+WSR+" richtiges Wort zum Wortfeld Sagen",1
Text 640,130,"in drei Minuten aufgeschrieben!!!",1
If WSR>15 Or WSR=15 Then Text 640,180,"Ziel Erreicht!",1
If WSR<15 Then Text 640,180,"Ziel nicht Erreicht!",1
If WSR<15 Then Text 640,230,"Versuche die Aufgabe nochmahls!",1
Schrift = LoadFont ("Arial",40,201)
SetFont Schrift
Text 640,950,"weiter mit beliebeger Taste",1
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
GameP=PlaySound(Game)
HGrundH=LoadImage (".\Bilder\Zugersee.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,70)
SetFont Schrift
Color 0,0,0
Locate 1,1
Richtig = 0
Print "Das Schweizer Lotto"
Print "Spielregeln"
Print "Schreibe 6 Zahlen von 1 bis 42 auf. Keine kommt 2 mal vor.
Print "Schreibe bitte immner nur eine Zahl auf einer Linie (dann Enter + n�chste Zahl).
FlushKeys
FlushMouse
Input()
Goto Lotoschein
End
.Lotoschein
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
Richtig = 0
DrawImage HGrundH, 0,0
Color 255,255,255
Locate 0,0
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
Print "Zahl 1: " + Zahl1
Print "Zahl 2: " + Zahl2
Print "Zahl 3: " + Zahl3
Print "Zahl 4: " + Zahl4
Print "Zahl 5: " + Zahl5
Print "Zahl 6: " + Zahl6
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
If Richtig=0 Then Print "Du hast 0 Fr. gewonnen
If Richtig=1 Then Print "Du hast 5 Fr. gewonnen
If Richtig=2 Then Print "Du hast 10 Fr. gewonnen
If Richtig=3 Then Print "Du hast 50 Fr. gewonnen
If Richtig=4 Then Print "Du hast 5000 Fr. gewonnen
If Richtig=5 Then Print "Du hast 100000 Fr. gewonnen
If Richtig=6 Then Print "Du hast 1000000 Fr. gewonnen

.nochmals
Print "Willst du noch einmal spielen?"

Antwort$= Input()
If Antwort$ = "Ja" Then Goto Lotoschein
If Antwort$ = "ja" Then Goto Lotoschein
If Antwort$ = "ok" Then Goto Lotoschein
If Antwort$ = "ok" Then Goto Lotoschein
If Antwort$ = "Ja gern" Then Goto Lotoschein
If Antwort$ = "ja gern" Then Goto Lotoschein
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
Goto Lotoschein
End



.Aufgabe15
ClsVB
	If score=1000 Or score>1000 Then
	If UebersichtA=1 Then Goto Uebersicht3
	Aufgaben=15
Smeili=1
FlushKeys
FlushMouse
Goto Programmstart
EndIf






.Aufgabe16
If hfdujkhbgjgjuvkhuj16=0 Then
PauseChannel MXP
ClsVB
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
Print "ber�hrt, dann wird sie bei der n�chsten"
Print "Ziffer der Rechnung eingetragen."
Print "das Ziel ist, so eine Rechnumg mit dem korrekten"
Print "Resultat zu erstellen."
Print "Achtung! Du hast f�r eine Rechnung nur solange Zeit bis"
Print "deine Spielfigur am unteren Bildrand ankommt."
Print "Es sind 7 Aufgaben richtig zu l�sen."
Print ""
Print "Viel Gl�ck!"
Input()
hfdujkhbgjgjuvkhuj16=1
hfdujkhbgjgjuvkhuj161=1
EndIf

If RichtigA16=7 Then
RichtigA16=0
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
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=16
Smeili=0
Goto Programmstart
EndIf

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
B1= LoadImage (".\Bilder\1.jpg")
B2= LoadImage (".\Bilder\2.jpg")
B3= LoadImage (".\Bilder\3.jpg")
B4= LoadImage (".\Bilder\4.jpg")
B5= LoadImage (".\Bilder\5.jpg")
B6= LoadImage (".\Bilder\6.jpg")
B7= LoadImage (".\Bilder\7.jpg")
B8= LoadImage (".\Bilder\8.jpg")
B9= LoadImage (".\Bilder\9.jpg")

Bild1= LoadImage (".\Bilder\Teil16.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 0
y = 191
ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Teil16.jpg")


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

    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
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
Print "zu l�sen."
Print ""
Print "Zu musst von 30 Rechnungen mindestens 25"
Print "richtig und in angemesenem Tempo schaffen."
Print "Viel Gl�ck!"
Input()
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
If (JetztZeit-StartZeit > ZeitMaxSR) Then Print "Zu Sp�t!"
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
If (JetztZeit-StartZeit > ZeitMaxSR) Then Print "Zu Sp�t!"
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
If (JetztZeit-StartZeit > ZeitMaxSR) Then Print "Zu Sp�t!"
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
If (JetztZeit-StartZeit > ZeitMaxSR) Then Print "Zu Sp�t!"
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
Print "Richtig und in angemesenem Tempo gel�st."
Print ""
If Richtig=>25 Then
Print "Ziel erreicht!"
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
Goto Adjektive
End


.Adjektive
Cls 
Locate 1,1
Adjektiv = 0   Adjektiv1 = 0    Adjektiv2 = 0
HGrundH=LoadImage (".\Bilder\Mauer.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,255,0
Print"Erkenne das Adjektiv in dem folgenden Satz."
Print"Schreibe das Adjektiv und dr�cke Enter"
Print
Print "Mein Fahrrad f�hrt nicht mehr so gut."
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "gut" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv = Adjektiv +1
EndIf
If Adjektiv =4  Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
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
If Adjektiv1 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
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
If Adjektiv2 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "am besten"
Print


Cls 
Locate 1,1
Adjektiv = 0   Adjektiv1 = 0    Adjektiv2 = 0
HGrundH=LoadImage (".\Bilder\Mauer.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,255,0
Print"Erkenne das Adjektiv in dem folgenden Satz."
Print"Schreibe das Adjektiv und dr�cke Enter"
Print
Print "Ich bin vergn�gt."
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "vergn�gt" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv = Adjektiv +1
EndIf
If Adjektiv =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "vergn�gt"
Print
Print "Steigere das Adjektiv einmal z.B. (gelber).
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "vergn�gter" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv1 = Adjektiv1 +1
EndIf
If Adjektiv1 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "vergn�gter"
Print
Print "Und jetzt steigere das Adjektiv zweimal z.B. (am gelbsten).
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "am vergn�gtesten" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv2 = Adjektiv2 +1
EndIf
If Adjektiv2 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "am vergn�gtesten"
Print


Cls 
Locate 1,1
Adjektive = 0   Adjektive1 = 0    Adjektive2 = 0
HGrundH=LoadImage (".\Bilder\Mauer.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,255,0
Print"Erkenne das Adjektiv in dem folgenden Satz."
Print"Schreibe das Adjektiv und dr�cke Enter"
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
If Adjektiv =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
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
If Adjektiv1 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
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
If Adjektiv2 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "am tollsten"
Print



Cls 
Locate 1,1
Adjektiv = 0   Adjektiv1 = 0    Adjektiv2 = 0
HGrundH=LoadImage (".\Bilder\Mauer.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,255,0
Print"Erkenne das Adjektiv in dem folgenden Satz."
Print"Schreibe das Adjektiv und dr�cke Enter"
Print
Print "Ich esse gerne s�sse Schokolade."
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "s�ss" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv = Adjektiv +1
EndIf
If Adjektiv =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "s�ss"
Print
Print "Steigere das Adjektiv einmal z.B. (gelber).
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "s�sser" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv1 = Adjektiv1 +1
EndIf
If Adjektiv1 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "s�sser"
Print
Print "Und jetzt steigere das Adjektiv zweimal z.B. (am gelbsten).
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "am s�ssesten" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv2 = Adjektiv2 +1
EndIf
If Adjektiv2 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "am s�ssesten"
Print
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=18
Smeili=0
Goto Programmstart
End



.Aufgabe19
PauseChannel HGM
ClsVB
Goto Pronomen
End




.Pronomen
Cls 
Locate 1,1
Pronomen = 0   Pronomen1 = 0
HGrundH=LoadImage (".\Bilder\Meergn.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,0,0
Print"Erkenne das Pronomen in dem folgenden Satz."
Print"Schreibe das Pronomen und dr�cke Enter"
Print
Print "Mein Fahrrad f�hrt nicht mehr so gut."
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "mein" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Pronomen = Pronomen +1
EndIf
If Pronomen =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
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
If Pronomen1 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "das"
Print



Cls 
Locate 1,1
Pronomen = 0   Pronomen1 = 0
HGrundH=LoadImage (".\Bilder\Meergn.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,0,0
Print"Erkenne das Pronomen in dem folgenden Satz."
Print"Schreibe das Pronomen und dr�cke Enter"
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
If Pronomen =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
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
If Pronomen1 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "die"
Print




Cls 
Locate 1,1
Pronomen = 0   Pronomen1 = 0
HGrundH=LoadImage (".\Bilder\Meergn.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,0,0
Print"Erkenne das Pronomen in dem folgenden Satz."
Print"Schreibe das Pronomen und dr�cke Enter"
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
If Pronomen =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
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
If Pronomen1 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "die"
Print




Cls 
Locate 1,1
Pronomen = 0   Pronomen1 = 0
HGrundH=LoadImage (".\Bilder\Meergn.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 30,110)
SetFont Schrift
Color 0,0,0
Print"Erkenne das Pronomen in dem folgenden Satz."
Print"Schreibe das Pronomen und dr�cke Enter"
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
If Pronomen =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
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
If Pronomen1 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe sp�ter nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Programmstart
Until Ratwort1$ = "die"
Print
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=19
Smeili=0
Goto Programmstart
End


.LAufgabe
ClsVB
ClsColor 1,255,1
Cls
Schrift = LoadFont ("Arial",40,20100)
SetFont Schrift
Color 1,1,1
Print "Beschrieb:
Print "Letzte Aufgabe!
Print "Dein Feind, der dich am Amfang vom"
Print "Spiel von deinem Haus gejagt hat,"
Print "will dich fangen!"
Print "Renne ihm davon bis die Zeit um ist,"
Print "Noch ein paar Tipps:"
Print "Der Feind wird immer schneller."
Print "Auf dem blauen Feld sind beide schneller."
Print "Der rote Flecken, der immer wieder kommt und"
Print "verschwindet kann man als kurzes"
Print "Versteck nutzen."
Print ""
Print "Viel Gl�ck!"
Input()
ClsVB
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 1000
y = 380
;ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Letzte Aufgabe.jpg")
monster= LoadImage (".\Bilder\Monster.jpg")

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
If (JetztZeit-StartZeit > ZeitMaxX) Then Goto Ende
F2GE#=F2GE#+0.0003
Goto LA1
End




.Ende
PauseChannel HGM
If MX=0 Then
MX=LoadSound (".\Sounds\MusiX.mp3")
LoopSound MX
MXP=PlaySound(MX)
Else
ResumeChannel HGM
EndIf
ChannelVolume MXP,1
ClsVB
Bild=LoadImage (".\Bilder\Br�cke.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 1240
y = 103
ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\EndeB.jpg")
Color 0,0,255


hotX=339
hotY=0
hotW=370
hotH=50

hotX1=711
hotY1=0
hotW1=230
hotH1=50

BEX=1280
XL=1000
YL=-600


Color 128,64,0

Repeat
Cls
If BEX=>250 Then BEX=BEX-1
DrawImage HGrundH, 0,0
If YL<132 Then
XL=XL-1
YL=YL+1
EndIf

Line 1000,132,XL,YL
Line 1001,132,XL+1,YL
Line 1002,132,XL+2,YL
Line 1003,132,XL+3,YL
Line 1004,132,XL+4,YL
Line 1005,132,XL+5,YL



If x<=0 Then x=0
If x>=1250 Then x=1250
If x<=182 Then Exit
    If BEX=<250 Then x = x - 1
      DrawImage rocket, x, y
    Flip
Forever

SeedRnd MilliSecs()
ClsVB

img=LoadImage(".\Bilder\EndeMB.jpg")


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
Delay 3000
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

ClsVB
Schrift = LoadFont ("Arial",30,20100)
SetFont Schrift
Color 255,1,1
SetBuffer BackBuffer()
backdrop=LoadImage(".\Bilder\Schluss.jpg")
scroll_y=0
AAAER=1024
While Not AAAER=-1600
	TileBlock backdrop,0,scroll_y
	TileImage backdrop,9,scroll_y*1
	scroll_y=scroll_y-1
	If scroll_y=ImageHeight(backdrop) Then scroll_y=0
AAAER=AAAER+1200	
Text 1,AAAER,"Homepage: http://www.nicobosshard.ch"
AAAER=AAAER-30
Text 1,AAAER,"E-Mail; nico@bosshome.ch"
AAAER=AAAER-30
Text 1,AAAER,""
AAAER=AAAER-30
Text 1,AAAER,"Ich hoffe, dass Ihnen mein Programm gefallen hat."
AAAER=AAAER-30
Text 1,AAAER,""
AAAER=AAAER-30
Text 1,AAAER,""
AAAER=AAAER-30
Text 1,AAAER,""
AAAER=AAAER-30
Text 1,AAAER,""
AAAER=AAAER-30
Text 1,AAAER,""
AAAER=AAAER-30
Text 1,AAAER,""
AAAER=AAAER-30
Text 1,AAAER,"Gezeichnet"
AAAER=AAAER-30
Text 1,AAAER,"Aurelia Bosshard"
AAAER=AAAER-30
Text 1,AAAER,""
AAAER=AAAER-30
Text 1,AAAER,""
AAAER=AAAER-30
Text 1,AAAER,"Programmfehler gesucht"
AAAER=AAAER-30
Text 1,AAAER,"Geplant"
AAAER=AAAER-30
Text 1,AAAER,"Fotografiert"
AAAER=AAAER-30
Text 1,AAAER,"Daniel Bosshard"
AAAER=AAAER-30
Text 1,AAAER,""
AAAER=AAAER-30
Text 1,AAAER,""
AAAER=AAAER-30
Text 1,AAAER,"Schreibfehler Korrigiert"
AAAER=AAAER-30
Text 1,AAAER,"Witze abgetippt"
AAAER=AAAER-30
Text 1,AAAER,"Christina Spiess"
AAAER=AAAER-30
Text 1,AAAER,""
AAAER=AAAER-30
Text 1,AAAER,""
AAAER=AAAER-30
Text 1,AAAER,"Programmierfehler verbessert"
AAAER=AAAER-30
Text 1,AAAER,"Programmfehler gesucht"
AAAER=AAAER-30
Text 1,AAAER,"Sound"
AAAER=AAAER-30
Text 1,AAAER,"Geplant"
AAAER=AAAER-30
Text 1,AAAER,"Gezeichnet"
AAAER=AAAER-30
Text 1,AAAER,"Fotografiert"
AAAER=AAAER-30
Text 1,AAAER,"Help geschrieben"
AAAER=AAAER-30
Text 1,AAAER,"Programmidee"
AAAER=AAAER-30
Text 1,AAAER,"Programmiert"
AAAER=AAAER-30
Text 1,AAAER,"Nico Bosshard"
AAAER=AAAER-30
Text 1,AAAER,""
AAAER=AAAER-30
Text 1,AAAER,""
AAAER=AAAER-30
Text 1,AAAER,"Programm programmiert mit Blitzbasic 2D"
AAAER=AAAER-30
Text 1,AAAER,"Bilder H�hle von Nico und Daniel Bosshard in Elba aufgenommen"
AAAER=AAAER-30
Text 1,AAAER,""
AAAER=AAAER-30
Text 1,AAAER,"Schlusswort"
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
Smeili=100
Goto Programmstart
End




.Vorfilm
ChannelPitch HGM, 18000
ClsVB
FY=900
FX=50
SFG#=3
Feind=LoadImage (".\Bilder\Monster1.bmp")
HGrundSF=LoadImage (".\Bilder\14.jpg")
g=1
VFSWA=22000
Repeat
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
Until VFFBSF=1

ClsVB
ClsColor 1,255,1
Cls
Schrift = LoadFont ("Arial",30,20100)
SetFont Schrift
Color 1,1,1
Print "Dein Feind hat dich entf�hrt,"
Print "und weit weg von deinem Zuhause in sein Nest gelegt!"
Print ""
Print "L�se alle 20 Aufgaben um wieder"
Print "zu deinem Haus zu gelangen."
Print "Viel Gl�ck!"
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
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 0*SFG#, 0*SFG#, 19*SFG#, 32*SFG#
Delay 200
FX=FX-25
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 19*SFG#,0*SFG#, 22*SFG#, 32*SFG#
Delay 200
FX=FX-25
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 41*SFG#, 0*SFG#, 19*SFG#, 32*SFG#
Delay 200
FX=FX-25
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 60*SFG#, 0*SFG#, 22*SFG#, 32*SFG#
Delay 200
FX=FX-25
End Function






Function SXP()
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 0*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 19*SFG#,32*SFG#, 22*SFG#, 32*SFG#
Delay 200
FX=FX+25
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 41*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 60*SFG#, 32*SFG#, 19*SFG#, 32*SFG#
Delay 200
FX=FX+25
End Function
















Function SXPB()
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 0*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY-12
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 19*SFG#,32*SFG#, 22*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY-12
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 41*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY-12
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 60*SFG#, 32*SFG#, 19*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY-12
End Function



Function SXPB1()
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 0*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY-10
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 19*SFG#,32*SFG#, 22*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY-10
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 41*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY-10
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 60*SFG#, 32*SFG#, 19*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY-10
End Function


Function SXPB2()
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 0*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY+5
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 19*SFG#,32*SFG#, 22*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY+5
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 41*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY+5
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 60*SFG#, 32*SFG#, 19*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY+5
End Function





Function SXPB3()
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 0*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY+11
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 19*SFG#,32*SFG#, 22*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY+11
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 41*SFG#, 32*SFG#, 18*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY+11
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 60*SFG#, 32*SFG#, 19*SFG#, 32*SFG#
Delay 200
FX=FX+25
FY=FY+11
End Function


















Function SYP()
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 0*SFG#, 64*SFG#, 22*SFG#, 32*SFG#
Delay 175
FY=FY-4*SFG#
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 22*SFG#,64*SFG#, 19*SFG#, 32*SFG#
Delay 175
FY=FY-4*SFG#
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 41*SFG#,64*SFG#, 22*SFG#, 32*SFG#
Delay 175
FY=FY-4*SFG#
Cls
DrawImage HGrundSF,0,0
DrawImageRect SF(g), FX, FY, 63*SFG#,64*SFG#, 22*SFG#, 32*SFG#
Delay 175
FY=FY-4*SFG#
End Function





Function SpielstandS()
filein = ReadFile(Name$+".txt")
ReadLine$(filein)
ReadLine$(filein)
ReadLine$(filein)
ReadLine$(filein)
For i=0 To 999
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
WriteLine fileout, Protokoll$
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
Schrift = LoadFont ("Arial",35,20100)
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
Text 1,1,"Warnung:"
Text 1,35,WarnungF$
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
VWait
FreeImage HGrundH
Locate 1,1
Color 0,0,0
ClsColor 0,0,0
SetBuffer BackBuffer()
Cls
SetBuffer FrontBuffer()
Cls
FlushKeys
FlushMouse
VWait
End Function