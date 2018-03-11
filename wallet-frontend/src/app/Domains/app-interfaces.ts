export interface Transaction {
    info:string;
    price: number;
    date: Date;
    flag:boolean;
}

export interface Income extends Transaction {
    cathegory: IncomeCathegory;
}

export enum IncomeCathegory {
    SALARY, DONATION
}

export interface Expense extends Transaction {
    cathegory: ExpenseCathegory;
}

export enum ExpenseCathegory {
    FOOD, CLOTHES, UTILS, GOODIES
}

export interface NewUserDTO {
    username: string;
    password: string;
}