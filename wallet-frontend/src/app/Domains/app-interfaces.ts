export interface Transaction {
    info:string;
    price: number;
    date: Date;
}

export interface Income extends Transaction {
    cathegory: IncomeCathegory;
    flag:boolean;
}

export enum IncomeCathegory {
    SALARY, DONATION
}

export interface Expense extends Transaction {
    cathegory: ExpenseCathegory;
    flag: boolean;
}

export enum ExpenseCathegory {
    FOOD, CLOTHES, UTILS, GOODIES
}

export interface NewUserDTO {
    username: string;
    password: string;
}