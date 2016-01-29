.model small
.stack
.data
mensaje db 'suma:','$'
.code
main proc
mov ax,seg mensaje
mov ds,ax
mov ah,09
lea dx,mensaje
int 21h
MOV AL,4

MOV BL,1

SUB AL,BL

mov dl,al
add dl,48
mov ah,02
int 21h
mov ax,4c00h
int 21h
main endp
end main
