AppTitle "Lernen mit Smiley"
Const width=1280,height=1024
Const intensity=20
Const gravity#=.1
Const xsize=16
Const ysize=16
Const xdiv=width/xsize
Const ydiv=height/ysize
Const total=xdiv*ydiv
Const frames=25
Const choice=total/frames
Const fps=25

Global AAAB
Global KTIBWG
Global filename$
Global ERINV
Global ESPS


Modus=GfxModeExists(1280,1024,16)
Cls
Locate 1,1
If Modus=0 Then Print "Dieser Bildschirm unterstützt"
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



DHMVEZ#=0.03
DHTL#=1
DHTL#=DHTL#+DHMVEZ#


Cls
Locate 1,1
HidePointer
TB=LoadImage(".\Bilder\Titelbild.jpg")
TileBlock TB,0,0
Delay 200
SetBuffer FrontBuffer()
LockBuffer FrontBuffer()
Repeat
rgb=ReadPixelFast(x,y,FrontBuffer)
rgb=rgb/DHTL#
WritePixelFast x,y,rgb
x=x+1
If x=71 Then y=y+1 x=0
If y=64 And x=70 Then
UnlockBuffer FrontBuffer()
SetBuffer FrontBuffer()
TB1=CreateImage (71, 64)
SetBuffer ImageBuffer (TB1)
CopyRect 0, 0, 71, 64, 0, 0 ,FrontBuffer(),ImageBuffer(TB1)
SetBuffer FrontBuffer()
Cls
TileBlock TB1,0,0
Delay 200
r=0
g=0
b=0
x=0
y=0
DHMVEZ#=DHMVEZ#/2
DHTL#=DHTL#+DHMVEZ#
ZDNUVDW=ZDNUVDW+1
EndIf
Until ZDNUVDW=40




Schrift = LoadFont ("Arial",130,200)
SetFont Schrift
Color 0,0,0
Text 200,450,"Leren mit Smiley"
Delay 100
SetBuffer BackBuffer()

Type Frag
	Field x#,y#,xs#,ys#
	Field r,g,b
End Type

Repeat	
	UpdateFrags()
	
	Cls
	TileBlock TB
	Color 0,0,0
	Text 200,450,"Leren mit Smiley"
	If MouseDown(1)
		CreateFrags()
	Else
		Color 255,255,255
		Rect MouseX(),MouseY()-3,1,7
		Rect MouseX()-3,MouseY(),7,1
	EndIf
	
	RenderFrags()
	Flip
Forever

End

Function CreateFrags()
	count=Rnd(intensity)+intensity
	anstep#=360.0/count
	an#=Rnd(anstep)
	For k=1 To count
		f.Frag=New Frag
		f\x=MouseX()
		f\y=MouseY()
		f\xs=Cos( an ) * Rnd( 3,4 )
		f\ys=Sin( an ) * Rnd( 3,4 )
		f\r=255:f\g=255:f\b=255
		an=an+anstep
	Next
End Function

Function UpdateFrags()
	For f.Frag=Each Frag
		f\x=f\x+f\xs
		f\y=f\y+f\ys
		f\ys=f\ys+gravity
		If f\x<0 Or f\x>=width Or f\y>=height
			Delete f
		Else If f\b>0
			f\b=f\b-5
		Else If f\g>0
			f\g=f\g-3
		Else If f\r>0
			f\r=f\r-1
			If f\r=0 Then Delete f
		EndIf
	Next
End Function

Function RenderFrags()
	For f.Frag=Each Frag
		Color f\r,f\g,f\b
		Rect f\x-1,f\y-1,3,3
	Next
End Function

Input()

FreeImage TB+"FFTBZ"

Schrift = LoadFont ("Arial",130,20100)
SetFont Schrift
Color 1,1,1
Text 0,0,"Bilder werden geladen"
kamelpiano=LoadSound (".\Sounds\kamelpiano.mp3")
LoopSound kamelpiano
SoundPan kamelpiano,+0.5
kamelpianoP=PlaySound(kamelpiano)
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
Print "Ja: Drücke 1"
Print "Nein: Drücke 2"
Print "An diese Version nicht mehr erinnern: Drücke 3"
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
gfxBall=LoadImage(".\Bilder\Titelbild.jpg")
TileBlock gfxBall
Schrift = LoadFont ("Arial",130,20100)
SetFont Schrift
Color 1,1,1
Text 0,0,"Bilder werden geladen"
Delay 100
EndIf
If Taste=51 Then
fileout = WriteFile("Nicht_an_Version_erinnern.dat")
WriteLine fileout,NV$
CloseFile(fileout)
Cls
gfxBall=LoadImage(".\Bilder\Titelbild.jpg")
TileBlock gfxBall
Schrift = LoadFont ("Arial",130,20100)
SetFont Schrift
Color 1,1,1
Text 0,0,"Bilder werden geladen"
Delay 100
EndIf
EndIf
.KINVB2
Global hgjkhkgkh
Global AndGetroffenS
Global AndGetroffenS1
Global AndGetroffenS2
Global AndGetroffenS3
Global AndGetroffenS4
Global AndGetroffenS5
Global AndGetroffenS6
Global DVGHJFHMHJG
Global Fehler16SS1
Global Fehler16SS2
Global Fehler16SS3
Global Fehler16SS4
Global Fehler16SS5
Global Fehler16SS6
Global A14Z
Global A14Z1
Global A14Z2
Global A14Z3
Global A14Z4
Global A14Z5
Global DVGHJFHMHJG1
Global DVGHJFHMHJG2
Global DVGHJFHMHJG3
Global DVGHJFHMHJG4
Global DVGHJFHMHJG5
Global DVGHJFHMHJG6
Global DVGHJFHMHJG7
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
Global Punkte
Global HRTZUIO
Global HERHZ
Global NameS$
Global Name$
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
Global Aufgaben
Global Smeili
Global A1
Global A2
Global A3
Global A4
Global A5
Global A6
Global A7
Global A8
Global A9
Global A10
Global A11
Global A12
Global A13
Global A14
Global A15
Global A16
Global A17
Global A18
Global A19
Global A20
Global A21
Global A22
Global A23
Global A24
Global A25
Global A26
Global A27
Global A28
Global A29
Global A30
Global A31
Global A32
Global A33
Global A34
Global A35
Global A36
Global A37
Global A38
Global A39
Global A40
Global A41
Global A42
Global A43
Global A44
Global A45
Global A46
Global A47
Global A48
Global A49
Global A50



a$="n"
Anfang=LoadImage (".\Bilder\Sonnenuntergang.jpg")
Auswahl0=LoadImage (".\Bilder\Auswahl.jpg")
Auswahl1=LoadImage (".\Bilder\Auswahl1.jpg")
Auswahl2=LoadImage (".\Bilder\Auswahl2.jpg")
Auswahl3=LoadImage (".\Bilder\Auswahl3.jpg")
Auswahl4=LoadImage (".\Bilder\Auswahl4.jpg")
Auswahl5=LoadImage (".\Bilder\Auswahl5.jpg")
Auswahl6=LoadImage (".\Bilder\Auswahl6.jpg")
Auswahl7=LoadImage (".\Bilder\Auswahl7.jpg")
Auswahl8=LoadImage (".\Bilder\Auswahl8.jpg")
Auswahl9=LoadImage (".\Bilder\Auswahl9.jpg")
SchwiriegkeitsstuffeW0=LoadImage (".\Bilder\Schwierigkeitsstufe.jpg")
SchwiriegkeitsstuffeW1=LoadImage (".\Bilder\SchwierigkeitsstufeK1.jpg")
SchwiriegkeitsstuffeW2=LoadImage (".\Bilder\SchwierigkeitsstufeK2.jpg")
SchwiriegkeitsstuffeW3=LoadImage (".\Bilder\SchwierigkeitsstufeK3.jpg")
SchwiriegkeitsstuffeW4=LoadImage (".\Bilder\SchwierigkeitsstufeK4.jpg")
SchwiriegkeitsstuffeW5=LoadImage (".\Bilder\SchwierigkeitsstufeK5.jpg")
HGrundH1=LoadImage (".\Bilder\FigurS.jpg")
HGrundH2=LoadImage (".\Bilder\Figur1.jpg")
HGrundH3=LoadImage (".\Bilder\Figur2.jpg")
HGrundH4=LoadImage (".\Bilder\Figur3.jpg")
HGrundH5=LoadImage (".\Bilder\Figur4.jpg")
HGrundH6=LoadImage (".\Bilder\Figur5.jpg")
HGrundH7=LoadImage (".\Bilder\Figur6.jpg")
HGrundH8=LoadImage (".\Bilder\Figur7.jpg")
HGrundH9=LoadImage (".\Bilder\Figur8.jpg")
HGrundH10=LoadImage (".\Bilder\Figur9.jpg")
HGrundH11=LoadImage (".\Bilder\Figur10.jpg")
HGrundH12=LoadImage (".\Bilder\Figur11.jpg")
HGrundH13=LoadImage (".\Bilder\Figur12.jpg")
HGrundH14=LoadImage (".\Bilder\Figur13.jpg")
HGrundH15=LoadImage (".\Bilder\Figur14.jpg")
HGrundH16=LoadImage (".\Bilder\Figur15.jpg")
HGrundH17=LoadImage (".\Bilder\Figur16.jpg")
HGrundH18=LoadImage (".\Bilder\Figur17.jpg")
HGrundH19=LoadImage (".\Bilder\Figur18.jpg")
HGrundH20=LoadImage (".\Bilder\Figur19.jpg")
HGrundH21=LoadImage (".\Bilder\Figur21.jpg")
HGrundH22=LoadImage (".\Bilder\Figur22.jpg")
HGrundH23=LoadImage (".\Bilder\Figur23.jpg")
HGrundH24=LoadImage (".\Bilder\Figur24.jpg")
HGrundH25=LoadImage (".\Bilder\Figur25.jpg")
HGrundH26=LoadImage (".\Bilder\Figur26.jpg")
HGrundH27=LoadImage (".\Bilder\Figur27.jpg")
HGrundH28=LoadImage (".\Bilder\Figur28.jpg")
HGrundH29=LoadImage (".\Bilder\Figur28.jpg")
HGrundH30=LoadImage (".\Bilder\Figur30.jpg")
HGrundH31=LoadImage (".\Bilder\Figur31.jpg")
HGrundH32=LoadImage (".\Bilder\Figur32.jpg")
HGrundH33=LoadImage (".\Bilder\Figur33.jpg")
HGrundH34=LoadImage (".\Bilder\Figur34.jpg")
UebersichtB=LoadImage (".\Bilder\Übersicht.jpg")
UebersichtB1=LoadImage (".\Bilder\ÜbersichtK1.jpg")
UebersichtB2=LoadImage (".\Bilder\ÜbersichtK2.jpg")
UebersichtB3=LoadImage (".\Bilder\ÜbersichtK3.jpg")
UebersichtB4=LoadImage (".\Bilder\ÜbersichtK4.jpg")
UebersichtB5=LoadImage (".\Bilder\ÜbersichtK5.jpg")
UebersichtB6=LoadImage (".\Bilder\ÜbersichtK6.jpg")
UebersichtB7=LoadImage (".\Bilder\ÜbersichtK7.jpg")
UebersichtB8=LoadImage (".\Bilder\ÜbersichtK8.jpg")
UebersichtB9=LoadImage (".\Bilder\ÜbersichtK9.jpg")
UebersichtB10=LoadImage (".\Bilder\ÜbersichtK10.jpg")
UebersichtB11=LoadImage (".\Bilder\ÜbersichtK11.jpg")
UebersichtB12=LoadImage (".\Bilder\ÜbersichtK12.jpg")
UebersichtB13=LoadImage (".\Bilder\ÜbersichtK13.jpg")
UebersichtB14=LoadImage (".\Bilder\ÜbersichtK14.jpg")
UebersichtB15=LoadImage (".\Bilder\ÜbersichtK15.jpg")
UebersichtB16=LoadImage (".\Bilder\ÜbersichtK16.jpg")
UebersichtB17=LoadImage (".\Bilder\ÜbersichtK17.jpg")
UebersichtB18=LoadImage (".\Bilder\ÜbersichtK18.jpg")
UebersichtB19=LoadImage (".\Bilder\ÜbersichtK19.jpg")
UebersichtB20=LoadImage (".\Bilder\ÜbersichtK20.jpg")
UebersichtB21=LoadImage (".\Bilder\ÜbersichtK21.jpg")
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
Goto F1
End

.F1
Cls
Locate 1,1
Flip
Schrift = LoadFont ("Arial",55,20100)
SetFont Schrift
Color 0,255,0
Punkte = 0
PlayMusic (".\Sounds\name1.mp3")
Locate 1,1 
HGrundH=LoadImage (".\Bilder\Zugersee.jpg")
DrawImage HGrundH, 0,0
HGrundH=LoadImage (".\Bilder\Lava.jpg")
DrawImage HGrundH, 0,0
DrawImage HGrundH, 255,0
DrawImage HGrundH, 510,0
DrawImage HGrundH, 765,0
DrawImage HGrundH, 1020,0
DrawImage HGrundH, 1275,0

DrawImage HGrundH, 0,255
DrawImage HGrundH, 255,255
DrawImage HGrundH, 510,255
DrawImage HGrundH, 765,255
DrawImage HGrundH, 1020,255
DrawImage HGrundH, 1275,255

DrawImage HGrundH, 0,510
DrawImage HGrundH, 255,510
DrawImage HGrundH, 510,510
DrawImage HGrundH, 765,510
DrawImage HGrundH, 1020,510
DrawImage HGrundH, 1275,510

DrawImage HGrundH, 0,765
DrawImage HGrundH, 255,765
DrawImage HGrundH, 510,765
DrawImage HGrundH, 765,765
DrawImage HGrundH, 1020,765
DrawImage HGrundH, 1275,765


DrawImage HGrundH, 0,1020
DrawImage HGrundH, 255,1020
DrawImage HGrundH, 510,1020
DrawImage HGrundH, 765,1020
DrawImage HGrundH, 1020,1020
DrawImage HGrundH, 1275,1020


DrawImage HGrundH, 0,1275
DrawImage HGrundH, 255,1275
DrawImage HGrundH, 510,1275
DrawImage HGrundH, 765,1275
DrawImage HGrundH, 1020,1275
DrawImage HGrundH, 1275,1275
Print "Gib deinen Namen ein und drücke auf Enter"
Delay 5000
FlushMouse
FlushKeys
Name$ = Input()
If KeyHit(1)=True
End
EndIf
If  Len  (Name$)=0 Then Goto Fehler1
If  Len  (Name$)=1 Then Goto Fehler1
If  Len  (Name$)=2 Then Goto Fehler1




Type HighScore
Field Name$
Field Score%
Field Level%
End Type

Best.HighScore = New HighScore
Best\Name = Name$
Best\Score = Aufgaben
Best\Level = Smeili

; Open a file to write to
fileout = WriteFile("Name.dat")

;Write the information To the file
WriteString( fileout, Best\Name )
WriteInt( fileout, Best\Score )
WriteByte( fileout, Best\Level )

; Close the file
CloseFile( fileout )




Goto F2

.Fehler1
Cls
Locate 1,1
Print "Der Name muss mindestens aus drei Stellen bestehen!"
Delay 3000
FlushKeys
Goto F1
End



.F2
;Spielstandsicherung
PRReadScore (Name$)
Function PRReadScore (Name$)
  Datei = ReadFile (Name$)
  If Datei = 0 Then Return 0
  Punkte = ReadInt (Datei)
  CloseFile Datei
  Return Punkte
End Function

Function PRWriteScore (Name$, Punkte)
  Datei = WriteFile (Name$)
  If Datei = 0 Then Return 0
  WriteInt Datei, Punkte
  CloseFile Datei
  Print "Punktestand: " + Name$ + Punkte
  Return 1
End Function





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
Uebersicht=0
UebersichtA=0
SpielstandKopierenA=0
HERHZ=0

SetBuffer BackBuffer()
backdrop=LoadImage(".\Bilder\Lava.jpg")
scroll_y=0
While Not AAAER=225
	TileBlock backdrop,0,scroll_y
	TileImage backdrop,9,scroll_y*1
	TileImage backdrop,23,scroll_y*2
	TileImage backdrop,23,scroll_y*3
	scroll_y=scroll_y+1
	If scroll_y=ImageHeight(backdrop) Then scroll_y=0
	Flip
AAAER=AAAER+1
Wend

If Punkte=0 Then AuswahOBL=0 SWZH=1 Goto SchwierikeitsstufeW
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
gfxCircle=0
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
;Speicher von Übersicht werden auf 0 gesetzt!
A1=0
A2=0
A3=0
A4=0
A5=0
A6=0
A7=0
A8=0
A9=0
A10=0
A11=0
A12=0
A13=0
A14=0
A15=0
A16=0
A17=0
A18=0
A19=0
A20=0
A21=0
A22=0
A23=0
A24=0
A25=0
A26=0
A27=0
A28=0
A29=0
A30=0
A31=0
A32=0
A33=0
A34=0
A35=0
A36=0
A37=0
A38=0
A39=0
A40=0
A41=0
A42=0
A43=0
A44=0
A45=0
A46=0
A47=0
A48=0
A49=0
A50=0
UebersichtA=0
Uebersicht=0
ClsVB
If jhhfgfssfgjsgjmsgmsztzsh=1 Then
PauseChannel MXP
Goto Uebersicht1
EndIf
UebersichtA=0

.AuswahOB
AuswahOBL=0
;Wichtig!
;Wichtig!
;Wichtig!
ASDREFGHHGHUJK=1
gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255
HGrundH=LoadImage (".\Bilder\Auswahl.jpg")
hotX= 380
hotY=0
hotW=520
hotH=100

hotX1= 380
hotY1=100
hotW1=520
hotH1=100

hotX2= 380
hotY2=200
hotW2=520
hotH2=100

hotX3= 380
hotY3=300
hotW3=520
hotH3=100

hotX4= 380
hotY4=400
hotW4=520
hotH4=100

hotX5= 380
hotY5=500
hotW5=520
hotH5=100

hotX6= 380
hotY6=600
hotW6=520
hotH6=100

hotX7= 380
hotY7=700
hotW7=520
hotH7=100

hotX8= 380
hotY8=800
hotW8=520
hotH8=100
MXV#=0.99
If ChannelPlaying(MXP)=1 Then RTZUGFDFGHUJHGFGHJKJHFGHJ=1

.L21
If RTZUGFDFGHUJHGFGHJKJHFGHJ=1 Then
If MXV#>0.0 And ASRTZJHGFGHJUHGJKJH=0 Then
MXV#=MXV#-0.01
ChannelVolume MXP,MXV#
EndIf
If MXV#<0.3 Then
PauseChannel MXP
ResumeChannel kamelpianoP
EndIf
EndIf
SDFGH=SDFGH+100
circleX=MouseX()
circleY=MouseY()
Cls
Locate 1,1
Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
Rect hotX2,hotY2,hotW2,hotH2,0
Rect hotX3,hotY3,hotW3,hotH3,0
Rect hotX4,hotY4,hotW4,hotH4,0
Rect hotX5,hotY5,hotW5,hotH5,0
Rect hotX6,hotY6,hotW6,hotH,0
Rect hotX7,hotY7,hotW7,hotH7,0
Rect hotX8,hotY8,hotW8,hotH8,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto L1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto L2
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX2,hotY2,hotW2,hotH2) Goto L3
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX3,hotY3,hotW3,hotH3) Goto L4
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX4,hotY4,hotW4,hotH4) Goto L5
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX5,hotY5,hotW5,hotH5) Goto L6
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX6,hotY6,hotW6,hotH6) Goto L7
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX7,hotY7,hotW7,hotH7) Goto L8
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX8,hotY8,hotW8,hotH8) Goto L9
HGrundH=Auswahl0
Delay 50
Goto L21
.L1
HGrundH=Auswahl1
If MouseDown(1) Then
PauseChannel MXP
ResumeChannel kamelpianoP
Goto Spielstandabfrage
EndIf
Delay 50
Goto L21
.L2
HGrundH=Auswahl2
If MouseDown(1) Then
PauseChannel MXP
ResumeChannel kamelpianoP
Goto Uebersicht
EndIf
Delay 50
Goto L21
.L3
HGrundH=Auswahl3
If MouseDown(1) Then
PauseChannel MXP
ResumeChannel kamelpianoP
Goto SpielfigurW
EndIf
Delay 50
Goto L21
.L4
HGrundH=Auswahl4
If MouseDown(1) Then
PauseChannel MXP
ResumeChannel kamelpianoP
Goto SchwierikeitsstufeW
EndIf
Delay 50
Goto L21
.L5
HGrundH=Auswahl5
If MouseDown(1) Then
PauseChannel MXP
ResumeChannel kamelpianoP
Goto SpielstandKopieren
EndIf
Delay 50
Goto L21
.L6
HGrundH=Auswahl6
If MouseDown(1) Then
PauseChannel MXP
ResumeChannel kamelpianoP
Goto SpielstandUn
EndIf
Delay 50
Goto L21
.L7
HGrundH=Auswahl7
If MouseDown(1) Then
PauseChannel MXP
ResumeChannel kamelpianoP
Goto SpielstandL
EndIf
Delay 50
Goto L21
.L8
HGrundH=Auswahl8
If MouseDown(1) Then
PauseChannel MXP
ResumeChannel kamelpianoP
Goto Help
EndIf
Delay 50
Goto L21
.L9
HGrundH=Auswahl9
If MouseDown(1) Then
PauseChannel MXP
ResumeChannel kamelpianoP
Goto EPro
EndIf
Delay 50
Goto L21


.EPro
SeedRnd MilliSecs()
ClsVB


img=LoadImage(".\Bilder\Ende.jpg")


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
Uebersicht=1
Goto Spielstandabfrage
End

.Uebersicht1
ClsVB
.UebersichtOB
jhhfgfssfgjsgjmsgmsztzsh=0
AuswahOBL=0
;Wichtig!
;Wichtig!
;Wichtig!
ASDREFGHHGHUJK=1
gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255
HGrundH=UebersichtB
hotX= 380
hotY=0
hotW=520
hotH=48

hotX1= 380
hotY1=48
hotW1=520
hotH1=48

hotX2= 380
hotY2=96
hotW2=520
hotH2=48

hotX3= 380
hotY3=144
hotW3=520
hotH3=48

hotX4= 380
hotY4=192
hotW4=520
hotH4=48

hotX5= 380
hotY5=240
hotW5=520
hotH5=48

hotX6= 380
hotY6=288
hotW6=520
hotH6=48

hotX7= 380
hotY7=336
hotW7=520
hotH7=48

hotX8= 380
hotY8=384
hotW8=520
hotH8=48

hotX9= 380
hotY9=432
hotW9=520
hotH9=48

hotX10= 380
hotY10=480
hotW10=520
hotH10=48

hotX11= 380
hotY11=528
hotW11=520
hotH11=48

hotX12= 380
hotY12=576
hotW12=520
hotH12=48

hotX13= 380
hotY13=624
hotW13=520
hotH13=48

hotX14= 380
hotY14=672
hotW14=520
hotH14=48

hotX15= 380
hotY15=720
hotW15=520
hotH15=48

hotX16= 380
hotY16=768
hotW16=520
hotH16=48

hotX17= 380
hotY17=816
hotW17=520
hotH17=48

hotX18= 380
hotY18=864
hotW18=520
hotH18=48

hotX19= 380
hotY19=912
hotW19=520
hotH19=48

hotX20= 380
hotY20=960
hotW20=520
hotH20=48

UebersichtA=1
FlushKeys
FlushMouse
StartZeit = MilliSecs()
Const ZeitMaxU = 1000  ; 1 Sekunden
.UE21
circleX=MouseX()
circleY=MouseY()
Cls
Locate 1,1
Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
Rect hotX2,hotY2,hotW2,hotH2,0
Rect hotX3,hotY3,hotW3,hotH3,0
Rect hotX4,hotY4,hotW4,hotH4,0
Rect hotX5,hotY5,hotW5,hotH5,0
Rect hotX6,hotY6,hotW6,hotH6,0
Rect hotX7,hotY7,hotW7,hotH7,0
Rect hotX8,hotY8,hotW8,hotH8,0
Rect hotX9,hotY9,hotW9,hotH9,0
Rect hotX10,hotY10,hotW10,hotH10,0
Rect hotX11,hotY11,hotW11,hotH11,0
Rect hotX12,hotY12,hotW12,hotH12,0
Rect hotX13,hotY13,hotW13,hotH13,0
Rect hotX14,hotY14,hotW14,hotH14,0
Rect hotX15,hotY15,hotW15,hotH15,0
Rect hotX16,hotY16,hotW16,hotH16,0
Rect hotX17,hotY17,hotW17,hotH17,0
Rect hotX18,hotY18,hotW18,hotH18,0
Rect hotX19,hotY19,hotW19,hotH19,0
Rect hotX20,hotY20,hotW20,hotH20,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
Flip
JetztZeit = MilliSecs()
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto U1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto U2
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX2,hotY2,hotW2,hotH2) Goto U3
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX3,hotY3,hotW3,hotH3) Goto U4
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX4,hotY4,hotW4,hotH4) Goto U5
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX5,hotY5,hotW5,hotH5) Goto U6
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX6,hotY6,hotW6,hotH6) Goto U7
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX7,hotY7,hotW7,hotH7) Goto U8
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX8,hotY8,hotW8,hotH8) Goto U9
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX9,hotY9,hotW9,hotH9) Goto U10
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX10,hotY10,hotW10,hotH10) Goto U11
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX11,hotY11,hotW11,hotH11) Goto U12
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX12,hotY12,hotW12,hotH12) Goto U13
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX13,hotY13,hotW13,hotH13) Goto U14
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX14,hotY14,hotW14,hotH14) Goto U15
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX15,hotY15,hotW15,hotH15) Goto U16
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX16,hotY16,hotW16,hotH16) Goto U17
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX17,hotY17,hotW17,hotH17) Goto U18
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX18,hotY18,hotW18,hotH18) Goto U19
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX19,hotY19,hotW19,hotH19) Goto U20
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX20,hotY20,hotW20,hotH20) Goto U21
HGrundH=UebersichtB
Delay 50
Goto UE21
.U1
HGrundH=UebersichtB1
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe1
Delay 50
Goto UE21
.U2
HGrundH=UebersichtB2
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe2
Delay 50
Goto UE21
.U3
HGrundH=UebersichtB3
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe3
Delay 50
Goto UE21
.U4
HGrundH=UebersichtB4
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe4
Delay 50
Goto UE21
.U5
HGrundH=UebersichtB5
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe5
Delay 50
Goto UE21
.U6
HGrundH=UebersichtB6
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe6
Delay 50
Goto UE21
.U7
HGrundH=UebersichtB7
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe7
Delay 50
Goto UE21
.U8
HGrundH=UebersichtB8
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe8
Delay 50
Goto UE21
.U9
HGrundH=UebersichtB9
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe9
Delay 50
Goto UE21
.U10
HGrundH=UebersichtB10
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe10
Delay 50
Goto UE21
.U11
HGrundH=UebersichtB11
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe11
Delay 50
Goto UE21
.U12
HGrundH=UebersichtB12
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe12
Delay 50
Goto UE21
.U13
HGrundH=UebersichtB13
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe13
Delay 50
Goto UE21
.U14
HGrundH=UebersichtB14
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe14
Delay 50
Goto UE21
.U15
HGrundH=UebersichtB15
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe15
Delay 50
Goto UE21
.U16
HGrundH=UebersichtB16
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe16
Delay 50
Goto UE21
.U17
HGrundH=UebersichtB17
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe17
Delay 50
Goto UE21
.U18
HGrundH=UebersichtB18
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe18
Delay 50
Goto UE21
.U19
HGrundH=UebersichtB19
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Aufgabe19
Delay 50
Goto UE21
.U20
HGrundH=UebersichtB20
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto LAufgabe
Delay 50
Goto UE21
.U21
HGrundH=UebersichtB21
If MouseDown(1) And (JetztZeit-StartZeit > ZeitMaxU) Then Goto Auswahl
Delay 50
Goto UE21
End



.Uebersicht3
ResumeChannel kamelpianoP
jhhfgfssfgjsgjmsgmsztzsh=1
Goto Auswahl
End


.SpielfigurW
SpielfigurW=0
SpielfigurW=1
Goto Spielstandabfrage
End


.SpielfigurW1
ClsVB
Schrift = LoadFont ("Arial",50,20100)
SetFont Schrift
SpielfigurW=0
SpielfigurW=1
HGrundH=LoadImage (".\Bilder\Streiffen.jpg")
DrawImage HGrundH, 0,0
DrawImage HGrundH, 0,100
DrawImage HGrundH, 0,200
DrawImage HGrundH, 0,300
DrawImage HGrundH, 0,400
DrawImage HGrundH, 0,500
DrawImage HGrundH, 0,600
DrawImage HGrundH, 0,700
DrawImage HGrundH, 0,800
DrawImage HGrundH, 0,900
DrawImage HGrundH, 0,1000
DrawImage HGrundH, 0,1100
DrawImage HGrundH, 0,1200
DrawImage HGrundH, 0,1300
Print "Welche Spielfigur willst du haben?


Print "1"
Print "2"
Print "3"
Print "4"
Print "5"
Print "6"
Print "7"
Print "8"
Print "9"
Print "10"
Print "11"
Print "12"
Print "13"
Print "14"
Print "15"
Print "16"
Print "17"
Print "18"
Locate 100,50
Print "19"
Locate 100,100
Print "20"
Locate 100,150
Print "21"
Locate 100,200
Print "22"
Locate 100,250
Print "23"
Locate 100,300
Print "24"
Locate 100,350
Print "25"
Locate 100,400
Print "26"
Locate 100,450
Print "27"
Locate 100,500
Print "28"
Locate 100,550
Print "29"
Locate 100,600
Print "30"
Locate 100,649
Print "31"
Locate 100,698
Print "32"
Locate 100,747
Print "33"
Locate 100,796
Print "34"
DrawImage HGrundH1, 50,50
DrawImage HGrundH2, 50,100
DrawImage HGrundH3, 50,150
DrawImage HGrundH4, 50,200
DrawImage HGrundH5, 50,250
DrawImage HGrundH6, 50,300
DrawImage HGrundH7, 50,350
DrawImage HGrundH8, 50,400
DrawImage HGrundH9, 50,450
DrawImage HGrundH10, 50,500
DrawImage HGrundH11, 50,550
DrawImage HGrundH12, 50,600
DrawImage HGrundH13, 50,650
DrawImage HGrundH14, 50,700
DrawImage HGrundH15, 50,750
DrawImage HGrundH16, 50,800
DrawImage HGrundH17, 50,850
DrawImage HGrundH18, 50,900
DrawImage HGrundH19, 150,50
DrawImage HGrundH20, 150,100
DrawImage HGrundH21, 150,150
DrawImage HGrundH22, 150,200
DrawImage HGrundH23, 150,250
DrawImage HGrundH24, 150,300
DrawImage HGrundH25, 150,350
DrawImage HGrundH26, 150,400
DrawImage HGrundH27, 150,450
DrawImage HGrundH28, 150,500
DrawImage HGrundH29, 150,550
DrawImage HGrundH30, 150,600
DrawImage HGrundH31, 150,650
DrawImage HGrundH32, 150,700
DrawImage HGrundH33, 150,750
DrawImage HGrundH34, 150,800
Locate 1,950
Stielfigur$=Input()
If Stielfigur$="1" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH1,".\Bilder\"+Name$+".jpg")
If Stielfigur$="2" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH2,".\Bilder\"+Name$+".jpg")
If Stielfigur$="3" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH3,".\Bilder\"+Name$+".jpg")
If Stielfigur$="4" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH4,".\Bilder\"+Name$+".jpg")
If Stielfigur$="5" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH5,".\Bilder\"+Name$+".jpg")
If Stielfigur$="6" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH6,".\Bilder\"+Name$+".jpg")
If Stielfigur$="7" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH7,".\Bilder\"+Name$+".jpg")
If Stielfigur$="8" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH8,".\Bilder\"+Name$+".jpg")
If Stielfigur$="9" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH9,".\Bilder\"+Name$+".jpg")
If Stielfigur$="10" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH10,".\Bilder\"+Name$+".jpg")
If Stielfigur$="11" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH11,".\Bilder\"+Name$+".jpg")
If Stielfigur$="12" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH12,".\Bilder\"+Name$+".jpg")
If Stielfigur$="13" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH13,".\Bilder\"+Name$+".jpg")
If Stielfigur$="14" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH14,".\Bilder\"+Name$+".jpg")
If Stielfigur$="15" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH15,".\Bilder\"+Name$+".jpg")
If Stielfigur$="16" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH16,".\Bilder\"+Name$+".jpg")
If Stielfigur$="17" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH17,".\Bilder\"+Name$+".jpg")
If Stielfigur$="18" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH18,".\Bilder\"+Name$+".jpg")
If Stielfigur$="19" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH19,".\Bilder\"+Name$+".jpg")
If Stielfigur$="20" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH20,".\Bilder\"+Name$+".jpg")
If Stielfigur$="21" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH21,".\Bilder\"+Name$+".jpg")
If Stielfigur$="22" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH22,".\Bilder\"+Name$+".jpg")
If Stielfigur$="23" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH23,".\Bilder\"+Name$+".jpg")
If Stielfigur$="24" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH24,".\Bilder\"+Name$+".jpg")
If Stielfigur$="25" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH25,".\Bilder\"+Name$+".jpg")
If Stielfigur$="26" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH26,".\Bilder\"+Name$+".jpg")
If Stielfigur$="27" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH27,".\Bilder\"+Name$+".jpg")
If Stielfigur$="28" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH28,".\Bilder\"+Name$+".jpg")
If Stielfigur$="29" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH29,".\Bilder\"+Name$+".jpg")
If Stielfigur$="30" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH30,".\Bilder\"+Name$+".jpg")
If Stielfigur$="31" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH31,".\Bilder\"+Name$+".jpg")
If Stielfigur$="32" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH32,".\Bilder\"+Name$+".jpg")
If Stielfigur$="33" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH33,".\Bilder\"+Name$+".jpg")
If Stielfigur$="34" Then DeleteFile ".\Bilder\"+Name$+".jpg" ok=SaveImage (HGrundH34,".\Bilder\"+Name$+".jpg")
SpielfigurW=0
If HRTZUIO=1 Then Goto Spielstandabfrage
SpielfigurW=0
;Wichtig!
;Wichtig!
;Wichtig!
ASDREFGHHGHUJK=1
Goto Auswahl
End




.SchwierikeitsstufeW
SchwierikeitsstufeA=0
SchwierikeitsstufeA=1
Goto Spielstandabfrage
End




.SchwierikeitsstufeW1
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
If MouseDown(1) Then Schwierikeitsstufe$="1" Goto SchwierikeitsstufeW2
Delay 50
Goto SW21
.SW2
HGrundH=SchwiriegkeitsstuffeW2
If MouseDown(1) Then Schwierikeitsstufe$="2" Goto SchwierikeitsstufeW2
Delay 50
Goto SW21
.SW3
HGrundH=SchwiriegkeitsstuffeW3
If MouseDown(1) Then Schwierikeitsstufe$="3" Goto SchwierikeitsstufeW2
Delay 50
Goto SW21
.SW4
HGrundH=SchwiriegkeitsstuffeW4
If MouseDown(1) Then Schwierikeitsstufe$="4" Goto SchwierikeitsstufeW2
Delay 50
Goto SW21
.SW5
HGrundH=SchwiriegkeitsstuffeW5
If MouseDown(1) And SWZH=0 Then Goto SchwierikeitsstufeW2
Delay 50
Goto SW21


.SchwierikeitsstufeW2
If Schwierikeitsstufe$="1" Then Punkte =1 PRWriteScore (Name$, Punkte)
If Schwierikeitsstufe$="2" Then Punkte =2 PRWriteScore (Name$, Punkte)
If Schwierikeitsstufe$="3" Then Punkte =3 PRWriteScore (Name$, Punkte)
If Schwierikeitsstufe$="4" Then Punkte =4 PRWriteScore (Name$, Punkte)
SchwierikeitsstufeA=0
If HERHZTREZ=1 Then Goto SpielstandKopierenI2Ga
If HERHZ=1 Then HERHZ=0 ;Goto Teil1SSG
Goto Auswahl
End



.SpielstandKopieren
SpielstandKopierenA=0
SpielstandKopierenA=1
Goto Spielstandabfrage
End



.SpielstandKopieren1
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
Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
Rect hotX2,hotY2,hotW2,hotH2,0
Rect hotX3,hotY3,hotW3,hotH3,0
Rect hotX4,hotY4,hotW4,hotH4,0
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

quellpfad$ = ".\"+Name$+".dat"
zielpfad$ = ".\"+Name$+"BAK.dat"
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
ClsVB
Schrift = LoadFont ("Arial",35,20100)
SetFont Schrift
Color 1,1,1
ClsColor 253,202,13
Cls
ClsColor 255,255,255
Print "Warnung!"
Print "Willst du wirklich deinen Spielstand mit der letzten Sicherunggsdatei Überschreiben?"
Antwort1$ = Input()
If Antwort1$ = "Ja" Goto SpielstandKopierenI2G
If Antwort1$ = "ja" Goto SpielstandKopierenI2G
If Antwort1$ = "Ok" Goto SpielstandKopierenI2G
If Antwort1$ = "ok" Goto SpielstandKopierenI2G
If Antwort1$ = "Ja gern" Goto SpielstandKopierenI2G
If Antwort1$ = "ja gern" Goto SpielstandKopierenI2G
If Antwort1$ = "Ja!" Goto SpielstandKopierenI2G
If Antwort1$ = "ja!" Goto SpielstandKopierenI2G
If Antwort1$ = "Ok!" Goto SpielstandKopierenI2G
If Antwort1$ = "ok!" Goto SpielstandKopierenI2G
If Antwort1$ = "Ja gern!" Goto SpielstandKopierenI2G
If Antwort1$ = "ja gern!" Goto SpielstandKopierenI2G
SpielstandKopierenA=0
Goto Auswahl
End




.SpielstandKopierenI2G

DeleteFile ".\"+Name$+".dat"

quellpfad$ = ".\"+Name$+"BAK.dat"
zielpfad$ = ".\"+Name$+".dat"
CopyFile quellpfad$, zielpfad$

If Punkte=0 Then HERHZTREZ=1 Goto SchwierikeitsstufeW1
Goto SpielstandKopierenI2Ga
End



.SpielstandKopierenI2Ga
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
DrawImage HGrundH, 0,0
DrawImage HGrundH, 255,0
DrawImage HGrundH, 510,0
DrawImage HGrundH, 765,0
DrawImage HGrundH, 1020,0
DrawImage HGrundH, 1275,0

DrawImage HGrundH, 0,255
DrawImage HGrundH, 255,255
DrawImage HGrundH, 510,255
DrawImage HGrundH, 765,255
DrawImage HGrundH, 1020,255
DrawImage HGrundH, 1275,255

DrawImage HGrundH, 0,510
DrawImage HGrundH, 255,510
DrawImage HGrundH, 510,510
DrawImage HGrundH, 765,510
DrawImage HGrundH, 1020,510
DrawImage HGrundH, 1275,510

DrawImage HGrundH, 0,765
DrawImage HGrundH, 255,765
DrawImage HGrundH, 510,765
DrawImage HGrundH, 765,765
DrawImage HGrundH, 1020,765
DrawImage HGrundH, 1275,765


DrawImage HGrundH, 0,1020
DrawImage HGrundH, 255,1020
DrawImage HGrundH, 510,1020
DrawImage HGrundH, 765,1020
DrawImage HGrundH, 1020,1020
DrawImage HGrundH, 1275,1020


DrawImage HGrundH, 0,1275
DrawImage HGrundH, 255,1275
DrawImage HGrundH, 510,1275
DrawImage HGrundH, 765,1275
DrawImage HGrundH, 1020,1275
DrawImage HGrundH, 1275,1270
FlushKeys
Schrift = LoadFont ("Arial",35,20100)
SetFont Schrift
Print "Gib bitte den Namen ein dessen Spielstand du auf deinen Spielstand kopieren willst.
NameS$ = Input()
filename$=NameS$
If FileType(filename$)=1 Then Goto SpielstandKopierenI3G
If FileType(filename$)=0 Then Goto Fehler
If FileType(filename$)=2 Then Print "This is a directory!"
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
quellpfad$ = ".\Bilder\"+NameS$+".jpg"
zielpfad$ =".\Bilder\"+Name$+".jpg"
CopyFile quellpfad$, zielpfad$

quellpfad$ = ".\"+NameS$+".dat"
zielpfad$ = ".\"+Name$+".dat"
CopyFile quellpfad$, zielpfad$



PRReadScore1 (NameS$)
Function PRReadScore1 (NameS$)
  Datei = ReadFile (Name$)
  If Datei = 0 Then Return 0
  Punkte = ReadInt (Datei)
  CloseFile Datei
  Return Punkte
End Function

Function PRWriteScore1 (NameS$, Punkte)
  Datei = WriteFile (Name$)
  If Datei = 0 Then Return 0
  WriteInt Datei, Punkte
  CloseFile Datei
  Print "Punktestand: " + Name$ + Punkte
  Return 1
End Function

SFFFFF=Punkte

PRReadScore2 (NameS$)
Function PRReadScore2 (NameS$)
  Datei = ReadFile (Name$)
  If Datei = 0 Then Return 0
  Punkte = ReadInt (Datei)
  CloseFile Datei
  Return Punkte
End Function

Function PRWriteScore2 (NameS$, Punkte)
  Datei = WriteFile (Name$)
  If Datei = 0 Then Return 0
  WriteInt Datei, Punkte
  CloseFile Datei
  Print "Punktestand: " + Name$ + Punkte
  Return 1
End Function

Punkte=SFFFFF
SpielstandKopierenA=0
;Wichtig!
;Wichtig!
;Wichtig!
ASDREFGHHGHUJK=1
Goto Auswahl
End






.Help
Include ".\Nico 2010 Help.bb"
Goto Auswahl
End





.SpielstandUn
ClsVB
Schrift = LoadFont ("Arial",35,20100)
SetFont Schrift
HGrundH=LoadImage (".\Bilder\Hintergrund1.jpg")
Color 1,1,1
DrawImage HGrundH, 0,0
Print "Warnung!"
Print "Willst du wirklich deinen Spielstand mit allen Sicherungsdateien umbenennen?
Antwort1$ = Input()
If Antwort1$ = "Ja" Goto SpielstandUn1
If Antwort1$ = "ja" Goto SpielstandUn1
If Antwort1$ = "Ok" Goto SpielstandUn1
If Antwort1$ = "ok" Goto SpielstandUn1
If Antwort1$ = "Ja gern" Goto SpielstandUn1
If Antwort1$ = "ja gern" Goto SpielstandUn1
If Antwort1$ = "Ja!" Goto SpielstandUn1
If Antwort1$ = "ja!" Goto SpielstandUn1
If Antwort1$ = "Ok!" Goto SpielstandUn1
If Antwort1$ = "ok!" Goto SpielstandUn1
If Antwort1$ = "Ja gern!" Goto SpielstandUn1
If Antwort1$ = "ja gern!" Goto SpielstandUn1
;Wichtig!
;Wichtig!
;Wichtig!
ASDREFGHHGHUJK=1
SpielstandLA=0
Goto Auswahl
End

.SpielstandUn1
Datei$=".\SpielstandUn.exe"
ExecFile Datei$
End



End



.SpielstandL
SpielstandLA=0
SpielstandLA=1
Goto Spielstandabfrage
End


.SpielstandLa
ClsVB
Schrift = LoadFont ("Arial",45,20100)
HGrundH=LoadImage (".\Bilder\Hintergrund1.jpg")
Color 1,1,1
DrawImage HGrundH, 0,0
Print "Warnung!"
Print "Willst du wirklich deinen Spielstand mit allen Sicherungsdateien löschen?
Antwort1$ = Input()
If Antwort1$ = "Ja" Goto SpielstandLa1
If Antwort1$ = "ja" Goto SpielstandLa1
If Antwort1$ = "Ok" Goto SpielstandLa1
If Antwort1$ = "ok" Goto SpielstandLa1
If Antwort1$ = "Ja gern" Goto SpielstandLa1
If Antwort1$ = "ja gern" Goto SpielstandLa1
If Antwort1$ = "Ja!" Goto SpielstandLa1
If Antwort1$ = "ja!" Goto SpielstandLa1
If Antwort1$ = "Ok!" Goto SpielstandLa1
If Antwort1$ = "ok!" Goto SpielstandLa1
If Antwort1$ = "Ja gern!" Goto SpielstandLa1
If Antwort1$ = "ja gern!" Goto SpielstandLa1
;Wichtig!
;Wichtig!
;Wichtig!
ASDREFGHHGHUJK=1
SpielstandLA=0
Goto Auswahl
End

.SpielstandLa1
Datei$=".\SpielstandL.exe"
ExecFile Datei$
End


.Karte
ClsVB
HGrundH=LoadImage (".\Bilder\Karte.jpg")
DrawImage HGrundH, 0,0
WaitKey ()
Goto Spielstandabfrage
End



;Programmstart
.Spielstandabfrage
FreeSound GameP
FreeSound Game
ResumeChannel kamelpianoP




filein = ReadFile(Name$+".txt")
Dim RST$(999)
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
WriteLine fileout, "Smiley="+Smiley
WriteLine fileout, "Schwierigkeitsstuffe="+Schwierigkeitsstuffe
WriteLine fileout, "Spielfigur="+Spielfigur
WriteLine fileout, "Protokoll:"
Repeat
zwfzdpi=zwfzdpi+1
If RST$(zwfzdpi)="" Then Exit
WriteLine fileout, RST$(zwfzdpi)
Forever
WriteLine fileout, Protokoll$
CloseFile fileout



;Sachen =0
roket=0
x=0
y=0
X=0
Y=0
gfxCircle=0
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


If Uebersicht=1 Then Goto Uebersicht1
If SpielstandLA=1 Then Goto SpielstandLa
If SchwierikeitsstufeA=1 Then Goto SchwierikeitsstufeW1
If SpielstandKopierenA=1 Then Goto SpielstandKopieren1
If SpielfigurW=1 Then Goto SpielfigurW1



If Aufgaben=1 And Smeili=1 Then Goto Teil1a
If Aufgaben=1 And Smeili=2 Then Goto Teil1b
If Aufgaben=3 And Smeili=1 Then Goto Teil2a
If Aufgaben=3 And Smeili=2 Then Goto Teil2b
If Aufgaben=5 And Smeili=1 Then Goto Teil3a
If Aufgaben=5 And Smeili=2 Then Goto Teil3b
If Aufgaben=7 And Smeili=1 Then Goto Teil4a
If Aufgaben=7 And Smeili=2 Then Goto Teil4b
If Aufgaben=2 Then Goto Teil1s
If Aufgaben=4 Then Goto Teil2s
If Aufgaben=6 Then Goto Teil3s
If Aufgaben=8 Then Goto Teil4s
If Aufgaben=9 Then Goto Teil7s
If Aufgaben=10 Then Goto Teil8s
If Aufgaben=11 Then Goto Teil9s
If Aufgaben=12 Then Goto Teil10s
If Aufgaben=13 Then Goto Teil11s
If Aufgaben=14 Then Goto Teil12s
If Aufgaben=15 Then Goto Teil13s
If Aufgaben=16 Then Goto Teil17
If Aufgaben=17 Then Goto Teil19
If Aufgaben=18 Then Goto Teil20
If Aufgaben=19 Then Goto Teil21
If Aufgaben=100 And Smeili=100 Then Goto Uebersicht1
Goto Vorfilm
End


.Teil1
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level1.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level1K1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level1K2.jpg")
;Spielstände werden auf Spielstart gesetzt

SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255

x = 614
y = 951

ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level1.jpg")



gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255

hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil1Maus
circleX=MouseX()
circleY=MouseY()
Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<41 Then x=41
If y<0 Then y=0
If x>1209 Then x=1209
If y>993 Then y=993
If x<130 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe1
If x>1120 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe2
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
    DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil1Maus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil1Maus2
Cls
HGrundH=Bild1
Goto Teil1Maus
End

.Teil1Maus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil1Maus
End


.Teil1Maus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil1Maus
End


.Teil1a
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level1a.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level1aK1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level1aK2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255

x = 614
y = 951

ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level1a.jpg")



gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255

hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil1aMaus
circleX=MouseX()
circleY=MouseY()
Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<41 Then x=41
If y<0 Then y=0
If x>1209 Then x=1209
If y>993 Then y=993
If x>1120 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe2
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
    DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil1aMaus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil1aMaus2
Cls
HGrundH=Bild1
Goto Teil1aMaus
End

.Teil1aMaus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil1aMaus
End


.Teil1aMaus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil1aMaus
End




.Teil1b
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level1b.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level1bK1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level1bK2.jpg")

SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255

x = 614
y = 951

ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level1b.jpg")



gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255

hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil1bMaus
circleX=MouseX()
circleY=MouseY()
Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<41 Then x=41
If y<0 Then y=0
If x>1209 Then x=1209
If y>993 Then y=993
If x<130 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe1
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
    DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil1bMaus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil1bMaus2
Cls
HGrundH=Bild1
Goto Teil1bMaus
End

.Teil1bMaus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil1bMaus
End


.Teil1bMaus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil1bMaus
End





.Aufgabe1
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

PauseChannel kamelpianoP
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
;Hier wird dei Spielfigur für Teil1a oder Teil1S gelagden!
rocket = LoadImage (".\Bilder\"+Name+"bmp")

Repeat
Color 255,255,255


If Punkte=1 Then Goto W1
If Punkte=2 Then Goto W2
If Punkte=3 Then Goto W3
If Punkte=4 Then Goto W4


.W1
If Punkte=1 Then Zahl1= Rand(0,10) Zahl2= Rand(0,10)
Goto Aufgabe1a
End

.W2
If Punkte=2 Then Zahl1= Rand(0,100) Zahl2= Rand(0,100)
Goto Aufgabe1a
End

.W3
If Punkte=3 Then Zahl1= Rand(0,1000) Zahl2= Rand(0,1000)
Goto Aufgabe1a
End

.W4
If Punkte=4 Then Zahl1= Rand(0,10000) Zahl2= Rand(0,10000)
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
Print "Du hast "+ Richtig+ " Aufgaben richtig gelöst!"
If Richtig<17 Then Print "Du hast zu viele Fehler, versuche die Aufgabe nochmals!" Delay 4000 Goto Aufgabe1
If UebersichtA=1 Then Goto Uebersicht3
;Spielstandsicherung
Aufgaben=Aufgaben+1
Smeili=1
FlushKeys
FlushMouse
Goto Spielstandabfrage
End



.Aufgabe2
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

PauseChannel kamelpianoP
FlushKeys
;Hier wird dei Spielfigur für Teil1a oder Teil1S gelagden!
rocket = LoadImage (".\Bilder\"+Name+"bmp")
;Hir werden Bilder und Saunds fur Aufgabe1 geladen!
HGrundH=LoadImage (".\Bilder\Waldsw.jpg")
PauseChannel kamelpianoP


DrawImage HGrundH, 0,0
Delay 1000
DrawImage HGrund1, 200,0
Delay 50
DrawImage HGrund2, 416,0
Delay 50
DrawImage HGrund3, 632,0
Delay 50
DrawImage HGrund4, 848,0
Delay 50
DrawImage HGrund5, 1064,0
Delay 50
DrawImage HGrund6, 200,256
Delay 50
DrawImage HGrund7, 416,256
Delay 50
DrawImage HGrund8, 632,256
Delay 50
DrawImage HGrund9, 848,256
Delay 50
DrawImage HGrund10, 1064,256
Delay 50
DrawImage HGrund11, 200,512
Delay 50
DrawImage HGrund12, 416,512
Delay 50
DrawImage HGrund13, 632,512
Delay 50
DrawImage HGrund14, 848,512
Delay 50
DrawImage HGrund15, 1064,512
Delay 50
DrawImage HGrund16, 200,768
Delay 50
DrawImage HGrund17, 416,768
Delay 50
DrawImage HGrund18, 632,768
Delay 50
DrawImage HGrund19, 848,768
Delay 50
DrawImage HGrund20, 1064,768
Delay 50
Color 0,255,255 
Schrift = LoadFont ("Arial",45,20100)
SetFont Schrift
Cls
Locate 1,1
FlushKeys
FlushMouse
Color 255,0,0
Print "Beschrieb"
Schrift = LoadFont ("Arial",24)
SetFont Schrift
Print "Zuerst wird ein Wort je nach Schwierikeitsstufe 0.75 bis 3 Sekunden lang gezeigt,dann wird"
Print "es gelöscht. Du musst es dann fehlerfrei schreiben (und Enter drücken)."
WaitKey ()
ClsColor 255,0,0
Cls
Color 255,255,255 
DrawImage HGrundH, 0,0
Locate 1,1
Schrift = LoadFont ("Arial",24)
SetFont Schrift
Falsch=0 : Richtig=0 : Aufgabe=0
Restore Woerter2
 ;Einleseschlaufe für 140 Wörter
      Const Maxs = 139
Dim Wort$(Maxs)

  Delay 1000
ClsColor 0,0,0
Cls
            

.Woerter2


HGrundH=LoadImage (".\Bilder\Waldsw.jpg")
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

If Punkte=1 Then Delay 3000
If Punkte=2 Then Delay 750 Delay 750 Delay 750
If Punkte=3 Then Delay 750 Delay 750
If Punkte=4 Then Delay 750

Cls
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
HGrundH=LoadImage (".\Bilder\Waldsw.jpg")
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
Cls
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
Goto Spielstandabfrage
End














.Teil1s
ClsVB
SetBuffer BackBuffer ()
HGrundH=LoadImage (".\Bilder\Nico 2010 Level1s.jpg")
rocket= LoadImage (".\Bilder\Lift1.jpg")
rocket1= LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
MaskImage rocket1, 255, 0, 255

x = 614
y = 951

ClsColor 1,1,1

Repeat
    y = y - 1
Delay 10
Cls
    DrawImage HGrundH, 1,1
    DrawImage rocket, 1,y
    y=y-30
    DrawImage rocket1, x,y
    y=y+30
Flip
    Until y=792
Delay 500
Goto Teil2
End








.Teil2s
ClsVB
SetBuffer BackBuffer ()
HGrundH=LoadImage (".\Bilder\Nico 2010 Level2s.jpg")
rocket= LoadImage (".\Bilder\Lift1.jpg")
rocket1= LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
MaskImage rocket1, 255, 0, 255

x = 614
y = 792

ClsColor 1,1,1

Repeat
    y = y - 1
Delay 10
Cls
    DrawImage HGrundH, 1,1
    DrawImage rocket, 1,y
    y=y-30
    DrawImage rocket1, x,y
    y=y+30
Flip
    Until y=601
Delay 500
Goto Teil3
End








.Teil3s 
ClsVB
SetBuffer BackBuffer ()
HGrundH=LoadImage (".\Bilder\Nico 2010 Level3s.jpg")
rocket= LoadImage (".\Bilder\Lift1.jpg")
rocket1= LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
MaskImage rocket1, 255, 0, 255

x = 614
y = 601

ClsColor 1,1,1

Repeat
    y = y - 1
Delay 10
Cls
    DrawImage HGrundH, 1,1
    DrawImage rocket, 1,y
    y=y-30
    DrawImage rocket1, x,y
    y=y+30
Flip
    Until y=411
Delay 500
Goto Teil4
End






.Teil4s 
ClsVB
SetBuffer BackBuffer ()
HGrundH=LoadImage (".\Bilder\Nico 2010 Level4s.jpg")
rocket= LoadImage (".\Bilder\Lift1.jpg")
rocket1= LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
MaskImage rocket1, 255, 0, 255

x = 614
y = 411

ClsColor 1,1,1

Repeat
    y = y - 1
Delay 10
Cls
    DrawImage HGrundH, 1,1
    DrawImage rocket, 1,y
    y=y-30
    DrawImage rocket1, x,y
    y=y+30
Flip
    Until y=221
Delay 500
Goto Teil5
End







.Teil6s
ClsVB
SetBuffer BackBuffer ()
HGrundH=LoadImage (".\Bilder\Nico 2010 Level6s.jpg")
rocket= LoadImage (".\Bilder\Lift2.jpg")
rocket1= LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
MaskImage rocket1, 255, 0, 255

x = 278
y = 221

ClsColor 1,1,1

Repeat
    y = y + 1
Delay 10
Cls
    DrawImage HGrundH, 1,1
    DrawImage rocket, x,y
    y=y-30
    x=x+32
    DrawImage rocket1, x,y
    y=y+30
    x=x-32
Flip
    Until y=411
Delay 500
Goto Teil7
End







.Teil7s 
ClsVB
SetBuffer BackBuffer ()
HGrundH=LoadImage (".\Bilder\Nico 2010 Level7s.jpg")
rocket= LoadImage (".\Bilder\Lift2.jpg")
rocket1= LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
MaskImage rocket1, 255, 0, 255

x = 278
y = 411

ClsColor 1,1,1

Repeat
    y = y + 1
Delay 10
Cls
    DrawImage HGrundH, 1,1
    DrawImage rocket, x,y
    y=y-30
    x=x+32
    DrawImage rocket1, x,y
    y=y+30
    x=x-32
Flip
    Until y=601
Delay 500
Goto Teil8
End









.Teil8s
ClsVB
SetBuffer BackBuffer ()
HGrundH=LoadImage (".\Bilder\Nico 2010 Level8s.jpg")
rocket= LoadImage (".\Bilder\Lift2.jpg")
rocket1= LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
MaskImage rocket1, 255, 0, 255

x = 278
y = 601

ClsColor 1,1,1

Repeat
    y = y + 1
Delay 10
Cls
    DrawImage HGrundH, 1,1
    DrawImage rocket, x,y
    y=y-30
    x=x+32
    DrawImage rocket1, x,y
    y=y+30
    x=x-32
Flip
    Until y=792
Delay 500
Goto Teil9
End




.Teil9s 
ClsVB
SetBuffer BackBuffer ()
HGrundH=LoadImage (".\Bilder\Nico 2010 Level9s.jpg")
rocket= LoadImage (".\Bilder\Lift2.jpg")
rocket1= LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
MaskImage rocket1, 255, 0, 255

x = 278
y = 792

ClsColor 1,1,1

Repeat
    y = y + 1
Delay 10
Cls
    DrawImage HGrundH, 1,1
    DrawImage rocket, x,y
    y=y-30
    x=x+32
    DrawImage rocket1, x,y
    y=y+30
    x=x-32
Flip
    Until y=977
Delay 500
Goto Teil10
End





.Teil10s 
ClsVB
SetBuffer BackBuffer ()
HGrundH=LoadImage (".\Bilder\Nico 2010 Level10s.jpg")
rocket= LoadImage (".\Bilder\Lift2.jpg")
rocket1= LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
MaskImage rocket1, 255, 0, 255

x = 959
y = 951

ClsColor 1,1,1

Repeat
    y = y - 1
Delay 10
Cls
    DrawImage HGrundH, 1,1
    DrawImage rocket, x,y
    y=y-30
    x=x+32
    DrawImage rocket1, x,y
    y=y+30
    x=x-32
Flip
    Until y=789
Delay 500
Goto Teil11
End




.Teil11s 
ClsVB
SetBuffer BackBuffer ()
HGrundH=LoadImage (".\Bilder\Nico 2010 Level11s.jpg")
rocket= LoadImage (".\Bilder\Lift2.jpg")
rocket1= LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
MaskImage rocket1, 255, 0, 255

x = 959
y = 789

ClsColor 1,1,1

Repeat
    y = y - 1
Delay 10
Cls
    DrawImage HGrundH, 1,1
    DrawImage rocket, x,y
    y=y-30
    x=x+32
    DrawImage rocket1, x,y
    y=y+30
    x=x-32
Flip
    Until y=599
Delay 500
Goto Teil12
End





.Teil12s 
ClsVB
SetBuffer BackBuffer ()
HGrundH=LoadImage (".\Bilder\Nico 2010 Level12s.jpg")
rocket= LoadImage (".\Bilder\Lift2.jpg")
rocket1= LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
MaskImage rocket1, 255, 0, 255

x = 959
y = 599

ClsColor 1,1,1

Repeat
    y = y - 1
Delay 10
Cls
    DrawImage HGrundH, 1,1
    DrawImage rocket, x,y
    y=y-30
    x=x+32
    DrawImage rocket1, x,y
    y=y+30
    x=x-32
Flip
    Until y=410
Delay 500
Goto Teil13
End







.Teil13s 
ClsVB
SetBuffer BackBuffer ()
HGrundH=LoadImage (".\Bilder\Nico 2010 Level13s.jpg")
rocket= LoadImage (".\Bilder\Lift2.jpg")
rocket1= LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
MaskImage rocket1, 255, 0, 255

x = 959
y = 410

ClsColor 1,1,1

Repeat
    y = y - 1
Delay 10
Cls
    DrawImage HGrundH, 1,1
    DrawImage rocket, x,y
    y=y-30
    x=x+32
    DrawImage rocket1, x,y
    y=y+30
    x=x-32
Flip
    Until y=221
Delay 500
Goto Teil14
End








.Teil2
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level2.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level2K1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level2K2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255

x = 614
y = 761

ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level2.jpg")



gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255

hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil2Maus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<41 Then x=41
If y<0 Then y=0
If x>1209 Then x=1209
If y>993 Then y=993
If x<130 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe3
If x>1120 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe4
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
    DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil2Maus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil2Maus2
Cls
HGrundH=Bild1
Goto Teil2Maus
End

.Teil2Maus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil2Maus
End


.Teil2Maus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil2Maus
End


.Teil2a
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level2a.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level2aK1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level2aK2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255

x = 614
y = 761

ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level2a.jpg")



gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255

hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil2aMaus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<41 Then x=41
If y<0 Then y=0
If x>1209 Then x=1209
If y>993 Then y=993
If x>1120 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe4
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
    DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil2aMaus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil2aMaus2
Cls
HGrundH=Bild1
Goto Teil2aMaus
End

.Teil2aMaus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil2aMaus
End


.Teil2aMaus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil2aMaus
End




.Teil2b
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level2b.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level2bK1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level2bK2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 614
y = 761

ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level2b.jpg")



gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255

hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil2bMaus
circleX=MouseX()
circleY=MouseY()
Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<41 Then x=41
If y<0 Then y=0
If x>1209 Then x=1209
If y>993 Then y=993
If x<130 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe3
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
    DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil2bMaus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil2bMaus2
Cls
HGrundH=Bild1
Goto Teil2bMaus
End

.Teil2bMaus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil2bMaus
End


.Teil2bMaus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil2bMaus
End










.Aufgabe3
Goto Zinn
End


.Zinn
ClsVB
PauseChannel kamelpianoP
FlushKeys
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial", 70,2000)
SetFont Schrift
Print "Der Standhafte Zinnsoldat"
Schrift = LoadFont ("Arial", 23,40)
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
Schrift = LoadFont ("Arial", 12,100)
SetFont Schrift
Print "Seite 3 von 7"
Schrift = LoadFont ("Arial", 23,40)
SetFont Schrift
WaitKey ()
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
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
Schrift = LoadFont ("Arial", 12,100)
SetFont Schrift
Print "Seite 4 von 7"
Schrift = LoadFont ("Arial", 23,40)
SetFont Schrift
WaitKey ()
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
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
If Zinnsoldat1$ = "In die Tänzerin"Then Print "Richtig 2P" Textverstentnis=2 Goto ZinnB
If Zinnsoldat1$ = "In die Tenzerin"Then Print "Richtig aber die Rechschreibung nicht! 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto ZinnB
If Zinnsoldat1$ = "Täntzerin"Then Print "Richtig aber die Rechschreibung nicht! 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto ZinnB
If Zinnsoldat1$ = "In die Täntzerin"Then Print "Richtig aber die Rechschreibung nicht! 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto ZinnB
If Zinnsoldat1$ = "Tenzerin"Then Print "Richtig aber die Rechschreibung nicht! 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto ZinnB
If Zinnsoldat1$ = "Tänzerin"Then Print "Richtig 2P" Delay 3000 Textverstentnis =2 Goto ZinnB
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
If Zinnsoldat2$ = "Fünfzig" Then Print "Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto ZinnC
If Zinnsoldat2$ = "fünfzig" Then Print "Richtig 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto ZinnC
Print "Falsch"
Goto ZinnC
End
.ZinnC
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
Print "Was dachte der Zinnsoldaten als das Boot untergieng?"
Zinnsoldat3$ = Input()
If Zinnsoldat3$ = "Er dachte, dass er die Täntzerin nie wieder sehen würde" Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto Zinnvergleich1
If Zinnsoldat3$ = "Er dachte an die Tänzerin" Then Print " Fast Richtig aber die Rechtschriebung nicht 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto Zinnvergleich1
If Zinnsoldat3$ = "Er dachte dass er die Tentzerin nie wieder sehen würde" Then Print"Richtig aber die Rechtschriebung nicht 1P" Delay 3000 Textverstentnis=Textverstentnis +1 Goto Zinnvergleich1
If Zinnsoldat3$ = "dass er die Täntzerin nie wieder sehen würde" Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto Zinnvergleich1
If Zinnsoldat3$ = "An die Tänzerin"Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto Zinnvergleich1
If Zinnsoldat3$ = "Tänzerin"Then Print"Richtig 2P" Delay 3000 Textverstentnis=Textverstentnis +2 Goto Zinnvergleich1
Print "Falsch!"
Goto Zinnvergleich1 
End
.Zinnvergleich1
Locate 1,1
HGrundH=LoadImage (".\Bilder\Sonnenuntergang.jpg")
DrawImage HGrundH, 0,0
If Textverstentnis = 0 Then Print "Lese bitte die Geschichte Bitte Später noch einmahl etwas genauer!" Delay 3000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
If Textverstentnis = 1 Then Print "Lese bitte die Geschichte Bitte Später noch einmahl etwas genauer!" Delay 3000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Textverstentnis = 2 Then Print "Lese bitte die Geschichte Bitte Später noch einmahl etwas genauer!" Delay 3000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
If Textverstentnis = 3 Then Print "Lese bitte die Geschichte Bitte Später noch einmahl etwas genauer!" Delay 3000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Textverstentnis = 4 Then Print "Lese bitte die Geschichte Bitte später noch einmal etwas genauer!" Delay 3000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
If Textverstentnis = 5 Then Print "Lese bitte die Geschichte Bitte später noch einmal etwas genauer!" Delay 3000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
If Textverstentnis = 6 Then Print "Du hast die Geschichte gut gelesen!" Delay 3000 Goto PunkteZinn
If Textverstentnis = 7 Then Print "Du hast die Geschichte sehr gut gelesen!" Delay 3000 Goto PunkteZinn
Goto Spielstandabfrage
End

.PunkteZinn
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=Aufgaben+1
Smeili=1
Goto Spielstandabfrage
End


.Aufgabe4
Goto Nomen
End

.Nomen
ClsVB
PauseChannel kamelpianoP
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
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
Until Ratwort1$ = "der"

Print
Print "Schreibe die Mehrzahl von (Satz) und drücke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "Sätze" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
Nomen2 = Nomen2 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
Until Ratwort1$ = "Sätze"
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
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
Until Ratwort1$ = "das"

Print
Print "Schreibe die Mehrzahl von (Tagebuch) und drücke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "Tagebücher" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"Nomen2 = Nomen2 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
Until Ratwort1$ = "Tagebücher"
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
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
Until Ratwort1$ = "das"

Print
Print "Schreibe die Mehrzahl von (Dorf) und drücke Enter"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "Dörfer" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"Nomen2 = Nomen2 +1
PlayMusic (".\Sounds\Door1.mp3") 
EndIf
If Nomen=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
Until Ratwort1$ = "Dörfer"
Print
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=Aufgaben+1
Smeili=2
Goto Spielstandabfrage
End



















.Teil3
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level3.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level3K1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level3K2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255

x = 614
y = 571 

ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level3.jpg")



gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255

hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil3Maus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<41 Then x=41
If y<0 Then y=0
If x>1209 Then x=1209
If y>993 Then y=993
If x<130 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe5
If x>1120 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe6
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
    DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil3Maus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil3Maus2
Cls
HGrundH=Bild1
Goto Teil3Maus
End

.Teil3Maus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil3Maus
End


.Teil3Maus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil3Maus
End


.Teil3a
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level3a.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level3aK1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level3aK2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255

x = 614
y = 571

ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level3a.jpg")



gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255

hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil3aMaus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<41 Then x=41
If y<0 Then y=0
If x>1209 Then x=1209
If y>993 Then y=993
If x>1120 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe6
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
    DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil3aMaus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil3aMaus2
Cls
HGrundH=Bild1
Goto Teil3aMaus
End

.Teil3aMaus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil3aMaus
End


.Teil3aMaus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil3aMaus
End




.Teil3b
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level3b.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level3bK1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level3bK2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 614
y = 571

ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level3b.jpg")



gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255

hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil3bMaus
circleX=MouseX()
circleY=MouseY()
Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<41 Then x=41
If y<0 Then y=0
If x>1209 Then x=1209
If y>993 Then y=993
If x<130 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe5
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
    DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil3bMaus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil3bMaus2
Cls
HGrundH=Bild1
Goto Teil3bMaus
End

.Teil3bMaus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil3bMaus
End


.Teil3bMaus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil3bMaus
End



.Aufgabe5
ClsVB
Include ".\mazetest.bb"
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=Aufgaben+1
Smeili=1
FlushKeys
FlushMouse
Goto Spielstandabfrage
End




.Aufgabe6
ClsVB
PauseChannel kamelpianoP
FlushKeys
Schrift = LoadFont ("Arial", 24)
SetFont Schrift
HGrundH1=LoadImage (".\Bilder\HMap1.jpg")
DrawImage HGrundH1, 400,0
Restore Woerter
;Einleseschlaufe für 137 Wörter
      Const Max = 136
Dim Wort$(Max)
Print "Errate das Wort indem du einzelne"
Print "Buchstaben vorschlägst."
Print ""
Print "Mit Enter kommst du zum Spielanfang."
Print ""
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
  
           
Versuche = 0
Geraten$ = String$("?",Len(Zufall$))

Repeat
  Print Geraten$
  Versuche = Versuche + 1
  Zeichen$ = Input("Rate mal: ")
  ; Bildschirmende
  If Versuche = 1 Then Cls
  If Versuche = 1 Then  Locate 1,1
  If Versuche = 1 Then DrawImage HGrundH1, 400,0
  If Versuche = 15 Then Cls
  If Versuche = 15 Then  Locate 1,1
  If Versuche = 15 Then DrawImage HGrundH1, 400,0
  If Versuche = 30 Then Cls
  If Versuche = 30 Then  Locate 1,1
  If Versuche = 30 Then DrawImage HGrundH1, 400,0
  If Versuche = 45 Then Cls
  If Versuche = 45 Then  Locate 1,1
  If Versuche = 45 Then DrawImage HGrundH1, 400,0
  If Versuche = 60 Then Cls
  If Versuche = 60 Then  Locate 1,1
  If Versuche = 60 Then DrawImage HGrundH1, 400,0
  If Versuche = 75 Then Cls
  If Versuche = 75 Then  Locate 1,1
  If Versuche = 75 Then DrawImage HGrundH1, 400,0
  If Versuche = 90 Then Cls
  If Versuche = 90 Then  Locate 1,1
  If Versuche = 90 Then DrawImage HGrundH1, 400,0
  If Versuche = 105 Then Cls
  If Versuche = 105 Then  Locate 1,1
  If Versuche = 105 Then DrawImage HGrundH1, 400,0
  If Versuche = 120 Then Cls
  If Versuche = 120 Then  Locate 1,1
  If Versuche = 120 Then DrawImage HGrundH1, 400,0
  If Versuche = 135 Then Cls
  If Versuche = 135 Then  Locate 1,1
  If Versuche = 135 Then DrawImage HGrundH1, 400,0
  If Versuche = 150 Then Cls
  If Versuche = 150 Then  Locate 1,1
  If Versuche = 150 Then DrawImage HGrundH1, 400,0
  If Versuche = 165 Then Cls
  If Versuche = 165 Then  Locate 1,1
  If Versuche = 165 Then DrawImage HGrundH1, 400,0
  ; Zum Aussteigen nur Eingabetaste
  If Zeichen$ = "" Then Goto Spielstandabfrage
  ; Prüfen auch auf Mehrfachvorkommen
  For i = 1 To Len(Zufall$)
    If Zeichen$ = Mid$(Zufall$,i,1) Then 
      Stelle = i
      Neu$ = Left$(Geraten$,Stelle-1) + Zeichen$
      Neu$ = Neu$ + Mid$(Geraten$,Stelle+1)
      Geraten$ = Neu$
    EndIf
  Next
Until Geraten$ = Zufall$

Print Zufall$
If Geraten$ = Zufall$ Then
  Print "Richtig! Du hast " + Versuche + " Mal geraten"
Else
  Print "War wohl nix"
EndIf
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=Aufgaben+1
Smeili=2
FlushKeys
FlushMouse
Goto Spielstandabfrage
End
Return


























.Teil4
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level4.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level4K1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level4K2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255

x = 614
y = 381

ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level4.jpg")



gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255

hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil4Maus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<41 Then x=41
If y<0 Then y=0
If x>1209 Then x=1209
If y>993 Then y=993
If x<130 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe7
If x>1120 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe8
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
    DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil4Maus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil4Maus2
Cls
HGrundH=Bild1
Goto Teil4Maus
End

.Teil4Maus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil4Maus
End


.Teil4Maus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil4Maus
End


.Teil4a
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level4a.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level4aK1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level4aK2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255

x = 614
y = 381

ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level4a.jpg")



gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255

hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil4aMaus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<41 Then x=41
If y<0 Then y=0
If x>1209 Then x=1209
If y>993 Then y=993
If x>1120 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe8
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
    DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil4aMaus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil4aMaus2
Cls
HGrundH=Bild1
Goto Teil4aMaus
End

.Teil4aMaus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil4aMaus
End


.Teil4aMaus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil4aMaus
End




.Teil4b
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level4b.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level4bK1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level4bK2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 614
y = 381

ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level4b.jpg")



gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255

hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil4bMaus
circleX=MouseX()
circleY=MouseY()
Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<41 Then x=41
If x>1209 Then x=1209
If y>993 Then y=993
If x<130 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe7
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
    DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil4bMaus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil4bMaus2
Cls
HGrundH=Bild1
Goto Teil4bMaus
End

.Teil4bMaus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil4bMaus
End


.Teil4bMaus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil4bMaus
End



.Aufgabe7
Goto Verben
End


.Verben
ClsVB
PauseChannel kamelpianoP
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
If Verben=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
Until Ratwort1$ = "fährt"
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
If Verben1=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
Until Ratwort1$ = "fahren"
Print
Print "Und wie heisst das Verb in Präteritum?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "fuhr" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben2 = Verben2 +1
EndIf
If Verben2=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Verben=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Verben1=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
Until Ratwort1$ = "zeichnen"
Print
Print "Und wie heisst das Verb in Präteritum?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "zeichnete" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben2 = Verben2 +1
EndIf
If Verben2=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Verben=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Verben1=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
Until Ratwort1$ = "kennen"
Print
Print "Und wie heisst das Verb in Präteritum?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "kannte" Then
  Print "kannte!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben2 = Verben2 +1
EndIf
If Verben3=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Verben=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Verben1=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage

Until Ratwort1$ = "heissen"
Print
Print "Und wie heisst das Verb in Präteritum?"
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "hiess" Then
  Print "kannte!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Verben2 = Verben2 +1
EndIf
If Verben2=4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
Until Ratwort1$ = "hiess"
Print
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=Aufgaben+1
Smeili=1
Goto Spielstandabfrage
End


.Aufgabe8
ClsVB
PauseChannel kamelpianoP
Cls 
Locate 1,1
Color 1,1,1
HGrundH=LoadImage (".\Bilder\Hintergrund1.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial",45,20100)
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
Print "Achtung!
Print "Wenn du mehr als drei von zehn Aufgaben falsch hast kommst du wieder genau zu diesem Text den du jetzt liest!"
Print "Viel Spass!"
Game= LoadSound (".\Sounds\0001Geame.mp3")
Input()
RichtigLZ=0

GameP=PlaySound(Game)
Delay 5000
PauseChannel GameP
Cls
Locate 1,1
DrawImage HGrundH, 0,0
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
DrawImage HGrundH, 0,0
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
DrawImage HGrundH, 0,0
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
DrawImage HGrundH, 0,0
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
DrawImage HGrundH, 0,0
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
DrawImage HGrundH, 0,0
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
DrawImage HGrundH, 0,0
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
DrawImage HGrundH, 0,0
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
DrawImage HGrundH, 0,0
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
DrawImage HGrundH, 0,0
Locate 200,1
Print "Sekunden"
Locate 1,1
LiedZ=Input ("Das Lied dauerte ")
If LiedZ=7 Then Print "Richtig!" RichtigLZ=RichtigLZ+1
Input()
Cls
Locate 1,1
DrawImage HGrundH, 0,0
Print "Du hast "+ RichtigLZ+" Aufgaben gelöst!"
Input()
ResumeChannel kamelpianoP

If  RichtigLZ=7 Or  RichtigLZ>7 Then
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=Aufgaben+1
Smeili=2
Goto Spielstandabfrage
EndIf
Goto Aufgabe8
End



.Teil5
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level5.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level5K1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level5K2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255

x = 614
y = 191

ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level5.jpg")



gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255

hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil5Maus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<41 Then x=41
If y<0 Then y=0
If x>1209 Then x=1209
If y>993 Then y=993
If x>1150 Then PlayMusic (".\Sounds\Tor.mp3") Smeili=3 Goto Teil6
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
    DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil5Maus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil5Maus2
Cls
HGrundH=Bild1
Goto Teil5Maus
End

.Teil5Maus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil5Maus
End


.Teil5Maus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil5Maus
End











.Teil6
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level6.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level6K1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level6K2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 0
y = 191
ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level6.jpg")


gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255


;Zeit!
StartZeit = MilliSecs()
Const ZeitMaxs = 10000  ; 10 Sekunden

hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil6Maus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<0 Then x=0
If x>565 Then x=565
If y>993 Then y=993
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
  JetztZeit = MilliSecs()
  If (JetztZeit-StartZeit > ZeitMaxs) Then Goto Teil6s
    DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil6Maus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil6Maus2
Cls
HGrundH=Bild1
Goto Teil6Maus
End

.Teil6Maus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil6Maus
End


.Teil6Maus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil6Maus
End















.Teil7
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level7.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level7K1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level7K2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 310
y = 381
ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level7.jpg")


gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255


hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil7Maus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<41 Then x=41
If x>565 Then x=565
If y>993 Then y=993
If x<130 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe9
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
      DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil7Maus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil7Maus2
Cls
HGrundH=Bild1
Goto Teil7Maus
End

.Teil7Maus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil7Maus
End


.Teil7Maus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil7Maus
End





.Aufgabe9
PauseChannel kamelpianoP
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
Print "Wenn du dann nochmals auf Enter drückst erscheint ein weiterer Witz."
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
 ;Einleseschlaufe für 30 Wörter
      Const MaxsW = 29
Dim Wort$(MaxsW)
ClsColor 1,1,1

            

.Woerter2W


Data 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30


For i = 0 To MaxsW
  ;
Read Wort$(i)
Next

HGrundH=LoadImage (".\Bilder\Hintergrund1.jpg")
Repeat
Repeat
; Zufallsschlaufe 
    SeedRnd MilliSecs() 
    Zufall$ = Wort$(Rand(0,MaxsW))
Until ZufallVer<>Zufall
ZufallVer=Zufall


DrawImage HGrundH, 0,0


If Zufall=1 Then Print "Die Familie macht einen Ausflug mit dem"
If Zufall=1 Then Print "Zug in die Berge. Auf dem Bahnhof in München"
If Zufall=1 Then Print "hat der Zug etwas länger Aufenthalt."
If Zufall=1 Then Print "Auf dem Bahnsteig geht ein Mann"
If Zufall=1 Then Print "mit einem Imbisswagen entlang und ruft laut:"
If Zufall=1 Then Print "Heisse Würstchen! Heisse Würstchen!"
If Zufall=1 Then Print "Da öffnet Paul das Fenster und ruft hinaus:"
If Zufall=1 Then Print "Könnten Sie nicht still sein? Uns"
If Zufall=1 Then Print "interessiert es nicht, wie Sie heissen."

If Zufall=2 Then Print "Ostfriesische Klassenfahrt: Ein ostfriesischer"
If Zufall=2 Then Print "Lehrer wartet mit seinen Schülern der 3. Klasse"
If Zufall=2 Then Print "auf dem Bahnsteig. Einen Zug nach dem anderen"
If Zufall=2 Then Print "lässt er passieren, ohne mit seiner Klasse"
If Zufall=2 Then Print "einzusteigen. Schliesslich platzt ihm der Kragen:"
If Zufall=2 Then Print "Den nächsten nehmen wir, Kinder. Auch wenn wieder"
If Zufall=2 Then Print "nur 1. und 2. Klasse draufsteht."

If Zufall=3 Then Print "Abschlussprüfung auf der Polizeiakademie."
If Zufall=3 Then Print "Die Anwärter werden einzeln der Prüfungskommission"
If Zufall=3 Then Print "vorgeführt. Den ersten fragt der Prüfer: Licht oder"
If Zufall=3 Then Print "Schall? Schall! Warum denn das,fragt der Vorsitzende?"
If Zufall=3 Then Print "Nun, wenn ich meinen Fernseher anmache, kommt auch "
If Zufall=3 Then Print "erst der Ton, und .... Durchgefallen! der Nächste"
If Zufall=3 Then Print "bitte. Was ist schneller, Licht oder Schall?"
If Zufall=3 Then Print "Licht! Und warum? Wenn ich mein Radio anmache"
If Zufall=3 Then Print "geht auch zuerst das Licht und ...Durchgefallen, "
If Zufall=3 Then Print "raus. Der Nächste, bitte. Was ist schneller Licht"
If Zufall=3 Then Print "oder Schall? Licht, ist doch klar! Aha.Und warum?"
If Zufall=3 Then Print "Nun, die Augen sind doch am Kopf viel weiter"
If Zufall=3 Then Print "vorn als die Ohren..."

If Zufall=4 Then Print "Der Lehrer: Lukas, warum kommst du schon "
If Zufall=4 Then Print "wieder zu spät? "
If Zufall=4 Then Print "Ich habe von einem Fussballspiel geträumt. "
If Zufall=4 Then Print "Das ist doch kein Grund, zu spät zukommen!"
If Zufall=4 Then Print "Doch! Es gab Verlängerung!"

If Zufall=5 Then Print "Hören Sie mal zu, sagt der Polizist zum Golfspieler,"
If Zufall=5 Then Print "ihr Ball ist auf die Strasse geflogen und hat"
If Zufall=5 Then Print "dort die Frontscheibe eines Feuerwehrwagens im"
If Zufall=5 Then Print "Einsatz zertrümmert, der deswegen gegen eine "
If Zufall=5 Then Print "Mauer geprallt ist. Das Haus, das gelöscht werden "
If Zufall=5 Then Print "sollte ist bis auf die Grundmauer niedergebrannt"
If Zufall=5 Then Print "Was haben Sie zu diesem Schlamassel zu sagen?"
If Zufall=5 Then Print "Golfer: Wo ist mein Golfball!"

If Zufall=6 Then Print "Mäxchen sitzt auf dem Brunnenrand und heult."
If Zufall=6 Then Print "Kommt ein Polizist dazu und fragt, was los sei."
If Zufall=6 Then Print "Meine Muter ist in den Brunnen gefallen, schluchst"
If Zufall=6 Then Print "Mäxchen. Der Polizist zieht sich sofort Uniform"
If Zufall=6 Then Print "und Schuhe aus und stürzt sich in den Brunnen."
If Zufall=6 Then Print "Nach einigen Minuten kommt er wieder heraus, hat"
If Zufall=6 Then Print "aber die Mutter nicht gefunden. Sagt das Mäxchen:"
If Zufall=6 Then Print "Na toll, dann kann ich ja die blöde Schraube"
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

If Zufall=8 Then Print "Schön, dass du gekommen bist, Tante Ottilie, sagte"
If Zufall=8 Then Print "Florian artig. Gestern erst hat Papa gesagt:"
If Zufall=8 Then Print "Tante Ottilie fehlt uns gerade noch!"

If Zufall=9 Then Print "Mama, darf ich ein bisschen mit Opa spielen?"
If Zufall=9 Then Print "Nein der Sarg bleibt heute zu."

If Zufall=10 Then Print "Polizist: Herzlichen Glückwunsch. Sie sind"
If Zufall=10 Then Print "der 100 000ste Autofahrer, der diese neue"
If Zufall=10 Then Print "Autobahn befährt, und Sie bekommen als Preis"
If Zufall=10 Then Print "20 000 Euro! Was möchten Sie mit diesem Geld"
If Zufall=10 Then Print "anfangen? Vater: Dann mach ich mir mal zuerst"
If Zufall=10 Then Print "den Führerschein. Mutter: Hören Sie nicht auf"
If Zufall=10 Then Print "ihn, er ist total betrunken. Der schwerhörige"
If Zufall=10 Then Print "Opa: Ich habe euch doch gleich gesagt, dass"
If Zufall=10 Then Print "es keine gute Idee war, das Auto zu stehlen."
If Zufall=10 Then Print "Eine Stimme aus dem Kofferraum: Sind wir "
If Zufall=10 Then Print "schon hinter der Grenze?"

If Zufall=11 Then Print "Fragt der Lehrer: Wer kann mir Tiere nennen,"
If Zufall=11 Then Print "die bei uns leben?"
If Zufall=11 Then Print "Mariechen streckt den Finger und zählt auf:"
If Zufall=11 Then Print "Eselchen,Pferdchen,Schäfchen..."
If Zufall=11 Then Print "Der Lehrer unterbricht: Lass doch bitte das"
If Zufall=11 Then Print ">chen< weg!"
If Zufall=11 Then Print "Mariechen fährt fort: Kanin,Eichhorn..."

If Zufall=12 Then Print "Fritzchen geht mit seiner Oma in die Stadt."
If Zufall=12 Then Print "Vor dem Supermarkt findet er eine Zehnfrankennote."
If Zufall=12 Then Print "Als er sie aufheben will, sagt die Oma: Was auf"
If Zufall=12 Then Print "dem Boden liegt, darf man nicht aufheben!"
If Zufall=12 Then Print "Sie gehen weiter. Fritzchen findet eine"
If Zufall=12 Then Print "Zwanzigfrankennote. Die Oma sagt wieder: Was auf"
If Zufall=12 Then Print "dem Boden liegt, darf man nicht aufheben!"
If Zufall=12 Then Print "Auf dem Rückweg fällt die Oma hin. Fritzchen,"
If Zufall=12 Then Print "hilf mir doch aufzustehen! Da sagt dieser: Was"
If Zufall=12 Then Print "auf dem Boden liegt, darf man nicht aufheben!"

If Zufall=13 Then Print "Ein Amerikaner machte eine Stadtrundfahrt durch"
If Zufall=13 Then Print "Paris und lässt sich die Attraktionen zeigen."
If Zufall=13 Then Print "Am Triumphbogen erzählt ihm der französische"
If Zufall=13 Then Print "Taxifahrer, dass dieser Bogen ein wahres Wunderwerk"
If Zufall=13 Then Print "sei, 20 000t schwer. Der Amerikaner fragt, wie lange"
If Zufall=13 Then Print "der Bau dieses Monuments gedauert habe. Als er"
If Zufall=13 Then Print "erfährt, dass es 15 Jahre gedauert hat, lachte er nur"
If Zufall=13 Then Print "und sagte: Ach in Amerika brauchen wir für so etwas"
If Zufall=13 Then Print "höchstens 15 Tage. Der Franzose ist schon etwas"
If Zufall=13 Then Print "eingeschnappt. Am Louvre angelangt, das gleiche"
If Zufall=13 Then Print "Spiel. Der Franzose nennt die Bauzeit von 20 Jahren."
If Zufall=13 Then Print "Daraufhin behauptet der Amerikaner: Ach, in"
If Zufall=13 Then Print "Amerika brauchen wir für sowas höchstens 20 Tage."
If Zufall=13 Then Print "Schliesslich kommen sie zum Eiffelturm. Donnerwetter,"
If Zufall=13 Then Print "staunt der Amerikaner, was ist denn das? Der"
If Zufall=13 Then Print "Franzose daraufhin:Keine Ahnung, stand gestern"
If Zufall=13 Then Print "noch nicht da!"

If Zufall=14 Then Print "Das Thema des Deutschaufsatzes lautet: Mein"
If Zufall=14 Then Print "Lieblingstier. Simone schreibt: Unser Hund ist"
If Zufall=14 Then Print "super. Er ist der beste Hund der Welt. Er sucht"
If Zufall=14 Then Print "Stöckchen, springt sehr hoch und bringt uns jeden"
If Zufall=14 Then Print "Morgen die Zeitung, obwohl wir gar keine"
If Zufall=14 Then Print "abonniert haben."

If Zufall=15 Then Print "Moritz sagt beim Abendessen zu seinem Vater:"
If Zufall=15 Then Print "Vater, ich muss dir was sagen! Der Vater:"
If Zufall=15 Then Print "Nein, jetzt nicht, Moritz. Man spricht nicht"
If Zufall=15 Then Print "mit vollem Mund. Aber es ist sehr wichtig, "
If Zufall=15 Then Print "Vater!, sagte Mortiz drängelnd. Das kannst"
If Zufall=15 Then Print "du mir auch später sagen!, antwortet der "
If Zufall=15 Then Print "Vater wütend. Nach dem Essen. So, Moritz,"
If Zufall=15 Then Print "was wolltest du mir sagen? Ach, jetzt ist"
If Zufall=15 Then Print "es zu spät, du hast den Wurm im Salat schon"
If Zufall=15 Then Print "gegessen."

If Zufall=16 Then Print "Ein Schäfer sitzt mit einem Schaf am Strassenrand."
If Zufall=16 Then Print "Da kommt ein Porsche vorbei, blieb stehen und"
If Zufall=16 Then Print "bietet dem Hirten an mitzufahren. Allerdings"
If Zufall=16 Then Print "nur ohne Schaf.Der Schäfer sagt dem Porschefahrer,"
If Zufall=16 Then Print "dass es kein Problem wäre, das Schaf einfach hinten"
If Zufall=16 Then Print "am Auto anzubinden.Als sie schon 100km/h fahren,"
If Zufall=16 Then Print "sieht der Porschefahrer überrascht, dass das Schaf"
If Zufall=16 Then Print "ganz locker hinter seinem Auto hertrabt.Also"
If Zufall=16 Then Print "beschliesst er, noch etwas schneller zu fahren."
If Zufall=16 Then Print "Bei 150 km/h ist das Schaf schon fast im Galopp."
If Zufall=16 Then Print "Als er weiter auf 200km/h beschleunigt, sieht er,"
If Zufall=16 Then Print "dass das Schaf auf einmal so seltsam mit dem linken"
If Zufall=16 Then Print "Ohr wackelt. Als er den Schäfer darauf aufmerksam"
If Zufall=16 Then Print "macht, sagt dieser nur: Keine Sorge, das macht's"
If Zufall=16 Then Print "immer wenn's überholen will!"

If Zufall=17 Then Print "Friederich und seine Freunde haben Murmeln gekauft."
If Zufall=17 Then Print "Sie kommen an einer Leichenhalle vorbei.Vor dem"
If Zufall=17 Then Print "Eingang verteilen sie zwei Murmeln, die hineinkullern."
If Zufall=17 Then Print "In der Halle zählten sie die Murmeln ab. Eine für"
If Zufall=17 Then Print "dich, eine für mich ... usw. Der Hausmeister kommt"
If Zufall=17 Then Print "vorbei, hört das und rennt zum Pfarrer: Herr"
If Zufall=17 Then Print "Pfarrer, in der Leichenhalle spielt der Teufel"
If Zufall=17 Then Print "mit Gott um die Seele der Verstorbenen! Also"
If Zufall=17 Then Print "geht der Pfarrer mit ihm zurück. Dort hören"
If Zufall=17 Then Print "sie eine Stimme: Das waren alle! Und die vor"
If Zufall=17 Then Print "der Tür holen wir uns auch noch!"

If Zufall=18 Then Print "Reisender zum Schaffner:"
If Zufall=18 Then Print "Wie lange hält der Zug?-"
If Zufall=18 Then Print "Bei guter Pflege 25 Jahre."

If Zufall=19 Then Print "Können Sie mir einen unbekanten,"
If Zufall=19 Then Print "schneesicheren Urlaubsort empfehlen?"
If Zufall=19 Then Print "Tut mir leid, die sind alle ausgebucht!"

If Zufall=20 Then Print "Ein Mann beim Verhör."
If Zufall=20 Then Print "Polizist: Sie haben doch gesehen, wie"
If Zufall=20 Then Print "die alte Dame von einem Kerl verprügelt"
If Zufall=20 Then Print "wurde. Wieso haben Sie dann nicht geholfen?"
If Zufall=20 Then Print "Mann: Ich dachte , der schafft das allein!"

If Zufall=21 Then Print "Ein Landwirt gewinnt 3000 Euro im Lotto und"
If Zufall=21 Then Print "bekommt sie in drei 1000 Euro Scheinen bar"
If Zufall=21 Then Print "bezahlt. Leider fällt ihm das Geld auf den"
If Zufall=21 Then Print "Boden und seine fette Sau frisst das Geld."
If Zufall=21 Then Print "Der Geldbote hatte einen Ratschlag parat:"
If Zufall=21 Then Print "Geben Sie der Sau ein Korn zu trinken und"
If Zufall=21 Then Print "treten Sie ihr in den Hintern, dann kotzt"
If Zufall=21 Then Print "sie das Geld wieder aus. Da der Bauer gerade"
If Zufall=21 Then Print "kein Korn zuhause hat,schleppt er die Sau in"
If Zufall=21 Then Print "die nächste Kneipe, bestellt ein Bier und ein"
If Zufall=21 Then Print "Korn. Er trinkt das Bier auf ex, gibt der Sau"
If Zufall=21 Then Print "den Korn,tritt ihr in den Hintern, und siehe da,"
If Zufall=21 Then Print "sie erbricht einen Tausender. Der Wirt ist "
If Zufall=21 Then Print "begeistern und fragt,ob er das Tier kaufen könne."
If Zufall=21 Then Print "Die Sau ist unverkäuflich, sagte der Bauer,"
If Zufall=21 Then Print "bestellt noch ein Korn, noch ein Bier, tritt"
If Zufall=21 Then Print "der Sau in den Hintern, und der zweite Tausender"
If Zufall=21 Then Print "kommt zum Vorschein.Der Wirt kann es kaum glauben,"
If Zufall=21 Then Print "und der Bauer wiederholte das Spiel zum dritten Mal."
If Zufall=21 Then Print "Darauf der Wirt: Ich gebe Ihnen 10'000 Euro in bar"
If Zufall=21 Then Print "für das Tier. Der Bauer überlegt nicht lange und"
If Zufall=21 Then Print "willigt zufrieden ein. Er lässt die Sau in der "
If Zufall=21 Then Print "Kneipe und geht mit seinen 10'000 Euro heim. Am"
If Zufall=21 Then Print "nächsten Tag liest der Bauer in der Zeitung die"
If Zufall=21 Then Print "Schlagzeilen: Ein betrunkener Gastwirt tritt"
If Zufall=21 Then Print "seine Sau tot!!!"

If Zufall=22 Then Print "In diesem Jahr werde ich im Urlaub nichts tun."
If Zufall=22 Then Print "Die erste Woche werde ich mich nur im Schaukelstuhl"
If Zufall=22 Then Print "entspannen. Ja aber dann?-Dann werde ich"
If Zufall=22 Then Print "eventuell ein wenig schaukeln."

If Zufall=23 Then Print "Ein Polizist steht in der Küche und versucht eine"
If Zufall=23 Then Print "Fischbüchse zu öffnen. Erst reisst er die Lasche ab,"
If Zufall=23 Then Print "dann zerbeult er mit dem Büchsenöffner die "
If Zufall=23 Then Print "Seitenwand. Dann verbeult er den Deckel.Schliesslich"
If Zufall=23 Then Print "nimmt der Polizist seinen Gummiknüppel, haut mehrfach"
If Zufall=23 Then Print "auf die Büchse und schreit: Aufmachen, Polizei!"

If Zufall=24 Then Print "Wegen zu geringer Bildung sollen Leute mit"
If Zufall=24 Then Print "Fremdsprachenkenntnis als Polizisten angeworben"
If Zufall=24 Then Print "werden. Es melden sich auch welche: Prüfer:"
If Zufall=24 Then Print "Do you speak English? 1.Bewerber: Äh? Durchgefallen."
If Zufall=24 Then Print "Prüfer: Do you speak English? 2.Bewerber:Äh?"
If Zufall=24 Then Print "Durchgefallen. Prüfer: Do you speak English?"
If Zufall=24 Then Print "3. Bewerber: Oh yes, I do. Prüfer: Äh?"

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


If Zufall=27 Then Print "Schon über eine halbe Stunde verfolgt der Polizist"
If Zufall=27 Then Print "den Dieb. Endlich kann der Dieb nicht mehr und "
If Zufall=27 Then Print "lässt sich auf eine Bank fallen. Schnaufend "
If Zufall=27 Then Print "stoppt der Polizist und setzt sich ebenfalls."
If Zufall=27 Then Print "Nach einer Weile schaut der Dieb zum Polizisten "
If Zufall=27 Then Print "hinüber: Na, packen wir es wieder?"

If Zufall=28 Then Print "Schimpft der Polizist mit dem Passanten:"
If Zufall=28 Then Print "Sie dürfen doch nicht bei Rot über die Strasse gehen."
If Zufall=28 Then Print "Sind Sie denn von Sinnen?"
If Zufall=28 Then Print "Nein, Herr Polizist, von Zürich!"

If Zufall=29 Then Print "Der Richter vorwurfsvoll zum Angeklagten:"
If Zufall=29 Then Print "Sie haben in dem Hotel Handtücher geklaut."
If Zufall=29 Then Print "Wissen Sie, was darauf steht?"
If Zufall=29 Then Print "Natürlich: ´Hotel zum Bären´"

If Zufall=30 Then Print "Der Polizist zum Autofahrer:"
If Zufall=30 Then Print "Was fällt Ihnen ein, in der Stadt"
If Zufall=30 Then Print "70 Kilometer in der Stunde zu fahren?"
If Zufall=30 Then Print "Unmöglich, ich bin ja erst zehn Minuten unterwegs!"

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
Goto Spielstandabfrage
End






.Teil8
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level8.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level8K1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level8K2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 310
y = 571
ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level8.jpg")


gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255


hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil8Maus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<41 Then x=41
If x>565 Then x=565
If y>993 Then y=993
If x<130 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe10
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
      DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil8Maus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil8Maus2
Cls
HGrundH=Bild1
Goto Teil8Maus
End

.Teil8Maus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil8Maus
End


.Teil8Maus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil8Maus
End




.Aufgabe10
PauseChannel kamelpianoP
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
Print "haben, sonst kommst du wieder zum Spiel oder zur Übersicht."
Print "Noch ein Tipp, wenn du keinen Curser mehr siehst dann erscheint"
Print "der Text entweder nur eine gewisse Zeit oder du kannst eine"
Print "beliebige Taste drücken wie es hier der Fall ist!"
WaitKey ()
Restore Woerter2W
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

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
Rect hotX2,hotY2,hotW2,hotH2,0

DrawImage HGrundH, 3,0
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

Cls
Locate 1,1
If ArtikelVRichtig=1 Then AR=1 PlayMusic (".\Sounds\Richtig.mp3") 
If ArtikelVRichtig=0 Then AR=0 PlayMusic (".\Sounds\Falsch.mp3")  Fa=Fa+1
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
Goto Spielstandabfrage
End






.Teil9
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level9.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level9K1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level9K2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 310
y = 761
ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level9.jpg")


gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255


hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil9Maus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<41 Then x=41
If x>565 Then x=565
If y>993 Then y=993
If x<130 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe11
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
      DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil9Maus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil9Maus2
Cls
HGrundH=Bild1
Goto Teil9Maus
End

.Teil9Maus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil9Maus
End


.Teil9Maus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil9Maus
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
If Punkte=1 Then Zufall = Rand (1,100)
If Punkte=2 Then Zufall = Rand (1,100)
If Punkte=3 Then Zufall = Rand (1,1000)
If Punkte=4 Then Zufall = Rand (1,10000)
Versuche = 0
If Punkte=1 Then Print "Ich denke mir eine Zahl zwischen 1 und 100 errate sie!"
If Punkte=1 Then Print "Das Ziel ist, die Zahl in 10 Versuchen herauszufinden."
If Punkte=2 Then Print "Ich denke mir eine Zahl zwischen 1 und 100 errate sie!"
If Punkte=2 Then Print "Das Ziel ist, die Zahl in 10 Versuchen herauszufinden."
If Punkte=3 Then Print "Ich denke mir eine Zahl zwischen 1 und 1000 errate sie!"
If Punkte=3 Then Print "Das Ziel ist, die Zahl in 15 Versuchen herauszufinden."
If Punkte=4 Then Print "Ich denke mir eine Zahl zwischen 1 und 10000 errate sie!"
If Punkte=4 Then Print "Das Ziel ist, die Zahl in 20 Versuchen herauszufinden."
Print "Wenn du die Zahl einfach nicht herausfindest oder einen Fehler im Programm ist"
Print "dann kommst du mit Enter wieder zum Spiel oder zur Übersicht."
Print "Wenn du 0 und Enter drückst kommst du auch zum Spiel."
Print "Viel Glück!"
Input()
Repeat
  Zahl = Input("Rate mal: ")
If Zahl=0 And UebersichtA=1 Then Goto Uebersicht3
If Zahl=0 Then Goto Teil9
  Versuche = Versuche + 1
  If Zahl < Zufall Then Print "Zu klein!"
  If Zahl > Zufall Then Print "Zu groß!"
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

If Versuche=288 Then Print "Die Zahl wäre "+Zufall+" gewesen."
If Versuche=288 Then Print "Du hast viel zu viel Versuche gebraucht."
If Versuche=288 And Punkte=1 Then Print "Das Ziel wäre es eigentlich"
If Versuche=288 And Punkte=1 Then Print "die Zahl in 10 Versuchen zu erraten."
If Versuche=288 And Punkte=2 Then Print "Das Ziel wäre es eigentlich"
If Versuche=288 And Punkte=2 Then Print "die Zahl in 10 Versuchen zu erraten."
If Versuche=288 And Punkte=3 Then Print "Das Ziel wäre es eigentlich"
If Versuche=288 And Punkte=3 Then Print "die Zahl in 15 Versuchen zu erraten."
If Versuche=288 And Punkte=4 Then Print "Das Ziel wäre es eigentlich"
If Versuche=288 And Punkte=4 Then Print "die Zahl in 20 Versuchen zu erraten."
If Versuche=288 Then Print "Versuche die Aufgabe später noch einmal."
If Versuche=288 Then Input()
If Versuche=288 And UebersichtA=1 Then Goto Uebersicht3
If Versuche=288 Then Goto Teil9
Until Zahl = Zufall
Cls
Locate 1,1
DrawImage HGrundH, 0,0
Print "Richtig!"
Print "Du hast " + Versuche + " Mal geraten."
If Versuche=10 Or Versuche<10 And Punkte=1 Then Print "Herzlichen Glückwunsch du hast das Ziel erreicht!"
If Versuche>10 And Punkte=1 Then Print "Du hast das Ziel nicht erreicht, versuche die Aufgabe später nochmals."
If Versuche>10 And Punkte=1 Then Input()
If Versuche>10 And Punkte=1 Then Versuche=0 Zahl=0 Goto Teil9
If Versuche=10 Or Versuche<10 And Punkte=2 Then Print "Herzlichen Glückwunsch du hast das Ziel erreicht!"
If Versuche>10 And Punkte=1 Then Print "Du hast das Ziel nicht erreicht, versuche die Aufgabe später nochmals."
If Versuche>10 And Punkte=1 Then Input()
If Versuche>10 And Punkte=1 Then Versuche=0 Zahl=0 Goto Teil9
If Versuche=15 Or Versuche<15 And Punkte=3 Then Print "Herzlichen Glückwunsch du hast das Ziel erreicht!"
If Versuche>15 And Punkte=1 Then Print "Du hast das Ziel nicht erreicht, versuche die Aufgabe später nochmals."
If Versuche>15 And Punkte=1 Then Input()
If Versuche>15 And Punkte=1 Then Versuche=0 Zahl=0 Goto Teil9
If Versuche=20 Or Versuche<20 And Punkte=4 Then Print "Herzlichen Glückwunsch du hast das Ziel erreicht!"
If Versuche>20 And Punkte=1 Then Print "Du hast das Ziel nicht erreicht, versuche die Aufgabe später nochmals."
If Versuche>20 And Punkte=1 Then Input()
If Versuche>20 And Punkte=1 Then Versuche=0 Zahl=0 Goto Teil9
Versuche=0
Zahl=0
Input()
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=11
Smeili=1
FlushKeys
FlushMouse
Goto Spielstandabfrage
End
Return













.Teil10
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level10.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level10K1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level10K2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 310
y = 951
ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level10.jpg")


gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255


hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil10Maus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<41 Then x=41
If y>993 Then y=993
If x>564 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe12
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
      DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil10Maus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil10Maus2
Cls
HGrundH=Bild1
Goto Teil10Maus
End

.Teil10Maus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil10Maus
End


.Teil10Maus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil10Maus
End



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

bat1=LoadImage("graphics/bat1.jpg")
bat2=CopyImage(bat1)
ball=LoadImage("graphics/ball.jpg")

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
Text width/2,height-62,"Das Ziel ist, 20 Punkte zu erreichen!",1
Text width/2,height-32,"Du darfst aber nicht mehr als 3 mal den Ball durchlassen sonst kommst du wieder zum Spiel!",1
If  FehlerD=4 And UebersichtA=1 Then Goto Uebersicht3
If  score=20 And UebersichtA=1 Then Goto Uebersicht3
If score=20 Then Delay 1000 Aufgaben=12 Smeili=1 Goto Spielstandabfrage
If FehlerD=4 Then Delay 1000 Goto Spielstandabfrage


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

.Teil11
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level11.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level11K1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level11K2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 1000
y = 760
ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level11.jpg")


gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255


hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil11Maus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<678 Then x=678
If x>1110 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe13
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
      DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil11Maus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil11Maus2
Cls
HGrundH=Bild1
Goto Teil11Maus
End

.Teil11Maus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil11Maus
End


.Teil11Maus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil11Maus
End



.Aufgabe13
PauseChannel kamelpianoP
Include ".\Nico 2010 Synonym.bb"
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=13
Smeili=1
FlushKeys
FlushMouse
Goto Spielstandabfrage
End











.Teil12
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level12.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level12K1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level12K2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 1000
y = 570
ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level12.jpg")


gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255


hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil12Maus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<678 Then x=678
If x>1110 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe14
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
      DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil12Maus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil12Maus2
Cls
HGrundH=Bild1
Goto Teil12Maus
End

.Teil12Maus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil12Maus
End


.Teil12Maus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil12Maus
End



.Aufgabe14
ClsVB
PauseChannel kamelpianoP
Game= LoadSound (".\Sounds\0001Geame.mp3")
LoopSound Game
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
Print "Schreibe bitte immner nur eine Zahl auf einer Linie (dann Enter + nächste Zahl).
FlushKeys
FlushMouse
WaitKey ()
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
Goto Spielstandabfrage
End

.Fehler3
Print "Schreibe bitte nie 2 gleiche Zahlen auf den Lottoschein !!!"
Delay 1000
Goto Lotoschein





.Teil13
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level13.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level13K1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level13K2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 1000
y = 380
ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level13.jpg")


gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255


hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil13Maus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<678 Then x=678
If x>1110 Then PlayMusic (".\Sounds\Tor.mp3") Goto Aufgabe15
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
      DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil13Maus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil13Maus2
Cls
HGrundH=Bild1
Goto Teil13Maus
End

.Teil13Maus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil13Maus
End


.Teil13Maus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil13Maus
End





.Aufgabe15
ClsVB
;enable double buffering
SetBuffer BackBuffer()

;load images for player, bullet and target
player=LoadImage("graphics\player.jpg")
bullet=LoadImage("graphics\bullet.jpg")
target=LoadImage("graphics\alien.jpg" )


;initialize player position
player_x=320
player_y=900

;initialize target position and direction of movement
target_x=0
target_y=20
target_direction=1

;initialize bullet position and 'fired' flag
bullet_x=0
bullet_y=0
bullet_fired=False

;initialize player score
score=0

;loop until ESC hit...
While Not KeyDown(1)

	;is left key being held?
	If KeyDown(203)
	
		;move player to the left
		player_x=player_x-3
		
		;stop the player going 'off screen'
		If player_x<0 Then player_x=0
		
	EndIf
	
	;is right key being held?
	If KeyDown(205)
	
		;move player to the right
		player_x=player_x+3
		
		;stop the player going 'off screen'
		If player_x>1280 Then player_x=1280
	
	EndIf
	
	;has the 'fire' key been hit?
	If KeyHit(57)
	
		;initialize bullet position
		bullet_x=player_x+9
		bullet_y=player_y-10
		
		;enable the bullet
		bullet_fired=True
	
	EndIf
	
	;update the target
	target_x=target_x+target_direction
	
	;If target hits the edge of the screen, make it bounce
	If target_x<0 Or target_x>1280
		
		;reverse the direction target is moving in
		target_direction=-target_direction
		
	EndIf
	
	;update the bullet, if it exists
	If bullet_fired
	
		;move the bullet up
		bullet_y=bullet_y-3
		
		;if the bullet is still onscreen, see if it hits the target
		If bullet_y>0
		
			;does the bullet overlap the target?
			If ImagesCollide( bullet,bullet_x,bullet_y,0,target,target_x,target_y,0 )
			
				;yes! the player shot the target! increase the score
				score=score+100
				PlayMusic (".\Sounds\boom.mp3")		;reset the target
				target_x=0
				target_direction=Abs(target_direction)
				
				;increase the speed of the target a little!
				target_direction=target_direction+1
				
				
				;and turn the bullet off
				bullet_fired=False
				
			EndIf
		
		Else
		
			;bullet has gone offscreen - reduce the score
			score=score-20
		
			;and disable the bullet
			bullet_fired=False
			
		EndIf
		
	EndIf
	
	;clear the screen
	Cls
	
	;draw the target
	DrawImage target,target_x,target_y
	
	;draw the bullet, if it exists
	If bullet_fired Then DrawImage bullet,bullet_x+20,bullet_y
	
	;draw the player
	DrawImage player,player_x,player_y
	
	;show the score
	Text 640,0,score,1
	
	;swap front and back buffers
	Flip
	If score=1000 Or score>1000 Then
	If UebersichtA=1 Then Goto Uebersicht3
	Aufgaben=15
Smeili=1
FlushKeys
FlushMouse
Goto Spielstandabfrage
EndIf
Wend






.Teil14
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level14.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level14K1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level14K2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 1000
y = 191
ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level14.jpg")


gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255


hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50

.Teil14Maus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<678 Then x=678
If x>1240 Then Goto Teil15
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
      DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil14Maus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil14Maus2
Cls
HGrundH=Bild1
Goto Teil14Maus
End

.Teil14Maus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil14Maus
End


.Teil14Maus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil14Maus
End




.Teil15
ClsVB
SteinK= LoadImage (".\Bilder\Steinkugel.jpg")
Bild1= LoadImage (".\Bilder\Nico 2010 Level15.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level15K1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level15K2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 0
y = 191
ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level15.jpg")


gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255

hotX=0
hotY=0
hotW=370
hotH=50

hotX1=370
hotY1=0
hotW1=230
hotH1=50
SteinKoY=100
SteinKoX=400
SteinAnz=0

.Teil15Maus

circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
If x<0 Then x=0
If x>1240 Then Goto Hoehlenausgang


SteinKoY=SteinKoY+1
If SteinKoY=1500 Then SteinKoY=1050


.SteinAn

DrawImage SteinK, SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK,SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS=1
  EndIf

SteinKoX=SteinKoX+50
SteinKoY=SteinKoY-50
DrawImage SteinK, SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK,SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS=1
  EndIf
SteinKoY=SteinKoY+50
SteinKoX=SteinKoX-50



SteinKoX=SteinKoX+100
SteinKoY=SteinKoY-100
DrawImage SteinK, SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK,SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS=1
  EndIf
SteinKoY=SteinKoY+100
SteinKoX=SteinKoX-100



SteinKoX=SteinKoX+150
SteinKoY=SteinKoY-150
DrawImage SteinK, SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK,SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS=1
  EndIf
SteinKoY=SteinKoY+150
SteinKoX=SteinKoX-150



SteinKoX=SteinKoX+200
SteinKoY=SteinKoY-200
DrawImage SteinK, SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK,SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS=1
  EndIf
SteinKoY=SteinKoY+200
SteinKoX=SteinKoX-200



SteinKoX=SteinKoX+250
SteinKoY=SteinKoY-250
DrawImage SteinK, SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK,SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS=1
  EndIf
SteinKoY=SteinKoY+250
SteinKoX=SteinKoX-250



SteinKoX=SteinKoX+350
SteinKoY=SteinKoY-250
DrawImage SteinK, SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK,SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS=1
  EndIf
SteinKoY=SteinKoY+250
SteinKoX=SteinKoX-350



SteinKoY=SteinKoY-225
SteinAnz=SteinAnz+1
If GetroffenS=1 Then Goto GetroffenS
If SteinAnz<15 Then Goto SteinAn
SteinKoY=SteinKoY+3375
SteinAnz=0

    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
    DrawImage gfxCircle,circleX,circleY
    DrawImage rocket, x, y
    
    Flip

If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil15Maus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil15Maus2
Cls
HGrundH=Bild1
Goto Teil15Maus
End

.Teil15Maus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil15Maus
End


.Teil15Maus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil15Maus
End



.GetroffenS
ClsVB
HGrundH= LoadImage (".\Bilder\Moss.jpg")
DrawImage HGrundH, 0,0
Schrift = LoadFont ("Arial",55,20100)
SetFont Schrift
Color 255,255,255
Print "Du wurdest leider von einem Stein getroffen!"
Print "Versuche es nochmals!"
Print ""
Print "Tipp:"
Print "Du musst in dem Felsregen eine ganz kleine
Print "Pause machen damit du nicht mit den Steinen
Print "in Berührung kommst."
Input()
GetroffenS=0
Goto Teil15
End



.Hoehlenausgang
ClsVB
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 430
y = 1024
ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Höhlenausgang.jpg")

Repeat
DrawImage HGrundH, 0,0
    y = y - 1
    Delay 5
    DrawImage rocket, x, y
    Flip
Until y=600
	Aufgaben=15
    Smeili=2
Goto Spielstandabfrage
End






.Teil16
PauseChannel kamelpianoP
If MX=0 Then
MX=LoadSound (".\Sounds\MusiX.mp3")
LoopSound MX
MXP=PlaySound(MX)
Else
ResumeChannel MXP
EndIf
ChannelVolume MXP,1
ClsVB
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
backdrop=LoadImage(".\Bilder\Nico 2010 Level16Regen.jpg")
DrawImage backdrop,1,1
Color 155,255,255
x = 0
y = 929
Repeat
RegenK=Rnd (1,1280)
RegenO=Rnd (1,1024)
Line RegenK+1,RegenO+5,RegenK,RegenO
RegenK=Rnd (1,1280)
RegenO=Rnd (1,1024)
Line RegenK+1,RegenO+5,RegenK,RegenO
RegenK=Rnd (1,1280)
RegenO=Rnd (1,1024)
Line RegenK+1,RegenO+5,RegenK,RegenO
RegenK=Rnd (1,1280)
RegenO=Rnd (1,1024)
Line RegenK+1,RegenO+5,RegenK,RegenO
RegenB=RegenB+1
If RegenB=300 Then
Print ""
Locate 1,1
Cls
x=x+4
DrawImage backdrop,1,1
RegenB=0
EndIf
DrawImage rocket, x, y
Until x=660
Goto Aufgabe16
End





.Aufgabe16
;Goto Teil17
If hfdujkhbgjgjuvkhuj16=0 Then
PauseChannel MXP
ClsVB
Schrift = LoadFont ("Arial",90,20100)
SetFont Schrift
Color 255,255,155
Print "Beschrieb"
Schrift = LoadFont ("Arial",50,20100)
SetFont Schrift
Print "Nach einem Klick auf Enter erscheinem viele
Print "hinabfallende Zahlen."
Print "Wenn deine Spielfigur eine der Zahlen
Print "berührt, dann wird sie bei der nächsten"
Print "Ziffer der Rechnung eingetragen."
Print "das Ziel ist, so eine Rechnumg mit dem korrekten"
Print "Resultat zu erstellen."
Print "Achtung! Du hast für eine Rechnung nur solange Zeit bis"
Print "deine Spielfigur am unteren Bildrand ankommt."
Print "Bitte beende dieses Spiel nicht bevor diese
Print "Aufgabe noch  nicht fertig ist, weil du sonst"
Print "einen Teil deines Spielstandes verlieren könntest!"
Print ""
Print "Viel Glück!"
hfdujkhbgjgjuvkhuj16=1
hfdujkhbgjgjuvkhuj161=1
Input()
EndIf



If Punkte=4 Then vhjkcjvhvviuhugu16=1 Punkte=3
If Punkte=2 Then vhjkcjvhvviuhugu161=1 Punkte=1
If RichtigA16=10 Then
If vhjkcjvhvviuhugu16=1 Then Punkte=4
If vhjkcjvhvviuhugu161=1 Then Punkte=2
SteinKoY=0
SteinKoX=0
SteinAnz=0
SteinK1=0
SteinK2=0
SteinK3=0
SteinK4=0
SteinK5=0
SteinK6=0
SteinK7=0
SteinK8=0
SteinK9=0
DVGHJFHMHJG=0
B1=0
B2=0
B3=0
B4=0
B5=0
B6=0
B7=0
B8=0
B9=0
GetroffenS1=0
GetroffenS2=0
GetroffenS3=0
GetroffenS4=0
GetroffenS5=0
GetroffenS6=0
GetroffenS7=0
HGrundH=0
A14Z=0
A14Z1=0
A14Z2=0
A14Z3=0
A14Z4=0
A14Z5=0
GetroffenS=0
GetroffenS1=0
GetroffenS2=0
GetroffenS3=0
GetroffenS4=0
GetroffenS5=0
GetroffenS6=0
Fehler16SS1=0
Fehler16SS2=0
Fehler16SS3=0
Fehler16SS4=0
Fehler16SS5=0
Fehler16SS6=0
DVGHJFHMHJG1=0
DVGHJFHMHJG2=0
DVGHJFHMHJG3=0
DVGHJFHMHJG4=0
DVGHJFHMHJG5=0
DVGHJFHMHJG6=0
DVGHJFHMHJG7=0
kgbvhknvgknjmkmh=0
hnjugbjbhujmbg16=0
NulP16=0
hfdujkhbgjgjuvkhuj16=0
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=16
Smeili=0
Goto Spielstandabfrage
EndIf




SteinKoY=100
SteinKoX=400
SteinAnz=0
SteinK1=0
SteinK2=0
SteinK3=0
SteinK4=0
SteinK5=0
SteinK6=0
SteinK7=0
SteinK8=0
SteinK9=0
DVGHJFHMHJG=0
B1=0
B2=0
B3=0
B4=0
B5=0
B6=0
B7=0
B8=0
B9=0
GetroffenS1=0
GetroffenS2=0
GetroffenS3=0
GetroffenS4=0
GetroffenS5=0
GetroffenS6=0
GetroffenS7=0
HGrundH=0
A14Z=0
A14Z1=0
A14Z2=0
A14Z3=0
A14Z4=0
A14Z5=0
GetroffenS=0
GetroffenS1=0
GetroffenS2=0
GetroffenS3=0
GetroffenS4=0
GetroffenS5=0
GetroffenS6=0
Fehler16SS1=0
Fehler16SS2=0
Fehler16SS3=0
Fehler16SS4=0
Fehler16SS5=0
Fehler16SS6=0
DVGHJFHMHJG1=0
DVGHJFHMHJG2=0
DVGHJFHMHJG3=0
DVGHJFHMHJG4=0
DVGHJFHMHJG5=0
DVGHJFHMHJG6=0
DVGHJFHMHJG7=0
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
SteinK1=B1
SteinK2=B1
SteinK3=B1
SteinK4=B1
SteinK5=B1
SteinK6=B1
SteinK7=B1
SteinK8=B1
SteinK9=B1




.Aufgabe16A
hnjugbjbhujmbg16=hnjugbjbhujmbg16-1
If hnjugbjbhujmbg16=0 Then hnjugbjbhujmbg16=9 NulP16=NulP16+1
If NulP16=800 Then
Cls
Locate 1,1
Print "Zu langsam"
Delay 2000
FalschA16=FalschA16+1
Goto Aufgabe16
EndIf
Origin 0,NulP16

Include ".\HilfsdateinAufgabe16.bb"

GetroffenS=0
GetroffenS1=0
GetroffenS2=0
GetroffenS3=0
GetroffenS4=0
GetroffenS5=0
GetroffenS6=0

DrawImage HGrundH, 0,0
If Punkte=1 Then Text 100,1,A14Z*10+A14Z1+"+"+A14Z2+"="+A14Z3+A14Z4+A14Z5
If Punkte=2 Then Text 100,1,A14Z*10+A14Z1+"+"+A14Z2+"="+A14Z3+A14Z4+A14Z5
If Punkte=3 Then Text 100,1,A14Z+"*"+A14Z1+"="+A14Z2+A14Z3


If A14Z>0 And Punkte=1 Or Punkte=2 And A14Z*10+A14Z1+A14Z2=A14Z3*100+A14Z4*10+A14Z5 Then
Cls
Locate 1,1
Print "Richtig"
Delay 2000
RichtigA16=RichtigA16+1
Goto Aufgabe16
ElseIf A14Z>0 And Punkte=1 Or Punkte=2 And A14Z*10+A14Z1+A14Z2=A14Z3*10+A14Z4+A14Z5 Then
Cls
Locate 1,1
Print "Richtig"
Delay 2000
RichtigA16=RichtigA16+1
Goto Aufgabe16
ElseIf A14Z>0 And Punkte=1 Or Punkte=2 And A14Z*10+A14Z1+A14Z2=A14Z3+A14Z4+A14Z5 Then
Cls
Locate 1,1
Print "Richtig"
Delay 2000
RichtigA16=RichtigA16+1
Goto Aufgabe16
ElseIf A14Z2=1 Or A14Z2>1 And Punkte=3 And A14Z*A14Z1=A14Z2*10+A14Z3 Then
Cls
Locate 1,1
Print "Richtig"
Delay 2000
RichtigA16=RichtigA16+1
Goto Aufgabe16
ElseIf A14Z2=1 Or A14Z2>1 And Punkte=3 And A14Z*A14Z1=A14Z2+A14Z3 Then
Cls
Locate 1,1
Print "Richtig"
Delay 2000
RichtigA16=RichtigA16+1
Goto Aufgabe16
ElseIf A14Z>0 And A14Z1>0 And A14Z2>0 And A14Z3>0 And A14Z4>0 And A14Z5>0 Then
Cls
Locate 1,1
Print "Falsch"
Delay 2000
FalschA16=FalschA16+1
Goto Aufgabe16
ElseIf Punkte=3 And A14Z>0 And A14Z1>0 And A14Z2>0 And A14Z3>0 Then
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

GetroffenS1=0
GetroffenS2=0
GetroffenS3=0
GetroffenS4=0
GetroffenS5=0
GetroffenS6=0
GetroffenS7=0
SZGVGVGH=0


kgbvhknvgknjmkmh=kgbvhknvgknjmkmh-1
If kgbvhknvgknjmkmh=0 Then
SeedRnd MilliSecs()
BildZ= Rand(1,9)
If BildZ=1 Then SteinK1=B1 DVGHJFHMHJG1=1
If BildZ=2 Then SteinK1=B2 DVGHJFHMHJG1=2
If BildZ=3 Then SteinK1=B3 DVGHJFHMHJG1=3
If BildZ=4 Then SteinK1=B4 DVGHJFHMHJG1=4
If BildZ=5 Then SteinK1=B5 DVGHJFHMHJG1=5
If BildZ=6 Then SteinK1=B6 DVGHJFHMHJG1=6
If BildZ=7 Then SteinK1=B7 DVGHJFHMHJG1=7
If BildZ=8 Then SteinK1=B8 DVGHJFHMHJG1=8
If BildZ=9 Then SteinK1=B9 DVGHJFHMHJG1=9
Delay Rand (1,9)
SeedRnd MilliSecs()
BildZ= Rand(1,9)
If BildZ=1 Then SteinK2=B1 DVGHJFHMHJG2=1
If BildZ=2 Then SteinK2=B2 DVGHJFHMHJG2=2
If BildZ=3 Then SteinK2=B3 DVGHJFHMHJG2=3
If BildZ=4 Then SteinK2=B4 DVGHJFHMHJG2=4
If BildZ=5 Then SteinK2=B5 DVGHJFHMHJG2=5
If BildZ=6 Then SteinK2=B6 DVGHJFHMHJG2=6
If BildZ=7 Then SteinK2=B7 DVGHJFHMHJG2=7
If BildZ=8 Then SteinK2=B8 DVGHJFHMHJG2=8
If BildZ=9 Then SteinK2=B9 DVGHJFHMHJG2=9
Delay Rand (1,9)
SeedRnd MilliSecs()
BildZ= Rand(1,9)
If BildZ=1 Then SteinK3=B1 DVGHJFHMHJG3=1
If BildZ=2 Then SteinK3=B2 DVGHJFHMHJG3=2
If BildZ=3 Then SteinK3=B3 DVGHJFHMHJG3=3
If BildZ=4 Then SteinK3=B4 DVGHJFHMHJG3=4
If BildZ=5 Then SteinK3=B5 DVGHJFHMHJG3=5
If BildZ=6 Then SteinK3=B6 DVGHJFHMHJG3=6
If BildZ=7 Then SteinK3=B7 DVGHJFHMHJG3=7
If BildZ=8 Then SteinK3=B8 DVGHJFHMHJG3=8
If BildZ=9 Then SteinK3=B9 DVGHJFHMHJG3=9
Delay Rand (1,9)
SeedRnd MilliSecs()
BildZ= Rand(1,9)
If BildZ=1 Then SteinK4=B1 DVGHJFHMHJG4=1
If BildZ=2 Then SteinK4=B2 DVGHJFHMHJG4=2
If BildZ=3 Then SteinK4=B3 DVGHJFHMHJG4=3
If BildZ=4 Then SteinK4=B4 DVGHJFHMHJG4=4
If BildZ=5 Then SteinK4=B5 DVGHJFHMHJG4=5
If BildZ=6 Then SteinK4=B6 DVGHJFHMHJG4=6
If BildZ=7 Then SteinK4=B7 DVGHJFHMHJG4=7
If BildZ=8 Then SteinK4=B8 DVGHJFHMHJG4=8
If BildZ=9 Then SteinK4=B9 DVGHJFHMHJG4=9
Delay Rand (1,9)
SeedRnd MilliSecs()
BildZ= Rand(1,9)
If BildZ=1 Then SteinK5=B1 DVGHJFHMHJG5=1
If BildZ=2 Then SteinK5=B2 DVGHJFHMHJG5=2
If BildZ=3 Then SteinK5=B3 DVGHJFHMHJG5=3
If BildZ=4 Then SteinK5=B4 DVGHJFHMHJG5=4
If BildZ=5 Then SteinK5=B5 DVGHJFHMHJG5=5
If BildZ=6 Then SteinK5=B6 DVGHJFHMHJG5=6
If BildZ=7 Then SteinK5=B7 DVGHJFHMHJG5=7
If BildZ=8 Then SteinK5=B8 DVGHJFHMHJG5=8
If BildZ=9 Then SteinK5=B9 DVGHJFHMHJG5=9
Delay Rand (1,9)
SeedRnd MilliSecs()
BildZ= Rand(1,9)
If BildZ=1 Then SteinK6=B1 DVGHJFHMHJG6=1
If BildZ=2 Then SteinK6=B2 DVGHJFHMHJG6=2
If BildZ=3 Then SteinK6=B3 DVGHJFHMHJG6=3
If BildZ=4 Then SteinK6=B4 DVGHJFHMHJG6=4
If BildZ=5 Then SteinK6=B5 DVGHJFHMHJG6=5
If BildZ=6 Then SteinK6=B6 DVGHJFHMHJG6=6
If BildZ=7 Then SteinK6=B7 DVGHJFHMHJG6=7
If BildZ=8 Then SteinK6=B8 DVGHJFHMHJG6=8
If BildZ=9 Then SteinK6=B9 DVGHJFHMHJG6=9
Delay Rand (1,9)
SeedRnd MilliSecs()
BildZ= Rand(1,9)
If BildZ=1 Then SteinK7=B1 DVGHJFHMHJG7=1
If BildZ=2 Then SteinK7=B2 DVGHJFHMHJG7=2
If BildZ=3 Then SteinK7=B3 DVGHJFHMHJG7=3
If BildZ=4 Then SteinK7=B4 DVGHJFHMHJG7=4
If BildZ=5 Then SteinK7=B5 DVGHJFHMHJG7=5
If BildZ=6 Then SteinK7=B6 DVGHJFHMHJG7=6
If BildZ=7 Then SteinK7=B7 DVGHJFHMHJG7=7
If BildZ=8 Then SteinK7=B8 DVGHJFHMHJG7=8
If BildZ=9 Then SteinK7=B9 DVGHJFHMHJG7=9
kgbvhknvgknjmkmh=1000
EndIf

;DVGHJFHMHJG2=1
;DVGHJFHMHJG3=1
;DVGHJFHMHJG4=1
;DVGHJFHMHJG5=1
;DVGHJFHMHJG6=1
;DVGHJFHMHJG7=1

.A16SteinAn
PSEE161#=PSEE161#+0.005
;hgukjujkhghz=hgukjujkhghz+1
;If hgukjujkhghz=
DrawImage SteinK1, SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK1,SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS=1 x=0
  EndIf
SteinKoX=SteinKoX+50
SteinKoY=SteinKoY+PSEE161#
DrawImage SteinK2, SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK2,SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS1=1 x=0
  EndIf
SteinKoY=SteinKoY-PSEE161#
SteinKoX=SteinKoX-50



SteinKoX=SteinKoX+100
SteinKoY=SteinKoY-PSEE161#
DrawImage SteinK3, SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK3,SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS2=1 x=0
  EndIf
SteinKoY=SteinKoY+PSEE161#
SteinKoX=SteinKoX-100



SteinKoX=SteinKoX+150
SteinKoY=SteinKoY-150
DrawImage SteinK4, SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK4,SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS3=1 x=0
  EndIf
SteinKoY=SteinKoY+150
SteinKoX=SteinKoX-150



SteinKoX=SteinKoX+200
SteinKoY=SteinKoY-200
DrawImage SteinK5, SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK5,SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS4=1 x=0
  EndIf
SteinKoY=SteinKoY+200
SteinKoX=SteinKoX-200



SteinKoX=SteinKoX+250
SteinKoY=SteinKoY-250
DrawImage SteinK6, SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK6,SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS5=1 x=0
  EndIf
SteinKoY=SteinKoY+250
SteinKoX=SteinKoX-250



SteinKoX=SteinKoX+350
SteinKoY=SteinKoY-250
DrawImage SteinK7, SteinKoX,SteinKoY
ICrocket=ImagesCollide (rocket, x,y,0, SteinK7,SteinKoX,SteinKoY,0)
 If ICrocket Then
GetroffenS6=1 x=0
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





.Teil17
PauseChannel kamelpianoP
If MX=0 Then
MX=LoadSound (".\Sounds\MusiX.mp3")
LoopSound MX
MXP=PlaySound(MX)
Else
ResumeChannel MXP
EndIf
ChannelVolume MXP,1
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level17.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level17K1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level17K2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 660
y = 929
ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level17.jpg")


gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255


hotX=339
hotY=0
hotW=370
hotH=50

hotX1=711
hotY1=0
hotW1=230
hotH1=50

.Teil17Maus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<=0 Then x=0
If x>1240 Then Goto Teil18
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
      DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil17Maus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil17Maus2
Cls
HGrundH=Bild1
Goto Teil17Maus
End

.Teil17Maus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil17Maus
End


.Teil17Maus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil17Maus
End







.Teil18
ClsVB
Schrift = LoadFont ("Arial",40,20100)
SetFont Schrift
Color 1,1,1
ClsColor 1,255,1
Cls
Print "Ab jetzt kannst du nur noch nach einer Aufgabe zum Hauptmenü zurückkehren."
Input()
Cls
Locate 1,1
Bild1=LoadImage (".\Bilder\Hintergrund Knopf.jpg")
Bild2=LoadImage (".\Bilder\Hintergrund Knopf K1.jpg")
Bild3=LoadImage (".\Bilder\Hintergrund Knopf K2.jpg")
Schrift = LoadFont ("Arial",45,20100)
SetFont Schrift
Color 1,1,1
gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255
HGrundH=LoadImage (".\Bilder\Hintergrund Knopf.jpg")

hotX= 380
hotY=450
hotW=520
hotH=50

hotX1= 380
hotY1=500
hotW1=520
hotH1=50


.KNOPFA
circleX=MouseX()
circleY=MouseY()
Cls
Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto KNOPFA1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto KNOPFA2
HGrundH=Bild1
Delay 50
Goto KNOPFA
.KNOPFA1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Delay 50
Goto KNOPFA
.KNOPFA2
HGrundH=Bild3
If MouseDown(1) Then Goto KNOPFAE
Delay 50
Goto KNOPFA
End

.KNOPFAE
E=0
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 700
y = 1000
ClsColor 1,1,1
Cls
HGrundH= LoadImage (".\Bilder\Höle1.jpg")


Repeat
If y>1000 Then y=1000
    DrawImage HGrundH, 1,1
    If KeyDown (208) = 1 Then y = y + 2
    If KeyDown (200) = 1 Then y = y - 2
      DrawImage rocket, x, y
    Flip
Cls
Until y=420
Goto Aufgabe17
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
If (JetztZeit-StartZeit > ZeitMaxSR) Then Print "Zu Spät!"
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
If (JetztZeit-StartZeit > ZeitMaxSR) Then Print "Zu Spät!"
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
If (JetztZeit-StartZeit > ZeitMaxSR) Then Print "Zu Spät!"
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
If (JetztZeit-StartZeit > ZeitMaxSR) Then Print "Zu Spät!"
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
Goto Spielstandabfrage
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




.Teil19
PauseChannel kamelpianoP
If MX=0 Then
MX=LoadSound (".\Sounds\MusiX.mp3")
LoopSound MX
MXP=PlaySound(MX)
Else
ResumeChannel MXP
EndIf
ChannelVolume MXP,1
ClsVB
Bild1=LoadImage (".\Bilder\Hintergrund Knopf.jpg")
Bild2=LoadImage (".\Bilder\Hintergrund Knopf K1.jpg")
Bild3=LoadImage (".\Bilder\Hintergrund Knopf K2.jpg")
Schrift = LoadFont ("Arial",45,20100)
SetFont Schrift
Color 1,1,1
gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255
HGrundH=LoadImage (".\Bilder\Hintergrund Knopf.jpg")

hotX= 380
hotY=450
hotW=520
hotH=50

hotX1= 380
hotY1=500
hotW1=520
hotH1=50


.KNOPFASR
circleX=MouseX()
circleY=MouseY()
Cls
Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto KNOPFA1SR
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto KNOPFA2SR
HGrundH=Bild1
Delay 50
Goto KNOPFASR
.KNOPFA1SR
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Delay 50
Goto KNOPFASR
.KNOPFA2SR
HGrundH=Bild3
If MouseDown(1) Then Goto KNOPFAESR
Delay 50
Goto KNOPFASR
End

.KNOPFAESR
E=0
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 700
y = 1000
ClsColor 1,1,1
Cls
HGrundH= LoadImage (".\Bilder\Höle2.jpg")


Repeat
If x<=0 Then x=0
    DrawImage HGrundH, 1,1
    y=y-1
    Delay 2
    DrawImage rocket, x,y
    Flip
Cls
Until y=850
Repeat
If x<=0 Then x=0
    DrawImage HGrundH, 1,1
    y=y-1
    x=x-2
    Delay 2
    DrawImage rocket, x, y
    Flip
Cls
Until x=300
HGrundH= LoadImage (".\Bilder\Höle3.jpg")
x = 750
y = 1000
Repeat
If x<=0 Then x=0
    DrawImage HGrundH, 1,1
    y=y-2
    x=x-1
    Delay 2
    DrawImage rocket, x, y
    Flip
Cls
Until y=500
HGrundH= LoadImage (".\Bilder\Höle4.jpg")
x = 570
y = 1000
Repeat
If y>1000 Then y=1000
    DrawImage HGrundH, 1,1
    If KeyDown (208) = 1 Then y = y + 2
    If KeyDown (200) = 1 Then y = y - 2
      DrawImage rocket, x, y
    Flip
Cls
Until y=520
Goto Aufgabe18
End



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
If Adjektiv =4  Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Adjektiv1 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Adjektiv2 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Adjektiv =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Adjektiv1 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Adjektiv2 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
Until Ratwort1$ = "am vergnügtesten"
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
If Adjektiv =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Adjektiv1 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Adjektiv2 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
Print"Schreibe das Adjektiv und drücke Enter"
Print
Print "Ich esse gerne süsse Schokolade."
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "süss" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Adjektiv = Adjektiv +1
EndIf
If Adjektiv =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Adjektiv1 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Adjektiv2 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
Until Ratwort1$ = "am süssesten"
Print
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=18
Smeili=0
Goto Spielstandabfrage
End




.Teil20
FreeSound MXP
FreeSound MX
ResumeChannel kamelpianoP
ClsVB
Cls
Locate 1,1
Bild1=LoadImage (".\Bilder\Hintergrund Knopf.jpg")
Bild2=LoadImage (".\Bilder\Hintergrund Knopf K1.jpg")
Bild3=LoadImage (".\Bilder\Hintergrund Knopf K2.jpg")
Schrift = LoadFont ("Arial",45,20100)
SetFont Schrift
Color 1,1,1
gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255
HGrundH=LoadImage (".\Bilder\Hintergrund Knopf.jpg")

hotX= 380
hotY=450
hotW=520
hotH=50

hotX1= 380
hotY1=500
hotW1=520
hotH1=50


.KNOPFAAD
circleX=MouseX()
circleY=MouseY()
Cls
Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto KNOPFA1AD
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto KNOPFA2AD
HGrundH=Bild1
Delay 50
Goto KNOPFAAD
.KNOPFA1AD
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Delay 50
Goto KNOPFAAD
.KNOPFA2AD
HGrundH=Bild3
If MouseDown(1) Then Goto KNOPFAEAD
Delay 50
Goto KNOPFAAD
End

.KNOPFAEAD
E=0
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 510
y = 1000
ClsColor 1,1,1
Cls
HGrundH= LoadImage (".\Bilder\Höle5.jpg")


Repeat
If x<=0 Then x=0
    DrawImage HGrundH, 1,1
    y=y-1
    Delay 2
    DrawImage rocket, x,y
    Flip
Cls
Until y=580
HGrundH= LoadImage (".\Bilder\Höle6.jpg")
x = 550
y = 1000
Repeat
If x<=0 Then x=0
    DrawImage HGrundH, 1,1
    y=y-3
    x=x+1
    Delay 35
    DrawImage rocket, x, y
    Flip
Cls
Until y=502
HGrundH= LoadImage (".\Bilder\Höle7.jpg")
x = 600
y = 1000
Repeat
If y>1000 Then y=1000
    DrawImage HGrundH, 1,1
    y=y-1
    Delay 2
    DrawImage rocket, x, y
    Flip
Cls
Until y=630
Repeat
If y>1000 Then y=1000
    DrawImage HGrundH, 1,1
    x=x-1
    Delay 2
    DrawImage rocket, x, y
    Flip
Cls
Until x=300
HGrundH= LoadImage (".\Bilder\Höle8.jpg")
x = 600
y = 1000
Repeat
If y>1000 Then y=1000
    DrawImage HGrundH, 1,1
    x=x+1
    y=y-4
    Delay 50
    DrawImage rocket, x, y
    Flip
Cls
Until y=472
HGrundH= LoadImage (".\Bilder\Höle9.jpg")
x = 500
y = 1000
Repeat
If y>1000 Then y=1000
    DrawImage HGrundH, 1,1
    x=x+1
    y=y-4
    Delay 50
    DrawImage rocket, x, y
    Flip
Cls
Until y=612
Goto Aufgabe19
End



.Aufgabe19
PauseChannel kamelpianoP
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
Print"Schreibe das Pronomen und drücke Enter"
Print
Print "Mein Farrad fährt nicht mehr so gut."
Repeat
Ratwort1$ = Input()
If Ratwort1$ = "mein" Then
  Print "Richtig!" 
Else
  Print "War wohl nix, bitte nochmal versuchen!"
PlayMusic (".\Sounds\Door1.mp3")
Pronomen = Pronomen +1
EndIf
If Pronomen =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Pronomen1 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Pronomen =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Pronomen1 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Pronomen =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Pronomen1 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Pronomen =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
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
If Pronomen1 =4 Then Print "Du hast zuviele Fehler versuche die Aufgabe später nochmals!" Delay 2000 If UebersichtA=1 Then Goto Uebersicht3 Else Goto Spielstandabfrage
Until Ratwort1$ = "die"
Print
If UebersichtA=1 Then Goto Uebersicht3
Aufgaben=19
Smeili=0
Goto Spielstandabfrage
End




.Teil21
FreeSound MXP
FreeSound MX
ResumeChannel kamelpianoP
ClsVB
Cls
Locate 1,1
Bild1=LoadImage (".\Bilder\Hintergrund Knopf.jpg")
Bild2=LoadImage (".\Bilder\Hintergrund Knopf K1.jpg")
Bild3=LoadImage (".\Bilder\Hintergrund Knopf K2.jpg")
Schrift = LoadFont ("Arial",45,20100)
SetFont Schrift
Color 1,1,1
gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255
HGrundH=LoadImage (".\Bilder\Hintergrund Knopf.jpg")

hotX= 380
hotY=450
hotW=520
hotH=50

hotX1= 380
hotY1=500
hotW1=520
hotH1=50


.KNOPFAPR
circleX=MouseX()
circleY=MouseY()
Cls
Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto KNOPFA1PR
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto KNOPFA2PR
HGrundH=Bild1
Delay 50
Goto KNOPFAPR
.KNOPFA1PR
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Delay 50
Goto KNOPFAPR
.KNOPFA2PR
HGrundH=Bild3
If MouseDown(1) Then Goto KNOPFAEPR
Delay 50
Goto KNOPFAPR
End

.KNOPFAEPR
E=0
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 680
y = 1000
ClsColor 1,1,1
Cls
HGrundH= LoadImage (".\Bilder\Höle10.jpg")


Repeat
If x<=0 Then x=0
    DrawImage HGrundH, 1,1
    x=x+1
    y=y-3
    Delay 40
    DrawImage rocket, x,y
    Flip
Cls
Until y=520
ClsVB
HGrundH= LoadImage (".\Bilder\Höle11.jpg")
DrawImage HGrundH, 1,1
Delay 3000
Goto Teil22
End



.Teil22
PauseChannel kamelpianoP
If MX=0 Then
MX=LoadSound (".\Sounds\MusiX.mp3")
LoopSound MX
MXP=PlaySound(MX)
Else
ResumeChannel MXP
EndIf
ChannelVolume MXP,1
ClsVB
Bild1= LoadImage (".\Bilder\Nico 2010 Level17.jpg")
Bild2=LoadImage (".\Bilder\Nico 2010 Level17K1.jpg")
Bild3=LoadImage (".\Bilder\Nico 2010 Level17K2.jpg")
SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 1240
y = 103
ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Nico 2010 Level17.jpg")


gfxCircle=CreateImage(50,50)
SetBuffer ImageBuffer(gfxCircle)
Color 255,0,0
Oval 10,10,30,30,1
SetBuffer BackBuffer()
Color 0,0,255


hotX=339
hotY=0
hotW=370
hotH=50

hotX1=711
hotY1=0
hotW1=230
hotH1=50

.Teil22Maus
circleX=MouseX()
circleY=MouseY()

Rect hotX,hotY,hotW,hotH,0
Rect hotX1,hotY1,hotW1,hotH1,0
DrawImage HGrundH, 0,0
DrawImage gfxCircle,circleX,circleY
If x<=0 Then x=0
If x>=1250 Then x=1250
If x<=1200 Then Goto LAufgabe
    If KeyDown (205) = 1 Then x = x + 2
    If KeyDown (203) = 1 Then x = x - 2
      DrawImage rocket, x, y
    Flip
If ImageRectOverlap (gfxCircle,circleX,circleY,hotX,hotY,hotW,hotH) Goto Teil22Maus1
If  ImageRectOverlap (gfxCircle,circleX,circleY,hotX1,hotY1,hotW1,hotH1) Goto Teil22Maus2
Cls
HGrundH=Bild1
Goto Teil22Maus
End

.Teil22Maus1
HGrundH=Bild2
If MouseDown(1) Then Goto Auswahl
Cls
Goto Teil22Maus
End


.Teil22Maus2
HGrundH=Bild3
If MouseDown(1) Then Goto Karte
Cls
Goto Teil22Maus
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
Print "Viel Glück!"
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
PauseChannel kamelpianoP
If MX=0 Then
MX=LoadSound (".\Sounds\MusiX.mp3")
LoopSound MX
MXP=PlaySound(MX)
Else
ResumeChannel MXP
EndIf
ChannelVolume MXP,1
ClsVB
Bild=LoadImage (".\Bilder\Brücke.jpg")
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
Text 1,AAAER,"Bilder Höhle von Nico und Daniel Bosshard in Elba aufgenommen"
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
Goto Spielstandabfrage
End




.Vorfilm
FreeSound kamelpiano
FreeSound kamelpianoP
kamelpiano=LoadSound (".\Sounds\kamelpiano.mp3")
LoopSound kamelpiano
SoundPitch kamelpiano,25000
kamelpianoP=PlaySound(kamelpiano)
ClsVB
Bild= LoadImage (".\Bilder\Brücke.jpg")
Bild1=LoadImage (".\Bilder\Vorfilm1.jpg")
Bild2= LoadImage (".\Bilder\Monster1.jpg")

SetBuffer BackBuffer ()
rocket = LoadImage (".\Bilder\"+Name$+".jpg")
MaskImage rocket, 255, 0, 255
x = 0
y = 103
ClsColor 1,1,1
HGrundH= LoadImage (".\Bilder\Vorfilm1.jpg")

MOX1=1280
BEX=250
Repeat
DrawImage HGrundH, 0,0
DrawImage Bild, BEX,132
      MOX1=MOX1-1
      DrawImage Bild2, MOX1,98
    Delay 2
    Flip
Cls
Until MOX1=182
Repeat
If BEX<1280 Then BEX=BEX+1
DrawImage HGrundH, 0,0
DrawImage Bild, BEX,132
DrawImage Bild2, MOX1,98
    Flip
Cls
Until BEX=1280
Repeat
If BEX>1280 Then BEX=BEX+1
DrawImage HGrundH, 0,0
DrawImage Bild, BEX,132
    Flip
Cls
Until BEX=1280
Repeat
x=x+1
DrawImage HGrundH, 0,0
DrawImage Bild2, MOX1,98
DrawImage rocket, x,y
Delay 2
    Flip
Cls
Until x=130
MOY1=98
Repeat
x=x+1
MOY1=MOY1-1
DrawImage HGrundH, 0,0
DrawImage Bild2, MOX1,MOY1
DrawImage rocket, x,y
Delay 2
    Flip
Cls
Until x=158
Repeat
x=x+1
DrawImage HGrundH, 0,0
DrawImage Bild2, MOX1,MOY1
DrawImage rocket, x,y
Delay 2
    Flip
Cls
Until x=190
Repeat
x=x+1
MOX1=MOX1+1
DrawImage HGrundH, 0,0
DrawImage Bild2, MOX1,MOY1
DrawImage rocket, x,y
Delay 2
    Flip
Cls
Until x=610
Repeat
y=y-1
MOY1=MOY1-1
DrawImage HGrundH, 0,0
DrawImage Bild2, MOX1,MOY1
DrawImage rocket, x,y
Delay 2
    Flip
Cls
Until y=6-50
ClsVB
ClsColor 1,255,1
Cls
Schrift = LoadFont ("Arial",30,20100)
SetFont Schrift
Color 1,1,1
Print "Dein Feind hat dich entführt!"
Print "Löse alle 20 Aufgaben um wieder"
Print "zu deinem Haus zu gelangen."
Print "Steure deine Spielfigur mit den Pfeiltasten"
Print "Viel Glück!"
Input()
FreeSound kamelpiano
FreeSound kamelpianoP
kamelpiano=LoadSound (".\Sounds\kamelpiano.mp3")
LoopSound kamelpiano
kamelpianoP=PlaySound(kamelpiano)
Goto Teil1
End


Function ClsVB()
FreeImage Bild
FreeImage HGrundH
FreeImage Bild1
FreeImage Bild2
FreeImage Bild3
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