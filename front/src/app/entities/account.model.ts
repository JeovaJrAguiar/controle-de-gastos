export class Account {
    private _id: number ;
    private _username: string;
    private _mail: string;
    private _password: string;
    private _fullName: string;
    private _documentNumber: number;
    private _address: string;
    private _creationDate: string;
    private _deletionDate: string;
  
    constructor(
      id: number,
      username: string,
      mail: string,
      password: string,
      fullName: string,
      documentNumber: number,
      address: string,
      creationDate: string,
      deletionDate: string
    ) {
      this._id = id;
      this._username = username;
      this._mail = mail;
      this._password = password;
      this._fullName = fullName;
      this._documentNumber = documentNumber;
      this._address = address;
      this._creationDate = creationDate;
      this._deletionDate = deletionDate;
    }
  
    // Getters
    get id(): number {
      return this._id;
    }
  
    get username(): string {
      return this._username;
    }
  
    get mail(): string {
      return this._mail;
    }
  
    get password(): string {
      return this._password;
    }
  
    get fullName(): string {
      return this._fullName;
    }
  
    get documentNumber(): number {
      return this._documentNumber;
    }
  
    get address(): string {
      return this._address;
    }
  
    get creationDate(): string {
      return this._creationDate;
    }
  
    get deletionDate(): string {
      return this._deletionDate;
    }
  
    // Setters
    set username(value: string) {
      this._username = value;
    }
  
    set mail(value: string) {
      this._mail = value;
    }
  
    set password(value: string) {
      this._password = value;
    }
  
    set fullName(value: string) {
      this._fullName = value;
    }
  
    set documentNumber(value: number) {
      this._documentNumber = value;
    }
  
    set address(value: string) {
      this._address = value;
    }
  
    set creationDate(value: string) {
      this._creationDate = value;
    }
  
    set deletionDate(value: string) {
      this._deletionDate = value;
    }
  
  
    // Método de fábrica para criar instância a partir de objeto JSON
    static fromJson(json: any): Account {
      return new Account(
        json._id,
        json._username,
        json._mail,
        json._password,
        json._fullName,
        json._documentNumber,
        json._address,
        json._creationDate,
        json._deletionDate
      );
    }

    static fromJsonObj(json: any): Account {
        return new Account(
          json.id,
          json.username,
          json.mail,
          json.password,
          json.fullName,
          json.documentNumber,
          json.address,
          json.creationDate,
          json.deletionDate
        );
      }
}